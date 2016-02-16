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
 * @20:17:49
 *
 *
 */
public enum TipoCompra implements Serializable {

	SERVICO("Serviço"), 
	PRODUTO("Produto"), 
	MATERIAL_INTERNO("Material Interno");

	private String apelido;

	private TipoCompra(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}

}
