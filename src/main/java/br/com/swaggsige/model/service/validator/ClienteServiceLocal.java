package br.com.swaggsige.model.service.validator;

import javax.ejb.Local;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Local
public interface ClienteServiceLocal {
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") Long id);
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByName(@QueryParam("name") String name);
	
	@PUT
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@FormParam("name") String name,
						   @FormParam("situacao") String situacao,
						   @FormParam("tipoPessoa") String tipoPessoa,
						   @FormParam("telefone") String telefone,
						   @FormParam("celular") String celular,
						   @FormParam("email") String email,
						   @FormParam("dataNascimento") String dataNascimento);
	
	@POST
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id,
							@QueryParam("name") String name);
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id);
	
	

}
