package br.com.swaggsige.model.service.json.util;

import java.util.Collection;

import javax.ejb.Remote;

/**
 * 
 *  SwaggSigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *  @2016
 *  @09:11:13
 *
 *  @param <T>
 *
 */
@Remote
public interface JsonRemote<T> {

	public String toJson(T obj);

	public String listaToJson(Collection<T> lista);

	public Object fromJson(String obj);

	public Collection<T> jsonFromList(String lista);

}
