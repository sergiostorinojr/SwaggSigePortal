package br.com.swaggsige.model.service.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.swaggsige.controller.json.ControllerJsonCliente;
import br.com.swaggsige.controller.service.ClienteLocalService;
import br.com.swaggsige.model.domain.Cliente;

@Path("/cliente")
@Stateless
public class ClienteServiceWs implements Serializable {
	
	@EJB(beanName = "ClienteService")
   private ClienteLocalService clienteService;
    
	public ClienteServiceWs() {
		// getAll();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getAll() {
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	listaClientes.addAll(clienteService.getAll());

		String bindJsonCliente = ControllerJsonCliente
				.getBindListJson(listaClientes);

		return Response.ok(bindJsonCliente).build();

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getById(@PathParam("id") Long id) {
		Cliente cliente = clienteService.getById(id);

		String bindClienteJson = ControllerJsonCliente
				.getBindObjectJson(cliente);

		return Response.ok(bindClienteJson).build();

	}

	@GET
	@Path("/cpf/{cpf}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getByCPF(@PathParam("cpf") String cpf) {
		Cliente cliente = clienteService.getByCpf(cpf);

		String bindClienteJson = ControllerJsonCliente
				.getBindObjectJson(cliente);

		return Response.ok(bindClienteJson).build();

	}

}
