package br.com.swaggsige.controller.json;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.service.json.util.BindParserJsonCliente;
import br.com.swaggsige.model.service.json.util.BindParserJsonLocal;
import br.com.swaggsige.model.service.json.util.BindParserJsonRemote;
import br.com.swaggsige.model.service.json.util.JsonBaseProducer;
import br.com.swaggsige.model.service.json.util.JsonLocal;
import br.com.swaggsige.model.service.json.util.JsonRemote;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 26/11/2015 - 09:52:36
 *
 */
@Stateless
@RequestScoped
public class ControllerJsonCliente implements  JsonRemote<Cliente> ,JsonLocal<Cliente> {
	
	public ControllerJsonCliente() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toJson(Cliente obj) {
		return new JsonBaseProducer<Cliente>(Cliente.class).toJson(obj);
	}

	@Override
	public String listaToJson(Collection<Cliente> lista) {
		return new JsonBaseProducer<Cliente>(Cliente.class).listaToJson(lista);
	}

	@Override
	public Object fromJson(String obj) {
		return new JsonBaseProducer<Cliente>(Cliente.class).fromJson(obj);
	}

	@Override
	public Collection<Cliente> jsonFromList(String lista) {
		return new JsonBaseProducer<Cliente>(Cliente.class).jsonFromList(lista);
	}

	public static String getBindListJson(List<Cliente> listaClientes) {
		return new BindParserJsonCliente().getBindListJson(listaClientes);
	}

	public static String getBindObjectJson(Cliente cliente) {
		return new BindParserJsonCliente().getBindObjectJson(cliente);
	}

	

}
