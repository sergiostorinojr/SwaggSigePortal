package br.com.swaggsige.controller.bean;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.swaggsige.model.service.exception.EmailException;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;
import br.com.swaggsige.model.service.mail.EmailTextServiceUtil;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@ManagedBean
@ViewScoped
@Stateless
public class EmailTesteMB implements Serializable {
	
	private EmailTextServiceUtil email = new EmailTextServiceUtil();
	
	public EmailTesteMB() {
		System.out.println("Um Novo Bean Criado para email");
	}
	
	public void enviar(){
	
		try {
			email.Envio();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
		FacesMessageUtil.addMsgInfo("Email enviado com sucesso");
		
		
	}

	public final EmailTextServiceUtil getEmail() {
		return email;
	}

	public void setEmail(EmailTextServiceUtil email) {
		this.email = email;
	}
	
	
	

}
