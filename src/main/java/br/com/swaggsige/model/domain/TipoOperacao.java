package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum TipoOperacao implements Serializable{

	COBRANCA, DEPOSITO, EMPRESTIMO, ORDEMPAGAMENTO, RENDIMENTO, RESGATE, APLICACOES, CHEQUES, 
	CHEQUESDEVOLVIDOS, DEBITOCONTA, PAGAMENTOS, SAQUES, TARIFAS;

}
