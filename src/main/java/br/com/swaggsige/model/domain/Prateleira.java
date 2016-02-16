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
 * @16:04:56
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "prateleira", indexes = { @Index(name = "IDX_PRATELEIRA_DESCRICAO", columnList = "descricao") }, uniqueConstraints = { @UniqueConstraint(name = "PRATELEIRA_UQ", columnNames = { "descricao" }) })
@NamedQueries({
		@NamedQuery(name = "prateleira.searchAll", query = "SELECT p FROM Prateleira p"),
		@NamedQuery(name = "prateleira.searchDescricao", query = "SELECT p FROM Prateleira p  WHERE  p.descricao LIKE :descricao") })
@SequenceGenerator(name = "Prateleira_SEQ", sequenceName = "Prateleira_SEQ", allocationSize = 1, initialValue = 1)
public class Prateleira implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Prateleira_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "descricao", length = 60)
	private Long descricao;

	public Prateleira() {
	}

	public Prateleira(Long id, Long descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public final Long getDescricao() {
		return descricao;
	}

	public void setDescricao(Long descricao) {
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
		Prateleira other = (Prateleira) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
