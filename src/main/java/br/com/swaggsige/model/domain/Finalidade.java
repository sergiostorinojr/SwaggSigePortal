package br.com.swaggsige.model.domain;

import java.io.Serializable;
/**
 * 
 *  SigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *  @2016
 *  @17:30:31
 *
 *
 */
public enum Finalidade implements Serializable {

	REVENDA("Revenda"), CONSUMO("Consumo");

	private String apelido;

	private Finalidade(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}
}
