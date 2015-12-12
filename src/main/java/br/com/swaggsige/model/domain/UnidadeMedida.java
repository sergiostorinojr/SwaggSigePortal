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
@Table(name = "unMedida", indexes = {
		@Index(name = "IDX_UNMEDIDA_UNIDADE", columnList = "unidade"),
		@Index(name = "IDX_UNMEDIDA_DESCRICAO", columnList = "descricao") }, 
		uniqueConstraints = { @UniqueConstraint(name = "UNIDADEMEDIDA_UQ", columnNames = {
		"unidade", "descricao" }) })
public class UnidadeMedida extends AbstractEntity implements Serializable {

	@Column(name = "unidade", length = 2)
	private String unidade;

	@Column(name = "descricao")
	private String descricao;

	public UnidadeMedida() {
		// TODO Auto-generated constructor stub
	}

	public final String getUnidade() {
		return unidade;
	}

	public final String getDescricao() {
		return descricao;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
