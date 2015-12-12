package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Cliente", indexes = {
		@Index(name = "IDX_CLIENTE_NOME", columnList = "nome"),
		@Index(name = "IDX_CLIENTE_RAZAO_SOCIAL", columnList = "razaoSocial"),
		@Index(name = "IDX_CLIENTE_RG", columnList = "rg"),
		@Index(name = "IDX_CLIENTE_CPF", columnList = "cpf"),
		@Index(name = "IDX_CLIENTE_CNPJ", columnList = "cnpj"),
		@Index(name = "IDX_CLIENTE_INSCESTADUAL", columnList = "inscEstadual"),
		@Index(name = "IDX_CLIENTE_DATANASCIMENTO", columnList = "dataNascimento"),
		@Index(name = "IDX_CLIENTE_DATACADASTRO", columnList = "dataCadastro") }, uniqueConstraints = { @UniqueConstraint(name = "CLIENTE_UQ", columnNames = {
		"nome", "rg", "cpf", "cnpj", "inscEstadual" }) })
@NamedQueries({
	@NamedQuery(name = "cliente.getAll", query = "SELECT c FROM Cliente c ") })
public class Cliente extends Pessoa implements Serializable {

	@Column(name = "razaoSocial", length = 100)
	private String razaoSocial;

	@Column(name = "cpf", length = 20)
	private String cpf;

	@Column(name = "cnpj", length = 20)
	private String cnpj;

	@Column(name = "inscEstadual")
	private String inscEstadual;

	@Column(name = "rg", length = 20)
	private String rg;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataCadastro")
	private Date dataCadastro;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<EnderecoCliente> enderecoCliente;

	@OneToOne
	@JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USUARIO_ID"))
	private Usuario usuario;

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

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setDatCadastrado(Date datCadastrado) {
		this.dataCadastro = datCadastrado;
	}

	public void setEnderecoCliente(List<EnderecoCliente> enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public final String getRg() {
		return rg;
	}

	public final Date getDatCadastrado() {
		return dataCadastro;
	}

	public final List<EnderecoCliente> getEnderecoCliente() {
		return enderecoCliente;
	}

	public final Usuario getUsuario() {
		return usuario;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
}
