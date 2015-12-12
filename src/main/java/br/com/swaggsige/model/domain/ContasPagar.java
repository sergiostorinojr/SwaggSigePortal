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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "contasPagar", indexes = {
		@Index(name = "IDX_CONTASPAGAR_NUMDOCUMENTO", columnList = "numDocumento"),
		@Index(name = "IDX_CONTASPAGAR_DATACADASTRO", columnList = "dataCadastro"), 
		@Index(name = "IDX_CONTASPAGAR_DATAPRORROGACAO", columnList = "dataProrrogacao"), 
		@Index(name = "IDX_CONTASPAGAR_DATAVENCIMENTO", columnList = "dataVencimento"), 
		@Index(name = "IDX_CONTASPAGAR_DATAEMISSAO", columnList = "dataEmissao")}, 
		uniqueConstraints = { @UniqueConstraint(name = "CONTASPAGAR_UQ", columnNames = {
		"numDocumento"}) })
public class ContasPagar extends AbstractEntity implements Serializable {

	@Column(name = "numDocumento", length = 20)
	private String numDocumento;

	@OneToOne
	@JoinColumn(name = "fornecedor_id",foreignKey = @ForeignKey(name="FK_FORNECEDOR_ID"))
	private Fornecedor fornecedor;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacaoStatus")
	private Status situacaoStatus;

	@ManyToOne
	@JoinColumn(name = "movBancaria_id",foreignKey = @ForeignKey(name="FK_MOVBANCARIA_ID"))
	private MovimentacaoBancaria movBancaria;

	@OneToOne
	@JoinColumn(name = "planoContas_id",foreignKey = @ForeignKey(name="FK_PLANOCONTAS_ID"))
	private PlanoContas planoContas;

	@OneToOne
	@JoinColumn(name = "centroCusto_id",foreignKey = @ForeignKey(name="FK_CENTROCUSTO_ID"))
	private CentroCusto centroCusto;

	@Enumerated(EnumType.STRING)
	@Column(name="tipoPagamento", length=20)
	private TipoPagamento tipoPagamento;

	@OneToMany(mappedBy = "contasPagar", cascade = CascadeType.ALL)
	private List<EntradaEstoque> idEntradaEstoque;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataCadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataEmissao")
	private Date dataEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataVencimento")
	private Date dataVencimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataProrrogacao")
	private Date dataProrrogacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataPagamento")
	private Date dataPagamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "competencia")
	private Date competencia;

	@Column(name = "valorDocumento", scale = 2, precision = 9)
	private BigDecimal valorDocumento;

	@Column(name = "percJuros", scale = 2, precision = 9)
	private BigDecimal percJuros;

	@Column(name = "percDesconto", scale = 2, precision = 9)
	private BigDecimal percDesconto;

	@Column(name = "valorJuros", scale = 2, precision = 9)
	private BigDecimal valorJuros;

	@Column(name = "valorDesconto", scale = 2, precision = 9)
	private BigDecimal valorDesconto;

	@Column(name = "valorPago", scale = 2, precision = 9)
	private BigDecimal valorPago;

	@Column(name = "observacao", length = 500)
	private String observacao;

	public ContasPagar() {
		// TODO Auto-generated constructor stub
	}

	public final String getNumDocumento() {
		return numDocumento;
	}

	public final Fornecedor getFornecedor() {
		return fornecedor;
	}

	public final Status getSituacaoStatus() {
		return situacaoStatus;
	}

	public final MovimentacaoBancaria getMovBancaria() {
		return movBancaria;
	}

	public final PlanoContas getPlanoContas() {
		return planoContas;
	}

	public final CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public final TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public final List<EntradaEstoque> getIdEntradaEstoque() {
		return idEntradaEstoque;
	}

	public final Date getDataCadastro() {
		return dataCadastro;
	}

	public final Date getDataEmissao() {
		return dataEmissao;
	}

	public final Date getDataVencimento() {
		return dataVencimento;
	}

	public final Date getDataProrrogacao() {
		return dataProrrogacao;
	}

	public final Date getDataPagamento() {
		return dataPagamento;
	}

	public final Date getCompetencia() {
		return competencia;
	}

	public final BigDecimal getValorDocumento() {
		return valorDocumento;
	}

	public final BigDecimal getPercJuros() {
		return percJuros;
	}

	public final BigDecimal getPercDesconto() {
		return percDesconto;
	}

	public final BigDecimal getValorJuros() {
		return valorJuros;
	}

	public final BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public final BigDecimal getValorPago() {
		return valorPago;
	}

	public final String getObservacao() {
		return observacao;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setSituacaoStatus(Status situacaoStatus) {
		this.situacaoStatus = situacaoStatus;
	}

	public void setMovBancaria(MovimentacaoBancaria movBancaria) {
		movBancaria = movBancaria;
	}

	public void setPlanoContas(PlanoContas planoContas) {
		this.planoContas = planoContas;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public void setIdEntradaEstoque(List<EntradaEstoque> idEntradaEstoque) {
		this.idEntradaEstoque = idEntradaEstoque;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setDataProrrogacao(Date dataProrrogacao) {
		this.dataProrrogacao = dataProrrogacao;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public void setCompetencia(Date competencia) {
		this.competencia = competencia;
	}

	public void setValorDocumento(BigDecimal valorDocumento) {
		this.valorDocumento = valorDocumento;
	}

	public void setPercJuros(BigDecimal percJuros) {
		this.percJuros = percJuros;
	}

	public void setPercDesconto(BigDecimal percDesconto) {
		this.percDesconto = percDesconto;
	}

	public void setValorJuros(BigDecimal valorJuros) {
		this.valorJuros = valorJuros;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
