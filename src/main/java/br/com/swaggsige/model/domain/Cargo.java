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
 * SwaggSigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "cargo", indexes = { @Index(name = "IDX_CARGO_DESCRICAO", columnList = "descricao") }, uniqueConstraints = { @UniqueConstraint(name = "CARGO_UQ", columnNames = { "descricao" }) })
@NamedQueries({
		@NamedQuery(name = "cargo.getAll", query = "SELECT c FROM Cargo c "),
		@NamedQuery(name = "cargo.getAllByDescriptionStartsWith", query = "SELECT c FROM Cargo c WHERE c.descricao LIKE :descricao") })
@SequenceGenerator(name = "Cargo_SEQ", sequenceName = "Cargo_SEQ", allocationSize = 1, initialValue = 1)
public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cargo_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "descricao", length = 60)
	private String descricao;

	public Cargo() {
	}

	public Cargo(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public final String getDescricao() {
		return descricao;
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
		Cargo other = (Cargo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
