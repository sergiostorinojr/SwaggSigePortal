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
 * @01:10:20
 *
 *
 */
public enum PermissaoAcesso implements Serializable {

	FINANCEIRO("Financeiro"), ESTOQUE("Estoque"), COMPRAS("Compras"), CADASTRO(
			"Cadastros"), ADMINISTRADOR("Administrador"), CLIENTE("Cliente");

	private String apelido;

	private PermissaoAcesso(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}

}
