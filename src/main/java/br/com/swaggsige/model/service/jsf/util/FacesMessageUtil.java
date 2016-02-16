package br.com.swaggsige.model.service.jsf.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 22/11/2015 - 03:10:53
 *
 * 
 *
 */
public class FacesMessageUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public FacesMessageUtil() {
	}
	
	public static void addMsgError(String msgError){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msgError, ""));
		
		
	}
	
	public static void addMsgInfo(String msgError){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, msgError, ""));
		
		
	}
	
	public static void addMsgFatalError(String msgError){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_FATAL, msgError, ""));
		
		
	}

}
