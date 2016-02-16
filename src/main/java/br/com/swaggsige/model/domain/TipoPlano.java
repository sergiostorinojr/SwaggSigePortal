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
 * @20:26:49
 *
 *
 */
public enum TipoPlano implements Serializable {

	RECEITAS("Receitas"), 
	DEPESASOPERACIONAIS("Despesas Operacionais"), 
	DESPESASNAOOPERACIONAIS("Despesas não Operacionais");
	
	private String apelido;

	private TipoPlano(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}
	
	

}
