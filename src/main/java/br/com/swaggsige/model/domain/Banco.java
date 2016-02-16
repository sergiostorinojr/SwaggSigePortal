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
@Table(name = "banco", indexes = { @Index(name = "IDX_BANCO_CODBANCO", columnList = "codigoBanco") }, uniqueConstraints = { @UniqueConstraint(name = "BANCO_UQ", columnNames = { "codigoBanco" }) })
@NamedQueries({
		@NamedQuery(name = "banco.getAll", query = "SELECT b FROM Banco b "),
		@NamedQuery(name = "banco.getAllByNameBankStartsWith", query = "SELECT b FROM Banco b WHERE b.nomeBanco LIKE :nomeBanco") })
@SequenceGenerator(name = "Banco_SEQ", sequenceName = "Banco_SEQ", allocationSize = 1, initialValue = 1)
public class Banco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Banco_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "codigoBanco")
	private Long codigoBanco;

	@Column(name = "descricaoBanco", nullable = false, length = 60)
	private String nomeBanco;

	public Banco() {
	}

	public Banco(Long id, Long codigoBanco, String nomeBanco) {
		this.id = id;
		this.codigoBanco = codigoBanco;
		this.nomeBanco = nomeBanco;
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
		Banco other = (Banco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
