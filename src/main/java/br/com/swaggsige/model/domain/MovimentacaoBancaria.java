package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "movimentacaoBancaria", indexes = {
		@Index(name = "IDX_MOVIMENTACAOBANCARIA_NUMMOVIMENTACAO", columnList = "numMovimentacao"),
		@Index(name = "IDX_MOVIMENTACAOBANCARIA_NUMCHEQUE", columnList = "numCheque"),
		@Index(name = "IDX_MOVIMENTACAOBANCARIA_DATALANCAMENTO", columnList = "dataLancamento"),
		@Index(name = "IDX_MOVIMENTACAOBANCARIA_CHNOMINAL", columnList = "chNominal") },
		uniqueConstraints = { 
		@UniqueConstraint(name = "MOVIMENTACAOBANCARIA_UQ", columnNames = { "numMovimentacao", "numCheque" }) })
public class MovimentacaoBancaria extends AbstractEntity implements
		Serializable {

	@Column(name = "numMovimentacao")
	private Long numMovimentacao;

	@OneToOne
	@JoinColumn(name = "contaBancaria_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CONTABANCARIA_ID"))
	private ContaBancaria contaBancaria;

	@OneToOne
	@JoinColumn(name = "funcionario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FUNCIONARIO_ID"))
	private Funcionario funcionario;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoOperacao", length = 20)
	private TipoOperacao tipoOperacao;

	@OneToOne
	@JoinColumn(name = "centroCusto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CENTROCUSTO_ID"))
	private CentroCusto centroCusto;

	@OneToOne
	@JoinColumn(name = "planoContas_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PLANOCONTAS_ID"))
	private PlanoContas planoContas;

	@OneToMany(mappedBy = "movBancaria", cascade = CascadeType.ALL)
	private List<ContasReceber> idcontasReceber;

	@OneToMany(mappedBy = "movBancaria", cascade = CascadeType.ALL)
	private List<ContasPagar> idcontasPagar;

	@Column(name = "numCheque")
	private Long numCheque;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataLancamento")
	private Date dataLancamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataMovimentacao")
	private Date dataMovimentacao;

	@Column(name = "valor", scale = 2, precision = 9)
	private BigDecimal valor;

	@Column(name = "chNominal", length = 60)
	private String chNominal;

	@Column(name = "observacoes", length = 500)
	private String observacoes;

	public MovimentacaoBancaria() {
		// TODO Auto-generated constructor stub
	}

	public final Long getNumMovimentacao() {
		return numMovimentacao;
	}

	public final ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public final Funcionario getFuncionario() {
		return funcionario;
	}

	public final TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public final CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public final PlanoContas getPlanoContas() {
		return planoContas;
	}

	public final List<ContasReceber> getIdcontasReceber() {
		return idcontasReceber;
	}

	public final List<ContasPagar> getIdcontasPagar() {
		return idcontasPagar;
	}

	public final Long getNumCheque() {
		return numCheque;
	}

	public final Date getDataLancamento() {
		return dataLancamento;
	}

	public final Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public final BigDecimal getValor() {
		return valor;
	}

	public final String getChNominal() {
		return chNominal;
	}

	public final String getObservacoes() {
		return observacoes;
	}

	public void setNumMovimentacao(Long numMovimentacao) {
		this.numMovimentacao = numMovimentacao;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public void setPlanoContas(PlanoContas planoContas) {
		this.planoContas = planoContas;
	}

	public void setIdcontasReceber(List<ContasReceber> idcontasReceber) {
		this.idcontasReceber = idcontasReceber;
	}

	public void setIdcontasPagar(List<ContasPagar> idcontasPagar) {
		this.idcontasPagar = idcontasPagar;
	}

	public void setNumCheque(Long numCheque) {
		this.numCheque = numCheque;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setChNominal(String chNominal) {
		this.chNominal = chNominal;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
