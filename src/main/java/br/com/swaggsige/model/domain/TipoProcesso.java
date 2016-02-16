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
 * @20:28:08
 *
 *
 */
public enum TipoProcesso implements Serializable {

	ORCAMENTO("Or�amento"), 
	ORDEMSERVICO("Ordem Servi�o"), 
	VENDA("Venda"), 
	ORDEMEVENTO("Ordem Evento");

	private String apelido;

	private TipoProcesso(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}

}
