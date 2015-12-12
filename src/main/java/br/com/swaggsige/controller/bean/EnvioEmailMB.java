package br.com.swaggsige.controller.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.swaggsige.controller.mail.ControllerMailer;
import br.com.swaggsige.model.domain.Marca;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;

import com.outjected.email.api.MailMessage;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@ManagedBean
@ViewScoped
@Stateless
public class EnvioEmailMB implements  Serializable{
	
	private Marca marca = new Marca();
	@EJB
	private ControllerMailer mailer;
	
	public void enviando(){
		MailMessage message;
		try {
			message = mailer.novaMensagem();
			message.to("ti.thiagocamelo@gmail.com")
			.subject("Teste Junior")
			.bodyText("teste 1234 teste 4321")
			.send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		FacesMessageUtil.addMsgInfo("Email enviado com sucesso");
		
	}

}
