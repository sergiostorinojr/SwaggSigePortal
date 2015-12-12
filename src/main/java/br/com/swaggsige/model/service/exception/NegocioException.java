package br.com.swaggsige.model.service.exception;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class NegocioException extends Exception {

	public NegocioException(String msg, Exception e) {
		super(msg, e);
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
}
