package br.com.swaggsige.model.service.resource;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

@Local
public interface ServiceCliente {

	public Response getAll();
}
