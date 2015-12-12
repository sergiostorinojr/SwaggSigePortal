package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum PermissaoAcesso implements Serializable{

	 FINANCEIRO, ESTOQUE,COMPRAS,CADASTRO, ADMINISTRADOR, CLIENTE;

}
