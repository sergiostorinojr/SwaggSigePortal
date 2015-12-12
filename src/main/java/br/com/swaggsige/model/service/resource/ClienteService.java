package br.com.swaggsige.model.service.resource;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.service.jpa.repository.ClienteRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@Stateless
@Path("/cliente")
public class ClienteService implements Serializable{
	
	@Inject
	private ClienteRepository clienteRepository;
	
	public ClienteService() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProduct() {

		

		return Response.ok().build();

	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		
		    
		
		List<Cliente> list = (List<Cliente>) new ClienteRepository().getAll();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
	
		Gson g = new Gson();
		String tt= "aaaa";
		
		return Response.ok(g.toJson(list)).build();
	}

}
