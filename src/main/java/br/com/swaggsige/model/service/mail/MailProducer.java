package br.com.swaggsige.model.service.mail;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.controller.mail.ControllerMailer;

import com.outjected.email.api.SessionConfig;
import com.outjected.email.impl.SimpleMailConfig;

@Stateless
public class MailProducer implements Serializable{
	
	private static Log log = LogFactory.getLog(ControllerMailer.class);
	
	private SessionConfig session;
	
	@Produces
	public SessionConfig getMailConfig() throws IOException{
				
		Properties props = new Properties();
		props.load(getClass().getResourceAsStream("/mail.properties"));
		
		SimpleMailConfig config = new SimpleMailConfig();
		config.setUsername(props.getProperty("mail.username"));
		config.setPassword(props.getProperty("mail.password"));
		config.setEnableSsl(Boolean.parseBoolean(props.getProperty("mail.enable.ssl")));
		config.setAuth(Boolean.parseBoolean(props.getProperty("mail.auth")));
		config.setServerHost(props.getProperty("mail.server.host"));
		config.setServerPort(Integer.parseInt(props.getProperty("mail.server.port")));
		
		log.info("Sessão de Email validado Com Sucesso");
		return config;
		
		
		
	}
	
	public MailProducer() {
		// TODO Auto-generated constructor stub
	}

}
