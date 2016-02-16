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
 * @15:59:49
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "fabricante", indexes = {
		@Index(name = "IDX_FABRICANTE_NOME", columnList = "nome"),
		@Index(name = "IDX_FABRICANTE_RAZAO_SOCIAL", columnList = "razaoSocial"),
		@Index(name = "IDX_FABRICANTE_RG", columnList = "rg"),
		@Index(name = "IDX_FABRICANTE_CPF", columnList = "cpf"),
		@Index(name = "IDX_FABRICANTE_CNPJ", columnList = "cnpj"),
		@Index(name = "IDX_FABRICANTE_INSCESTADUAL", columnList = "inscEstadual"),
		@Index(name = "IDX_FABRICANTE_DATACADASTRO", columnList = "dataCadastro") }, uniqueConstraints = { @UniqueConstraint(name = "FABRICANTE_UQ", columnNames = {
		"nome", "rg", "cpf", "cnpj", "inscEstadual" }) })
@NamedQueries({
		@NamedQuery(name = "fabricante.searchAll", query = "SELECT f FROM Fabricante f INNER JOIN f.enderecoFabricante ef WHERE f.id = ef.fabricante.id"),
		@NamedQuery(name = "fabricante.searchAllByNameStartsWith", query = "SELECT f FROM Fabricante f INNER JOIN f.enderecoFabricante ef WHERE f.id = ef.fabricante.id AND f.nome LIKE :nome"),
		@NamedQuery(name = "fabricante.searchAllByRazaoSocialStartsWith", query = "SELECT f FROM Fabricante f INNER JOIN f.enderecoFabricante ef WHERE f.id = ef.fabricante.id AND f.razaoSocial LIKE :razaoSocial"),
		@NamedQuery(name = "fabricante.searchByRG", query = "SELECT f FROM Fabricante f INNER JOIN f.enderecoFabricante ef WHERE f.id = ef.fabricante.id AND f.rg = :rg"),
		@NamedQuery(name = "fabricante.searchByCPF", query = "SELECT f FROM Fabricante f INNER JOIN f.enderecoFabricante ef WHERE f.id = ef.fabricante.id AND f.cpf = :cpf"),
		@NamedQuery(name = "fabricante.searchByInscEstadual", query = "SELECT f FROM Fabricante f INNER JOIN f.enderecoFabricante ef WHERE f.id = ef.fabricante.id AND f.inscEstadual = :inscEstadual"),
		@NamedQuery(name = "fabricante.searchByCNPJ", query = "SELECT f FROM Fabricante f INNER JOIN f.enderecoFabricante ef WHERE f.id = ef.fabricante.id AND f.cnpj =:cnpj "),
		@NamedQuery(name = "fabricante.searchByRegistrationDate", query = "SELECT f FROM Fabricante f INNER JOIN f.enderecoFabricante ef WHERE f.id = ef.fabricante.id AND f.dataCadastrado BETWEEN :data1 AND :data2 ") })
public class Fabricante extends Pessoa implements Serializable {

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

	@OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnderecoFabricante> enderecoFabricante;

	public Fabricante() {
	}

	public Fabricante(String razaoSocial, String cpf, String cnpj,
			String inscEstadual, String inscMunicipal, String rg,
			Date dataCadastrado, List<EnderecoFabricante> enderecoFabricante) {
		this.razaoSocial = razaoSocial;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.inscEstadual = inscEstadual;
		this.inscMunicipal = inscMunicipal;
		this.rg = rg;
		this.dataCadastrado = dataCadastrado;
		this.enderecoFabricante = enderecoFabricante;
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

	public final List<EnderecoFabricante> getEnderecoFabricante() {
		return enderecoFabricante;
	}

	public void setRazaoSocial(String razaoSocial) {
		razaoSocial = razaoSocial;
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

	public void setEnderecoFabricante(
			List<EnderecoFabricante> enderecoFabricante) {
		this.enderecoFabricante = enderecoFabricante;
	}

}
