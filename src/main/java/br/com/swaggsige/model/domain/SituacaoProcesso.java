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
 * @20:15:17
 *
 *
 */
public enum SituacaoProcesso implements Serializable {

	EXCLUIDO("Excluido"), EMITIDO("Emitido"), REPROVADO("Reprovado"), SUSPENSO(
			"Suspenso"), ANALISE("Analise");

	private String apelido;

	private SituacaoProcesso(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}

}
