package br.com.swaggsige.model.service.mail;

import java.io.Serializable;

import javax.ejb.Stateless;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@Stateless
public class AutenticadorGmail implements Serializable{

	private static EmailTextServiceUtil emailService;
	private final static String EMAIL_AUTENTICACAO = "swaggsige@gmail.com";
	private final static String SENHA_AUTENTICACAO = "";
	private final static String SERVIDOR_SMTP = "smtp.gmail.com";
	private final static String PORTA_SMTP = "465";
	private final static boolean SSL = true;
	private final static boolean TTLS = false;

	public AutenticadorGmail() {
		// TODO Auto-generated constructor stub
	}
	
	public static void autenticarEmail() {
		
		boolean autenticar = false;
		
		if(emailService == null && autenticar == false){
			
			
			emailService = new EmailTextServiceUtil(EMAIL_AUTENTICACAO,
					SENHA_AUTENTICACAO, SERVIDOR_SMTP, PORTA_SMTP, SSL, TTLS);
			autenticar = true;
		}
		//return autenticar;
	}
	
	public void enviarEmail(String emailCorpo){
		//if(autenticarEmail()){
			
			
		//}
	}

}
