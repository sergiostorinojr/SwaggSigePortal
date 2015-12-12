package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa extends AbstractEntity implements Serializable {

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
		// TODO Auto-generated constructor stub
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

	public final Date getDatNascimento() {
		return dataNascimento;
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

	public void setDatNascimento(Date datNascimento) {
		this.dataNascimento = datNascimento;
	}

}
