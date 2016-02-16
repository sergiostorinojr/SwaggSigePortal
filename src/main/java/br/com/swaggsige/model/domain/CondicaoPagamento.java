package br.com.swaggsige.model.domain;

import java.io.Serializable;

/**
 * 
 * SwaggSigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 *
 *
 */
public enum CondicaoPagamento implements Serializable {

	AVISTA("A Vista"), APRAZO("A Prazo");

	private String apelido;

	private CondicaoPagamento(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}

}
