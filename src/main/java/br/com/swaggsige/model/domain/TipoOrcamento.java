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
 * @20:22:28
 *
 *
 */
public enum TipoOrcamento implements Serializable {

	INDETERMINADO("Indeterminado"), 
	DIARIO("Diario"), 
	SEMANAL("Semanal"), 
	MENSAL("Mensal"), 
	TRIMESTRAL("Trimestral"), 
	SEMESTRAL("Semestral"), 
	ANUAL("Anual");

	private String apelido;

	private TipoOrcamento(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}

}
