package br.com.swaggsige.model.service.exception;


/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class EmailException extends Exception{
	
	public EmailException(String msg, Exception e) {
		super(msg, e);
	}
	
	public EmailException(String msg) {
		super(msg);	
	}

}
