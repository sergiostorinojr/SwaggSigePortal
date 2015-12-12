package br.com.swaggsige.model.service.jsf.handler;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.service.exception.NegocioException;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class JsfExceptionHandler extends ExceptionHandlerWrapper implements Serializable{

	private ExceptionHandler wrapped;
	private static Log log = LogFactory.getLog(JsfExceptionHandler.class);
	
	
	public JsfExceptionHandler(ExceptionHandler wrapped) {
		super();
		this.wrapped = wrapped;
	}
	
	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	/**
	 * Método responsavel por retornar a exceção lançadas pelo JSF
	 */
	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();
		
		while(events.hasNext()){
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			
			Throwable exception = context.getException();
			NegocioException negocioException = getNegocioException(exception);
			PersistenceException persistenceException = getPersistenceException(exception);
			
			boolean handled = false;
			
			try{
				if(exception instanceof ViewExpiredException){
					handled = true;
					log.error("erro de expiração da pagina: "+ exception.getMessage(), exception);
					redirect("/");
					
				} else if(negocioException != null){
					handled = true;
					log.error("erro na regra de Negocio: "+ negocioException.getMessage(), negocioException);
					FacesMessageUtil.addMsgError(negocioException.getMessage());
					
				} else if(persistenceException != null){
					handled = true;
					log.error("Falha na persistencia dos dados: "+ persistenceException.getMessage(), persistenceException);
					FacesMessageUtil.addMsgError(persistenceException.getMessage());
				
				} else {
					handled = true;
					log.error("erro do sistema: "+ exception.getMessage(), exception);
					redirect("/erro.xhtml");
				}
				
			} finally {
				
				if(handled){
					
					events.remove();
				
				}
			}
		}
		
		
		getWrapped().handle();
	}
	
	private PersistenceException getPersistenceException(Throwable exception) {
		if(exception instanceof PersistenceException){
					
					return (PersistenceException) exception;
				} else if(exception.getCause() != null){
					
					return getPersistenceException(exception.getCause());
				}
				
				return null;
	}

	private NegocioException getNegocioException(Throwable exception) {
		if(exception instanceof NegocioException){
			
			return (NegocioException) exception;
		} else if(exception.getCause() != null){
			
			return getNegocioException(exception.getCause());
		}
		
		return null;
	}


	private void redirect(String pagina) {
	
		try {
			
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		String contextPath = externalContext.getRequestContextPath();
		
			externalContext.redirect(contextPath + pagina);
			facesContext.responseComplete();
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new FacesException(e);
		} 
		
	}
	

}
