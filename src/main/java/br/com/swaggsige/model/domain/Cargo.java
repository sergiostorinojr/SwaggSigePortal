package br.com.swaggsige.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "cargo", indexes = { @Index(name = "IDX_CARGO_DESCRICAO", columnList = "descricao") }, 
			uniqueConstraints = { @UniqueConstraint(name = "CARGO_UQ", columnNames = { "descricao" }) })
public class Cargo extends AbstractEntity {

	@Column(name = "descricao", length = 60)
	private String descricao;

	public Cargo() {
	}

	public final String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
