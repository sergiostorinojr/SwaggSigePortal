package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
		@NamedQuery(name = "cliente.searchAll", query = "SELECT c FROM Cliente c  JOIN FETCH c.enderecoCliente  JOIN FETCH c.usuario "),
		@NamedQuery(name = "cliente.searchById", query = "SELECT c FROM Cliente c  JOIN FETCH c.enderecoCliente  JOIN FETCH c.usuario   WHERE  c.id = :id"),
		@NamedQuery(name = "cliente.searchAllByNameStartsWith", query = "SELECT c FROM Cliente c  JOIN FETCH c.enderecoCliente  JOIN FETCH c.usuario   WHERE  c.nome LIKE :nome"),
		@NamedQuery(name = "cliente.searchAllByRazaoSocialStartsWith", query = "SELECT c FROM Cliente c  JOIN FETCH c.enderecoCliente  JOIN FETCH c.usuario   WHERE  c.razaoSocial LIKE :razaoSocial"),
		@NamedQuery(name = "cliente.searchByRG", query = "SELECT c FROM Cliente c  JOIN FETCH c.enderecoCliente  JOIN FETCH c.usuario   WHERE  c.rg = :rg"),
		@NamedQuery(name = "cliente.searchByCPF", query = "SELECT c FROM Cliente c  JOIN FETCH c.enderecoCliente  JOIN FETCH c.usuario   WHERE  c.cpf = :cpf"),
		@NamedQuery(name = "cliente.searchByCNPJ", query = "SELECT c FROM Cliente c  JOIN FETCH c.enderecoCliente  JOIN FETCH c.usuario   WHERE  c.cnpj = :cnpj"),
		@NamedQuery(name = "cliente.searchByInscEstadual", query = "SELECT c FROM Cliente c  JOIN FETCH c.enderecoCliente  JOIN FETCH c.usuario   WHERE  c.inscEstadual = :inscEstadual"),
		@NamedQuery(name = "cliente.searchByBirthdayDate", query = "SELECT c FROM Cliente c  JOIN FETCH c.enderecoCliente  JOIN FETCH c.usuario   WHERE  c.dataNascimento BETWEEN :data1 AND :data2 "),
		@NamedQuery(name = "cliente.searchByRegistrationDate", query = "SELECT c FROM Cliente c  JOIN FETCH c.enderecoCliente  JOIN FETCH c.usuario   WHERE  c.dataCadastro BETWEEN :data1 AND :data2 ") })
public class Cliente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnderecoCliente> enderecoCliente = new ArrayList<EnderecoCliente>();

	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USUARIO_ID"))
	private Usuario usuario = new Usuario();

	public Cliente() {
	}

	public Cliente(String razaoSocial, String cpf, String cnpj,
			String inscEstadual, String rg, Date dataCadastro,
			List<EnderecoCliente> enderecoCliente, Usuario usuario) {
		this.razaoSocial = razaoSocial;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.inscEstadual = inscEstadual;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
		this.enderecoCliente = enderecoCliente;
		this.usuario = usuario;
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

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setEnderecoCliente(List<EnderecoCliente> enderecoCliente) {
		this.enderecoCliente.addAll(enderecoCliente);
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

	public final Date getDataCadastro() {
		return dataCadastro;
	}

	public final List<EnderecoCliente> getEnderecoCliente() {
		return enderecoCliente;
	}

	public final Usuario getUsuario() {
		return usuario;
	}

	@Override
	public String toString() {
		return "Cliente [razaoSocial=" + razaoSocial + ", cpf=" + cpf
				+ ", cnpj=" + cnpj + ", inscEstadual=" + inscEstadual + ", rg="
				+ rg + ", dataCadastro=" + dataCadastro + ", enderecoCliente="
				+ enderecoCliente + ", usuario=" + usuario + "]";
	}

}
