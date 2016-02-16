package br.com.swaggsige.model.service.exception;

public class PersistenceException extends  Exception{
	
	public PersistenceException(String msg, Exception e) {
		super(msg, e);
	}
	
	public PersistenceException(String msg) {
		super(msg);
	}

}
