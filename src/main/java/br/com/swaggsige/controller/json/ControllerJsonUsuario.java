package br.com.swaggsige.controller.json;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;

import br.com.swaggsige.model.domain.Usuario;
import br.com.swaggsige.model.service.json.util.JsonBaseProducer;
import br.com.swaggsige.model.service.json.util.JsonLocal;
import br.com.swaggsige.model.service.json.util.JsonRemote;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 26/11/2015 - 09:58:14
 *
 */
@Stateless
@RequestScoped
public class ControllerJsonUsuario implements Serializable, JsonRemote<Usuario>, JsonLocal<Usuario> {
	
	public ControllerJsonUsuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toJson(Usuario obj) {
		return new JsonBaseProducer<Usuario>(Usuario.class).toJson(obj);
	}

	@Override
	public String listaToJson(Collection<Usuario> lista) {
		return new JsonBaseProducer<Usuario>(Usuario.class).listaToJson(lista);
	}

	@Override
	public Object fromJson(String obj) {
		return new JsonBaseProducer<Usuario>(Usuario.class).fromJson(obj);
	}

	@Override
	public Collection<Usuario> jsonFromList(String lista) {
		return new JsonBaseProducer<Usuario>(Usuario.class).jsonFromList(lista);
	}

}
