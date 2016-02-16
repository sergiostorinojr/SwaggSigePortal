package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

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
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "Endereco_SEQ", sequenceName = "Endereco_SEQ", allocationSize = 1, initialValue = 1)
public abstract class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Endereco_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "cep", length = 15)
	private String cep;

	@Column(name = "logradouro", length = 60)
	private String logradouro;

	@Column(name = "numero", length = 6)
	private Long numero;

	@Column(name = "complemento", length = 20)
	private String complemento;

	@Column(name = "bairro", length = 40)
	private String bairro;

	@Column(name = "cidade", length = 40)
	private String cidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "uf", length = 2)
	private UF uf;

	@Column(name = "pais", length = 40)
	private String pais;

	public Endereco() {
	}

	public Endereco(Long id, String cep, String logradouro, Long numero,
			String complemento, String bairro, String cidade, UF uf, String pais) {
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
	}

	public final String getCep() {
		return cep;
	}

	public final String getLogradouro() {
		return logradouro;
	}

	public final Long getNumero() {
		return numero;
	}

	public final String getComplemento() {
		return complemento;
	}

	public final String getBairro() {
		return bairro;
	}

	public final String getCidade() {
		return cidade;
	}

	public final UF getUf() {
		return uf;
	}

	public final String getPais() {
		return pais;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public void setPais(String pais) {
		this.pais = pais;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
