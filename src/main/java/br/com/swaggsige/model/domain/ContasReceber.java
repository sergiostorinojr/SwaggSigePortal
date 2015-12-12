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
@Table(name = "contasReceber", indexes = {
		@Index(name = "IDX_CONTASRECEBER_NUMDOCUMENTO", columnList = "numDocumento"),
		@Index(name = "IDX_CONTASRECEBER_DATACADASTRO", columnList = "dataCadastro"), 
		@Index(name = "IDX_CONTASPAGAR_DATAPRORROGACAO", columnList = "dataProrrogacao"), 
		@Index(name = "IDX_CONTASPAGAR_DATAVENCIMENTO", columnList = "dataVencimento"), 
		@Index(name = "IDX_CONTASPAGAR_DATAEMISSAO", columnList = "dataEmissao")}, 
		uniqueConstraints = { @UniqueConstraint(name = "CONTASRECEBER_UQ", columnNames = {
		"numDocumento"}) })
public class ContasReceber extends AbstractEntity implements Serializable {

	@Column(name = "numDocumento", length = 20)
	private String numDocumento;

	@OneToOne
	@JoinColumn(name = "cliente_id",foreignKey = @ForeignKey(name="FK_CLIENTE_ID"))
	private Cliente cliente;

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
	@Column(name = "tipoPagamento")
	private TipoPagamento tipoPagamento;

	@OneToMany(mappedBy = "contasReceber", cascade = CascadeType.ALL)
	private List<Processo> idProcesso;

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
	@Column(name = "dataRecebimento")
	private Date dataRecebimento;

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

	@Column(name = "valorRecebido", scale = 2, precision = 9)
	private BigDecimal valorRecebido;

	@Column(name = "observacao", length = 500)
	private String observacao;

	public ContasReceber() {
		// TODO Auto-generated constructor stub
	}

	public final String getNumDocumento() {
		return numDocumento;
	}

	public final Cliente getCliente() {
		return cliente;
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

	public final List<Processo> getIdProcesso() {
		return idProcesso;
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

	public final Date getDataRecebimento() {
		return dataRecebimento;
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

	public final BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public final String getObservacao() {
		return observacao;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public void setIdProcesso(List<Processo> idProcesso) {
		this.idProcesso = idProcesso;
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

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
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

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
