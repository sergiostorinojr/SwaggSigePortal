package br.com.swaggsige.model.service.json.util;

import java.util.Collection;

import javax.ejb.Local;

import br.com.swaggsige.model.domain.AbstractEntity;

/**
 * 
 * SwaggSigePortal
 * @author S�rgio Junior - sergio.storinojr@gmail.com
 * 
 */
@Local
public interface JsonLocal<T extends AbstractEntity> {
	
	public String toJson(T obj);
	public String listaToJson(Collection<T> lista);
	public Object fromJson(String obj);
	public Collection<T> jsonFromList(String lista);

}
