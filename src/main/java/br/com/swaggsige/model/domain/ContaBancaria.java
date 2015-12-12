package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "contaBancaria", indexes = {
		@Index(name = "IDX_CONTABANCARIA_DESCRICAO", columnList = "descricao"),
		@Index(name = "IDX_CONTABANCARIA_CIDADE", columnList = "cidade")}, 
		uniqueConstraints = { @UniqueConstraint(name = "CONTABANCARIA_UQ", columnNames = {
		"descricao", "cidade" }) })
public class ContaBancaria extends AbstractEntity implements Serializable {

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
	@JoinColumn(name = "banco_id", foreignKey = @ForeignKey(name="FK_BANCO_ID") )
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
		// TODO Auto-generated constructor stub
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

}
