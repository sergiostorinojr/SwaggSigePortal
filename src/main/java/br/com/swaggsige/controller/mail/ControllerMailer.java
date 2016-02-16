package br.com.swaggsige.controller.mail;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.swaggsige.model.service.mail.MailProducer;

import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.MailMessageImpl;

@Stateless
public class ControllerMailer implements Serializable{
	
	public MailMessage novaMensagem() throws IOException{
		return new MailMessageImpl(new MailProducer().getMailConfig());
	}

}
