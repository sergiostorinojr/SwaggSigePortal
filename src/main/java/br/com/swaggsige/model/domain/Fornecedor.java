package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "fornecedor", indexes = {
		@Index(name = "IDX_FORNECEDOR_NOME", columnList = "nome"),
		@Index(name = "IDX_FORNECEDOR_RAZAO_SOCIAL", columnList = "razaoSocial"),
		@Index(name = "IDX_FORNECEDOR_RG", columnList = "rg"),
		@Index(name = "IDX_FORNECEDOR_CPF", columnList = "cpf"),
		@Index(name = "IDX_FORNECEDOR_CNPJ", columnList = "cnpj"),
		@Index(name = "IDX_FORNECEDOR_INSCESTADUAL", columnList = "inscEstadual"),
		@Index(name = "IDX_FORNECEDOR_DATACADASTRO", columnList = "dataCadastro")}, 
		uniqueConstraints = { @UniqueConstraint(name = "FORNECEDOR_UQ", columnNames = {
		"nome", "rg", "cpf", "cnpj", "inscEstadual" }) })
public class Fornecedor extends Pessoa implements Serializable {

	@Column(name = "razaoSocial", length = 60)
	private String razaoSocial;

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

	@OneToMany(mappedBy = "fornecedor")
	private List<EnderecoFornecedor> enderecoFornecedor;

	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	public final String getRazaoSocial() {
		return razaoSocial;
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

	public final List<EnderecoFornecedor> getEnderecoFornecedor() {
		return enderecoFornecedor;
	}



	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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

	public void setEnderecoFornecedor(
			List<EnderecoFornecedor> enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}



}
