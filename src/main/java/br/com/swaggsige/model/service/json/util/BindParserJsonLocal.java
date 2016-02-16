package br.com.swaggsige.model.service.json.util;

import java.util.List;

import javax.ejb.Local;

/**
 * 
 *  SwaggSigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *  @2016
 *  @09:10:45
 *
 *  @param <T>
 *
 */
@Local
public interface BindParserJsonLocal<T> {

	public  String getBindListJson(List<T> obj);
	
	public String getBindObjectJson(T obj);

}
