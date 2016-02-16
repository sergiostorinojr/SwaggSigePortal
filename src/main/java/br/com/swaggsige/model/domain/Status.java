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
 * @20:16:29
 *
 *
 */
public enum Status implements Serializable {

	ABERTO("Aberto"), BAIXADO("Baixado"), PARCIAL("Parcial"), CANCELADO(
			"Cancelado"), EXCLUIDO("Excluido");

	private String apelido;

	private Status(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}

}
