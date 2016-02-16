package br.com.swaggsige.model.service.json.util;

import java.util.Collection;

import javax.ejb.Local;

/**
 * 
 * @author Junior
 *
 * @param <T>
 */
@Local
public interface JsonLocal<T > {
	
	public String toJson(T obj);
	public String listaToJson(Collection<T> lista);
	public Object fromJson(String obj);
	public Collection<T> jsonFromList(String lista);

}
