package br.com.swaggsige.model.service.exception;

public class NegocioException extends Exception {

	public NegocioException(String msg, Exception e) {
		super(msg, e);
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
}
