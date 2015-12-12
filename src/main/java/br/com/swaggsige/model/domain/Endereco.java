package br.com.swaggsige.model.domain;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Endereco extends AbstractEntity implements Serializable{

	@Column(name="cep", length=15)
	private String cep;

	@Column(name="logradouro", length=60)
	private String logradouro;

	@Column(name="numero", length=6)
	private Long numero;

	@Column(name="complemento", length=20)
	private String complemento;

	@Column(name="bairro", length=40)
	private String bairro;

	@Column(name="cidade", length=40)
	private String cidade;

	@Enumerated(EnumType.STRING)
	@Column(name="uf", length=2)
	private UF uf;

	@Column(name="pais", length=40)
	private String pais;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
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
	
	


}
