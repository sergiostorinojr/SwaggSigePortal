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
@Table(name = "prateleira", indexes = { 
		@Index(name = "IDX_PRATELEIRA_DESCRICAO", columnList = "descricao") }, uniqueConstraints = { 
		@UniqueConstraint(name = "PRATELEIRA_UQ", columnNames = { "descricao" }) })
public class Prateleira extends AbstractEntity implements Serializable {

	@Column(name = "descricao", length = 60)
	private Long descricao;

	public Prateleira() {
		// TODO Auto-generated constructor stub
	}

	public final Long getDescricao() {
		return descricao;
	}

	public void setDescricao(Long descricao) {
		this.descricao = descricao;
	}

}
