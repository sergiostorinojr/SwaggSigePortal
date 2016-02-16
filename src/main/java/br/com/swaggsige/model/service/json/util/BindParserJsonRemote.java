package br.com.swaggsige.model.service.json.util;

import java.util.List;

import javax.ejb.Remote;

/**
 * 
 *  SwaggSigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *  @2016
 *  @09:10:38
 *
 *  @param <T>
 *
 */
@Remote
public interface BindParserJsonRemote<T> {

	public String getBindListJson(List<T> obj);

	public String getBindObjectJson(T obj);

}
