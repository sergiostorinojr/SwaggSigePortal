package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
 * @17:31:17
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "fornecedor", indexes = {
		@Index(name = "IDX_FORNECEDOR_NOME", columnList = "nome"),
		@Index(name = "IDX_FORNECEDOR_RAZAO_SOCIAL", columnList = "razaoSocial"),
		@Index(name = "IDX_FORNECEDOR_RG", columnList = "rg"),
		@Index(name = "IDX_FORNECEDOR_CPF", columnList = "cpf"),
		@Index(name = "IDX_FORNECEDOR_CNPJ", columnList = "cnpj"),
		@Index(name = "IDX_FORNECEDOR_INSCESTADUAL", columnList = "inscEstadual"),
		@Index(name = "IDX_FORNECEDOR_DATACADASTRO", columnList = "dataCadastro") }, uniqueConstraints = { @UniqueConstraint(name = "FORNECEDOR_UQ", columnNames = {
		"nome", "rg", "cpf", "cnpj", "inscEstadual" }) })
@NamedQueries({
		@NamedQuery(name = "fornecedor.searchAll", query = "SELECT f FROM Fornecedor f INNER JOIN f.enderecoFornecedor ef WHERE f.id = ef.fornecedor.id"),
		@NamedQuery(name = "fornecedor.searchAllByNameStartsWith", query = "SELECT f FROM Fornecedor f INNER JOIN f.enderecoFornecedor ef WHERE f.id = ef.fornecedor.id AND f.nome LIKE :nome"),
		@NamedQuery(name = "fornecedor.searchAllByRazaoSocialStartsWith", query = "SELECT f FROM Fornecedor f INNER JOIN f.enderecoFornecedor ef WHERE f.id = ef.fornecedor.id AND f.razaoSocial LIKE :razaoSocial"),
		@NamedQuery(name = "fornecedor.searchByRG", query = "SELECT f FROM Fornecedor f INNER JOIN f.enderecoFornecedor ef WHERE f.id = ef.fornecedor.id AND f.rg = :rg"),
		@NamedQuery(name = "fornecedor.searchByCPF", query = "SELECT f FROM Fornecedor f INNER JOIN f.enderecoFornecedor ef WHERE f.id = ef.fornecedor.id AND f.cpf = :cpf"),
		@NamedQuery(name = "fornecedor.searchByInscEstadual", query = "SELECT f FROM Fornecedor f INNER JOIN f.enderecoFornecedor ef WHERE f.id = ef.fornecedor.id AND f.inscEstadual = :inscEstadual"),
		@NamedQuery(name = "fornecedor.searchByCNPJ", query = "SELECT f FROM Fornecedor f INNER JOIN f.enderecoFornecedor ef WHERE f.id = ef.fornecedor.id AND f.cnpj =:cnpj "),
		@NamedQuery(name = "fornecedor.searchByRegistrationDate", query = "SELECT f FROM Fornecedor f INNER JOIN f.enderecoFornecedor ef WHERE f.id = ef.fornecedor.id AND f.dataCadastrado BETWEEN :data1 AND :data2 ") })
public class Fornecedor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

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
	private Date dataCadastrado;

	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnderecoFornecedor> enderecoFornecedor;

	public Fornecedor() {
	}

	public Fornecedor(String razaoSocial, String cpf, String cnpj,
			String inscEstadual, String inscMunicipal, String rg,
			Date dataCadastrado, List<EnderecoFornecedor> enderecoFornecedor) {
		this.razaoSocial = razaoSocial;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.inscEstadual = inscEstadual;
		this.inscMunicipal = inscMunicipal;
		this.rg = rg;
		this.dataCadastrado = dataCadastrado;
		this.enderecoFornecedor = enderecoFornecedor;
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
		return dataCadastrado;
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
		this.dataCadastrado = datCadastrado;
	}

	public void setEnderecoFornecedor(
			List<EnderecoFornecedor> enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}

}
