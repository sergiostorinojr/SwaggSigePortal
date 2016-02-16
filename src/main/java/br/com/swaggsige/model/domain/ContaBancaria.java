package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name = "contaBancaria", indexes = {
		@Index(name = "IDX_CONTABANCARIA_DESCRICAO", columnList = "descricao"),
		@Index(name = "IDX_CONTABANCARIA_CIDADE", columnList = "cidade"),
		@Index(name = "IDX_CONTABANCARIA_CONTACORRENTE", columnList = "contaCorrente"),
		@Index(name = "IDX_CONTABANCARIA_AGENCIA", columnList = "agencia"),
		@Index(name = "IDX_CONTABANCARIA_DATACADASTRO", columnList = "dataCadastro") }, uniqueConstraints = { @UniqueConstraint(name = "CONTABANCARIA_UQ", columnNames = {
		"descricao", "cidade", "contaCorrente", "agencia", "dataCadastro" }) })
@NamedQueries({
		@NamedQuery(name = "contaBancaria.searchAll", query = "SELECT c FROM ContaBancaria c JOIN FETCH c.banco "),
		@NamedQuery(name = "contaBancaria.searchAllByDescriptionStartsWith", query = "SELECT c FROM ContaBancaria c JOIN FETCH c.banco  WHERE c.descricao LIKE :descricao"),
		@NamedQuery(name = "contaBancaria.searchAllByCity", query = "SELECT c FROM ContaBancaria c JOIN FETCH c.banco  WHERE  c.cidade LIKE :cidade"),
		@NamedQuery(name = "contaBancaria.searchByCC", query = "SELECT c FROM ContaBancaria c JOIN FETCH c.banco  WHERE c.contaCorrente = :contaCorrente"),
		@NamedQuery(name = "contaBancaria.searchByAgency", query = "SELECT c FROM ContaBancaria c JOIN FETCH c.banco  WHERE c.agencia = :agencia"),
		@NamedQuery(name = "contaBancaria.searchByRegistrationDate", query = "SELECT c FROM ContaBancaria c JOIN FETCH c.banco  WHERE c.dataCadastro BETWEEN :data1 AND :data2") })
@SequenceGenerator(name = "ContaBancaria_SEQ", sequenceName = "ContaBancaria_SEQ", allocationSize = 1, initialValue = 1)
public class ContaBancaria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ContaBancaria_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "descricao", length = 100)
	private String descricao;

	@Column(name = "cidade", length = 40)
	private String cidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "uf", length = 2)
	private UF UF;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", length = 20)
	private Situacao situacao;

	@OneToOne
	@JoinColumn(name = "banco_id", foreignKey = @ForeignKey(name = "FK_BANCO_ID"))
	private Banco banco;

	@Column(name = "agencia")
	private Long agencia;

	@Column(name = "digitoAgencia", length = 6)
	private String digitoAgencia;

	@Column(name = "contaCorrente")
	private Long contaCorrente;

	@Column(name = "digitoConta", length = 6)
	private String digitoConta;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataCadastro")
	private Date dataCadastro;

	public ContaBancaria() {
	}

	public ContaBancaria(Long id, String descricao, String cidade,
			br.com.swaggsige.model.domain.UF uF, Situacao situacao,
			Banco banco, Long agencia, String digitoAgencia,
			Long contaCorrente, String digitoConta, Date dataCadastro) {
		this.id = id;
		this.descricao = descricao;
		this.cidade = cidade;
		UF = uF;
		this.situacao = situacao;
		this.banco = banco;
		this.agencia = agencia;
		this.digitoAgencia = digitoAgencia;
		this.contaCorrente = contaCorrente;
		this.digitoConta = digitoConta;
		this.dataCadastro = dataCadastro;
	}

	public final String getDescricao() {
		return descricao;
	}

	public final String getCidade() {
		return cidade;
	}

	public final UF getUF() {
		return UF;
	}

	public final Situacao getSituacao() {
		return situacao;
	}

	public final Banco getBanco() {
		return banco;
	}

	public final Long getAgencia() {
		return agencia;
	}

	public final String getDigitoAgencia() {
		return digitoAgencia;
	}

	public final Long getContaCorrente() {
		return contaCorrente;
	}

	public final String getDigitoConta() {
		return digitoConta;
	}

	public final Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUF(UF uF) {
		UF = uF;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}

	public void setDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public void setDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public final Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		ContaBancaria other = (ContaBancaria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
