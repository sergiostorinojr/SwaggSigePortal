package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "fabricante", indexes = {
		@Index(name = "IDX_FABRICANTE_NOME", columnList = "nome"),
		@Index(name = "IDX_FABRICANTE_RAZAO_SOCIAL", columnList = "razaoSocial"),
		@Index(name = "IDX_FABRICANTE_RG", columnList = "rg"),
		@Index(name = "IDX_FABRICANTE_CPF", columnList = "cpf"),
		@Index(name = "IDX_FABRICANTE_CNPJ", columnList = "cnpj"),
		@Index(name = "IDX_FABRICANTE_INSCESTADUAL", columnList = "inscEstadual"),
		@Index(name = "IDX_FABRICANTE_DATACADASTRO", columnList = "dataCadastro")}, 
		uniqueConstraints = { @UniqueConstraint(name = "FABRICANTE_UQ", columnNames = {
		"nome", "rg", "cpf", "cnpj", "inscEstadual" }) })
public class Fabricante extends Pessoa implements Serializable {

	@Column(name = "razaoSocial", length = 60)
	private String RazaoSocial;

	@Column(name = "cpf", length = 20)
	private String cpf;

	@Column(name = "cnpj", length = 20)
	private String cnpj;

	@Column(name = "inscEstadual", length = 20)
	private String inscEstadual;

	@Column(name = "inscMunicipal", length = 20)
	private String inscMunicipal;

	@Column(name = "rg", length = 20)
	private String rg;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataCadastro")
	private Date datCadastrado;

	@OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL)
	private List<EnderecoFabricante> enderecoFabricante;

	public Fabricante() {
		// TODO Auto-generated constructor stub
	}

	public final String getRazaoSocial() {
		return RazaoSocial;
	}

	public final String getCpf() {
		return cpf;
	}

	public final String getCnpj() {
		return cnpj;
	}

	public final String getInscEstadual() {
		return inscEstadual;
	}

	public final String getInscMunicipal() {
		return inscMunicipal;
	}

	public final String getRg() {
		return rg;
	}

	public final Date getDatCadastrado() {
		return datCadastrado;
	}

	public final List<EnderecoFabricante> getEnderecoFabricante() {
		return enderecoFabricante;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setDatCadastrado(Date datCadastrado) {
		this.datCadastrado = datCadastrado;
	}

	public void setEnderecoFabricante(
			List<EnderecoFabricante> enderecoFabricante) {
		this.enderecoFabricante = enderecoFabricante;
	}

}
