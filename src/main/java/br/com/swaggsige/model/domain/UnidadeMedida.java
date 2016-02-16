package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * SigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 * @2016
 * @20:29:27
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "unMedida", indexes = {
		@Index(name = "IDX_UNMEDIDA_UNIDADE", columnList = "unidade"),
		@Index(name = "IDX_UNMEDIDA_DESCRICAO", columnList = "descricao") }, uniqueConstraints = { @UniqueConstraint(name = "UNIDADEMEDIDA_UQ", columnNames = {
		"unidade", "descricao" }) })
@NamedQueries({
		@NamedQuery(name = "unMedida.searchAll", query = "SELECT u FROM UnidadeMedida u"),
		@NamedQuery(name = "unMedida.searchDescricao", query = "SELECT u FROM UnidadeMedida u  WHERE  u.descricao LIKE :descricao"),
		@NamedQuery(name = "unMedida.searchUnidade", query = "SELECT u FROM UnidadeMedida u  WHERE  u.unidade LIKE :unidade") })
@SequenceGenerator(name = "UnidadeMedida_SEQ", sequenceName = "UnidadeMedida_SEQ", allocationSize = 1, initialValue = 1)
public class UnidadeMedida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UnidadeMedida_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "unidade", length = 2)
	private String unidade;

	@Column(name = "descricao")
	private String descricao;

	public UnidadeMedida() {
	}

	public UnidadeMedida(Long id, String unidade, String descricao) {
		this.id = id;
		this.unidade = unidade;
		this.descricao = descricao;
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

	public final Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeMedida other = (UnidadeMedida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
