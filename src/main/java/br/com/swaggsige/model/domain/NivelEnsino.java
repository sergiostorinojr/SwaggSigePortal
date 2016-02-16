package br.com.swaggsige.model.domain;

import java.io.Serializable;

/**
 * 
 * SigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 * @2016
 * @22:48:34
 *
 *
 */
public enum NivelEnsino implements Serializable {

	FUNDAMENTAL("Fundamental"), MEDIO("Médio"), SUPERIOR("Superior");

	private String apelido;

	private NivelEnsino(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}

}
