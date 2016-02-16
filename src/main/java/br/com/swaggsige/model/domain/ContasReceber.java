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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "contasReceber", indexes = {
		@Index(name = "IDX_CONTASRECEBER_NUMDOCUMENTO", columnList = "numDocumento"),
		@Index(name = "IDX_CONTASRECEBER_DATACADASTRO", columnList = "dataCadastro"),
		@Index(name = "IDX_CONTASRECEBER_DATAPRORROGACAO", columnList = "dataProrrogacao"),
		@Index(name = "IDX_CONTASRECEBER_DATAVENCIMENTO", columnList = "dataVencimento"),
		@Index(name = "IDX_CONTASRECEBER_DATAEMISSAO", columnList = "dataEmissao") }, uniqueConstraints = { @UniqueConstraint(name = "CONTASRECEBER_UQ", columnNames = { "numDocumento" }) })
@NamedQueries({
		@NamedQuery(name = "contasReceber.searchAll", query = "SELECT c FROM ContasReceber c JOIN FETCH c.cliente  JOIN FETCH c.movBancaria  JOIN FETCH c.planoContas  JOIN FETCH c.centroCusto  JOIN FETCH c.processo"),
		@NamedQuery(name = "contasReceber.searchByNumDoc", query = "SELECT c FROM ContasReceber c JOIN FETCH c.cliente  JOIN FETCH c.movBancaria  JOIN FETCH c.planoContas  JOIN FETCH c.centroCusto  JOIN FETCH c.processo WHERE c.numDocumento = :numDocumento"),
		@NamedQuery(name = "contasReceber.searchAllByRazaoSocialClienteStartsWith", query = "SELECT c FROM ContasReceber c JOIN FETCH c.cliente  JOIN FETCH c.movBancaria  JOIN FETCH c.planoContas  JOIN FETCH c.centroCusto  JOIN FETCH c.processo WHERE c.cliente.razaoSocial LIKE  :razaoSocial"),
		@NamedQuery(name = "contasReceber.searchByCNPJCliente", query = "SELECT c FROM ContasReceber c JOIN FETCH c.cliente JOIN FETCH c.movBancaria  JOIN FETCH c.planoContas  JOIN FETCH c.centroCusto  JOIN FETCH c.processo WHERE c.cliente.cnpj = :cnpjFornecedor"),
		@NamedQuery(name = "contasReceber.searchAllByPlanoContas", query = "SELECT c FROM ContasReceber c JOIN FETCH c.cliente  JOIN FETCH c.movBancaria  JOIN FETCH c.planoContas  JOIN FETCH c.centroCusto  JOIN FETCH c.processo WHERE c.planoContas.id = :IDPlanoContas"),
		@NamedQuery(name = "contasReceber.searchAllByRegistrationDate", query = "SELECT c FROM ContasReceber c JOIN FETCH c.cliente  JOIN FETCH c.movBancaria  JOIN FETCH c.planoContas  JOIN FETCH c.centroCusto  JOIN FETCH c.processo WHERE c.dataCadastro BETWEEN :data1 AND :data2"),
		@NamedQuery(name = "contasReceber.searchByDateExtension", query = "SELECT c FROM ContasReceber c JOIN FETCH c.cliente  JOIN FETCH c.movBancaria  JOIN FETCH c.planoContas  JOIN FETCH c.centroCusto  JOIN FETCH c.processo WHERE c.dataProrrogacao BETWEEN :data1 AND :data2"),
		@NamedQuery(name = "contasReceber.searchByDateIssue", query = "SELECT c FROM ContasReceber c JOIN FETCH c.cliente  JOIN FETCH c.movBancaria  JOIN FETCH c.planoContas  JOIN FETCH c.centroCusto  JOIN FETCH c.processo WHERE c.dataEmissao BETWEEN :data1 AND :data2"),
		@NamedQuery(name = "contasReceber.searchByDueDate", query = "SELECT c FROM ContasReceber c JOIN FETCH c.cliente  JOIN FETCH c.movBancaria  JOIN FETCH c.planoContas  JOIN FETCH c.centroCusto  JOIN FETCH c.processo WHERE c.dataVencimento BETWEEN :data1 AND :data2") })
@SequenceGenerator(name = "ContasReceber_SEQ", sequenceName = "ContasReceber_SEQ", allocationSize = 1, initialValue = 1)
public class ContasReceber implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ContasReceber_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "numDocumento", length = 20)
	private String numDocumento;

	@OneToOne
	@JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "FK_CLIENTE_ID"))
	private Cliente cliente;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacaoStatus")
	private Status situacaoStatus;

	@ManyToOne
	@JoinColumn(name = "movBancaria_id", foreignKey = @ForeignKey(name = "FK_MOVBANCARIA_ID"))
	private MovimentacaoBancaria movBancaria;

	@OneToOne
	@JoinColumn(name = "planoContas_id", foreignKey = @ForeignKey(name = "FK_PLANOCONTAS_ID"))
	private PlanoContas planoContas;

	@OneToOne
	@JoinColumn(name = "centroCusto_id", foreignKey = @ForeignKey(name = "FK_CENTROCUSTO_ID"))
	private CentroCusto centroCusto;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoPagamento")
	private TipoPagamento tipoPagamento;

	@OneToMany(mappedBy = "contasReceber", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Processo> processo;

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
	}

	public ContasReceber(Long id, String numDocumento, Cliente cliente,
			Status situacaoStatus, MovimentacaoBancaria movBancaria,
			PlanoContas planoContas, CentroCusto centroCusto,
			TipoPagamento tipoPagamento, List<Processo> processo,
			Date dataCadastro, Date dataEmissao, Date dataVencimento,
			Date dataProrrogacao, Date dataRecebimento, Date competencia,
			BigDecimal valorDocumento, BigDecimal percJuros,
			BigDecimal percDesconto, BigDecimal valorJuros,
			BigDecimal valorDesconto, BigDecimal valorRecebido,
			String observacao) {
		this.id = id;
		this.numDocumento = numDocumento;
		this.cliente = cliente;
		this.situacaoStatus = situacaoStatus;
		this.movBancaria = movBancaria;
		this.planoContas = planoContas;
		this.centroCusto = centroCusto;
		this.tipoPagamento = tipoPagamento;
		this.processo = processo;
		this.dataCadastro = dataCadastro;
		this.dataEmissao = dataEmissao;
		this.dataVencimento = dataVencimento;
		this.dataProrrogacao = dataProrrogacao;
		this.dataRecebimento = dataRecebimento;
		this.competencia = competencia;
		this.valorDocumento = valorDocumento;
		this.percJuros = percJuros;
		this.percDesconto = percDesconto;
		this.valorJuros = valorJuros;
		this.valorDesconto = valorDesconto;
		this.valorRecebido = valorRecebido;
		this.observacao = observacao;
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
		return processo;
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
		this.processo = idProcesso;
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

	public final Long getId() {
		return id;
	}

	public final List<Processo> getProcesso() {
		return processo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProcesso(List<Processo> processo) {
		this.processo = processo;
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
		ContasReceber other = (ContasReceber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
