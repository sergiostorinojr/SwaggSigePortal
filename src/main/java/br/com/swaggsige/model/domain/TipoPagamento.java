package br.com.swaggsige.model.domain;

import java.io.Serializable;

/**
 * 
 * SigePortal
 *
 * @Author: S�rgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 * @2016
 * @20:23:56
 *
 *
 */
public enum TipoPagamento implements Serializable {

	DINHEIRO("Dinheiro"),
	BOLETO("Boleto"), 
	CARTAO("Cart�o"), 
	DEPOSITO("Dep�sito");

	private String apelido;

	private TipoPagamento(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}

}
