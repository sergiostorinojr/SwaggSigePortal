package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "banco", indexes = { @Index(name = "IDX_BANCO_CODBANCO", columnList = "codigoBanco") }, 
		uniqueConstraints = { @UniqueConstraint(name = "BANCO_UQ", columnNames = { "codigoBanco" }) })
public class Banco extends AbstractEntity implements Serializable {

	@Column(name = "codigoBanco")
	private Long codigoBanco;

	@Column(name = "descricaoBanco", nullable = false, length = 60)
	private String nomeBanco;

	public Banco() {
	}

	public final Long getCodigoBanco() {
		return codigoBanco;
	}

	public final String getNomeBanco() {
		return nomeBanco;
	}

	public void setCodigoBanco(Long codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

}
