package br.com.swaggsige.model.service.exception;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class PersistenceException extends  Exception{
	
	public PersistenceException(String msg, Exception e) {
		super(msg, e);
	}
	
	public PersistenceException(String msg) {
		super(msg);
	}

}
