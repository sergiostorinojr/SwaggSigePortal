package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum TipoOrcamento implements Serializable {

	INDETERMINADO, DIARIO, SEMANAL, MENSAL, TRIMESTRAL, SEMESTRAL, ANUAL;

}
