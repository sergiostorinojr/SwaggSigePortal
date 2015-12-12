package br.com.swaggsige.controller.json;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;

import br.com.swaggsige.model.domain.ContasReceber;
import br.com.swaggsige.model.service.json.util.JsonBaseProducer;
import br.com.swaggsige.model.service.json.util.JsonLocal;
import br.com.swaggsige.model.service.json.util.JsonRemote;

/**
 * 
 *  SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 26/11/2015 - 10:42:50
 *
 */
@Stateless
@RequestScoped
public class ControllerGsonContasReceber implements Serializable, JsonRemote<ContasReceber>, JsonLocal<ContasReceber> {

	public ControllerGsonContasReceber() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toJson(ContasReceber obj) {
		return new JsonBaseProducer<ContasReceber>(ContasReceber.class).toJson(obj);
	}

	@Override
	public String listaToJson(Collection<ContasReceber> lista) {
		return new JsonBaseProducer<ContasReceber>(ContasReceber.class).listaToJson(lista);
	}

	@Override
	public Object fromJson(String obj) {
		return new JsonBaseProducer<ContasReceber>(ContasReceber.class).fromJson(obj);
	}

	@Override
	public Collection<ContasReceber> jsonFromList(String lista) {
		return new JsonBaseProducer<ContasReceber>(ContasReceber.class).jsonFromList(lista);
	}

}
