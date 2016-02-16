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
 * @20:19:01
 *
 *
 */
public enum TipoOperacao implements Serializable {

	COBRANCA("Cobran�a"), 
	DEPOSITO("Deposito"), 
	EMPRESTIMO("Empr�stimo"), 
	ORDEMPAGAMENTO("Ordem Pagamento"), 
	RENDIMENTO("Rendimento"), 
	RESGATE("Resgate"), 
	APLICACOES("Aplica��es"), 
	CHEQUES("Cheques"), 
	CHEQUESDEVOLVIDO("Cheques Devolvidos"), 
	DEBITOCONTA("Debito Conta"), 
	PAGAMENTOS("Pagamentos"), 
    SAQUES("Saques"), 
    TARIFAS("Tarifas");

	private String apelido;

	private TipoOperacao(String apelido) {
		this.apelido = apelido;
	}

	public final String getApelido() {
		return apelido;
	}

}
