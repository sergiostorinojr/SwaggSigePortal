package br.com.swaggsige.controller.json;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.Remote;
import javax.faces.bean.RequestScoped;

import br.com.swaggsige.model.domain.Processo;
import br.com.swaggsige.model.service.json.util.JsonBaseProducer;
import br.com.swaggsige.model.service.json.util.JsonLocal;
import br.com.swaggsige.model.service.json.util.JsonRemote;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@Remote
@RequestScoped
public class ControllerGsonProcesso implements Serializable, JsonRemote<Processo>, JsonLocal<Processo>  {

	public ControllerGsonProcesso() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toJson(Processo obj) {
		return new JsonBaseProducer<Processo>(Processo.class).toJson(obj);
	}

	@Override
	public String listaToJson(Collection<Processo> lista) {
		return new JsonBaseProducer<Processo>(Processo.class).listaToJson(lista);
	}

	@Override
	public Object fromJson(String obj) {
		return new JsonBaseProducer<Processo>(Processo.class).fromJson(obj);
	}

	@Override
	public Collection<Processo> jsonFromList(String lista) {
		return new JsonBaseProducer<Processo>(Processo.class).jsonFromList(lista);
	}

}
