package br.com.swaggsige.controller.ws;

import java.io.Serializable;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.domain.Marca;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.jpa.BaseRepository;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class ControleTesteCliente implements Serializable {
	
	public Cliente salveOrUpdate(Cliente cliente) throws PersistenceException{
		return new BaseRepository<Cliente>(Cliente.class).saveOrUpdate(cliente);
	}
	
	public Marca findById(Long id){
		return new BaseRepository<Marca>(Marca.class).findById(id);
	}

}
