package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum TipoPessoa implements Serializable{

	FISICA, JURIDICA;

}