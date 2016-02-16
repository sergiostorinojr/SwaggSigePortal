package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
 *  SigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *  @2016
 *  @22:04:42
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "funcionario", indexes = {
		@Index(name = "IDX_FUNCIONARIO_NOME", columnList = "nome"),
		@Index(name = "IDX_FUNCIONARIO_RG", columnList = "rg"),
		@Index(name = "IDX_FUNCIONARIO_CPF", columnList = "cpf"),
		@Index(name = "IDX_FUNCIONARIO_CTPS", columnList = "ctps"),
		@Index(name = "IDX_FUNCIONARIO_DATANASCIMENTO", columnList = "dataNascimento"),
		@Index(name = "IDX_FUNCIONARIO_DATACADASTRO", columnList = "dataCadastro") }, uniqueConstraints = { @UniqueConstraint(name = "FUNCIONARIO_UQ", columnNames = {
		"nome", "rg", "cpf", "ctps" }) })
@NamedQueries({
		@NamedQuery(name = "funcionario.searchAll", query = "SELECT f FROM Funcionario f INNER JOIN f.enderecoFuncionario ef INNER JOIN f.cargo c INNER JOIN f.usuario u WHERE f.id = ef.funcionario.id AND f.usuario.id = u.id AND f.cargo.id = c.id"),
		@NamedQuery(name = "funcionario.searchAllByNameStartsWith", query = "SELECT f FROM Funcionario f INNER JOIN f.enderecoFuncionario ef INNER JOIN f.cargo c INNER JOIN f.usuario u WHERE f.id = ef.funcionario.id AND f.usuario.id = u.id AND f.cargo.id = c.id AND f.nome LIKE :nome"),
		@NamedQuery(name = "funcionario.searchByRG", query = "SELECT f FROM Funcionario f INNER JOIN f.enderecoFuncionario ef INNER JOIN f.cargo c INNER JOIN f.usuario u WHERE f.id = ef.funcionario.id AND f.usuario.id = u.id AND f.cargo.id = c.id AND f.rg = :rg"),
		@NamedQuery(name = "funcionario.searchByCPF", query = "SELECT f FROM Funcionario f INNER JOIN f.enderecoFuncionario ef INNER JOIN f.cargo c INNER JOIN f.usuario u WHERE f.id = ef.funcionario.id AND f.usuario.id = u.id AND f.cargo.id = c.id AND f.cpf = :cpf"),
		@NamedQuery(name = "funcionario.searchByNivelEnsino", query = "SELECT f FROM Funcionario f INNER JOIN f.enderecoFuncionario ef INNER JOIN f.cargo c INNER JOIN f.usuario u WHERE f.id = ef.funcionario.id AND f.usuario.id = u.id AND f.cargo.id = c.id AND f.nivelEnsino = :nivelEnsino "),
		@NamedQuery(name = "funcionario.searchByRegistrationDate", query = "SELECT f FROM Funcionario f INNER JOIN f.enderecoFuncionario ef INNER JOIN f.cargo c INNER JOIN f.usuario u WHERE f.id = ef.funcionario.id AND f.usuario.id = u.id AND f.cargo.id = c.id AND f.dataCadastro BETWEEN :data1 AND :data2 ") })
public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USUARIO_ID"))
	private Usuario usuario;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataAdmissao")
	private Date dataAdmisao;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataDemissao")
	private Date dataDemissao;

	@Column(name = "rg", length = 20)
	private String rg;

	@Column(name = "cpf", length = 20)
	private String cpf;

	@Column(name = "ctps", length = 20)
	private String ctps;

	@Enumerated(EnumType.STRING)
	@Column(name = "nivelEnsino", length = 15)
	private NivelEnsino nivelEnsino;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataCadastro")
	private Date dataCadastro;

	@OneToOne
	@JoinColumn(name = "cargo", nullable = false, foreignKey = @ForeignKey(name = "FK_FABRICANTE_ID"))
	private Cargo cargo;

	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnderecoFuncionario> enderecoFuncionario;

	public Funcionario() {
	}

	public Funcionario(Usuario usuario, Date dataAdmisao, Date dataDemissao,
			String rg, String cpf, String ctps, NivelEnsino nivelEnsino,
			Date dataCadastro, Cargo cargo,
			List<EnderecoFuncionario> enderecoFuncionario) {
		this.usuario = usuario;
		this.dataAdmisao = dataAdmisao;
		this.dataDemissao = dataDemissao;
		this.rg = rg;
		this.cpf = cpf;
		this.ctps = ctps;
		this.nivelEnsino = nivelEnsino;
		this.dataCadastro = dataCadastro;
		this.cargo = cargo;
		this.enderecoFuncionario = enderecoFuncionario;
	}

	public final Date getDataAdmisao() {
		return dataAdmisao;
	}

	public final Date getDataDemissao() {
		return dataDemissao;
	}

	public final String getRg() {
		return rg;
	}

	public final String getCpf() {
		return cpf;
	}

	public final String getCtps() {
		return ctps;
	}

	public final NivelEnsino getNivelEnsino() {
		return nivelEnsino;
	}

	public final Date getDataCadastro() {
		return dataCadastro;
	}

	public final Cargo getCargo() {
		return cargo;
	}

	public final List<EnderecoFuncionario> getIdEndFuncionario() {
		return enderecoFuncionario;
	}

	public void setDataAdmisao(Date dataAdmisao) {
		this.dataAdmisao = dataAdmisao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public void setNivelEnsino(NivelEnsino nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void setIdEndFuncionario(List<EnderecoFuncionario> idEndFuncionario) {
		this.enderecoFuncionario = idEndFuncionario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public final Usuario getUsuario() {
		return usuario;
	}

	public final List<EnderecoFuncionario> getEnderecoFuncionario() {
		return enderecoFuncionario;
	}

	public void setEnderecoFuncionario(
			List<EnderecoFuncionario> enderecoFuncionario) {
		this.enderecoFuncionario = enderecoFuncionario;
	}

}
