package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
 * @01:12:06
 *
 *
 */

@XmlRootElement
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "Pessoa_SEQ", sequenceName = "Pessoa_SEQ", allocationSize = 1, initialValue = 1)
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Pessoa_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "nome", length = 60)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", length = 15)
	private Situacao situacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoPessoa", length = 15)
	private TipoPessoa tipo;

	@Column(name = "telefone", length = 18)
	private String telefone;

	@Column(name = "celular", length = 18)
	private String celular;

	@Column(name = "email", length = 20)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataNascimento")
	private Date dataNascimento;

	public Pessoa() {
	}

	public Pessoa(Long id, String nome, Situacao situacao, TipoPessoa tipo,
			String telefone, String celular, String email, Date dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.situacao = situacao;
		this.tipo = tipo;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public final String getNome() {
		return nome;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public final TipoPessoa getTipo() {
		return tipo;
	}

	public final String getTelefone() {
		return telefone;
	}

	public final String getCelular() {
		return celular;
	}

	public final String getEmail() {
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public final Long getId() {
		return id;
	}

	public final Date getDataNascimento() {
		return dataNascimento;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", situacao=" + situacao
				+ ", tipo=" + tipo + ", telefone=" + telefone + ", celular="
				+ celular + ", email=" + email + ", dataNascimento="
				+ dataNascimento + "]";
	}

}
