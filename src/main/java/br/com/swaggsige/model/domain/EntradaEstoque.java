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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "entradaEstoque", indexes = {
		@Index(name = "IDX_ENTRADAESTOQUE_DATALANCAMENTO", columnList = "dataLancamento"),
		@Index(name = "IDX_ENTRADAESTOQUE_DATAENTREGA", columnList = "dataEntrega") })
public class EntradaEstoque extends AbstractEntity implements Serializable {

	@OneToMany(mappedBy = "entradaEstoque", cascade = CascadeType.ALL)
	private List<ItemEstoque> itemEstoque;

	@OneToOne
	@JoinColumn(name = "pedidoCompra_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PEDIDOCOMPRA_ID"))
	private PedidoCompra pedidoCompra;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataLancamento")
	private Date dataLancamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataEntrega")
	private Date dataEntrega;

	@OneToOne
	@JoinColumn(name = "fornecedor_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FORNECEDOR_ID"))
	private Fornecedor fornecedor;

	@Enumerated(EnumType.STRING)
	@Column(name = "finalidade")
	private Finalidade finalidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoCompra")
	private TipoCompra tipoCompra;

	@OneToOne
	@JoinColumn(name = "formaPagamento_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FORMAPAGAMENTO_ID"))
	private FormaPagamento formaPagamento;

	@Column(name = "valorFrete", scale = 2, precision = 9)
	private BigDecimal valorFrete;

	@Column(name = "valorDesconto", scale = 2, precision = 9)
	private BigDecimal valorDesconto;

	@Column(name = "valorTotal", scale = 2, precision = 9)
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "contasPagar_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CONTASPAGAR_ID"))
	private ContasPagar contasPagar;

	@OneToOne
	@JoinColumn(name = "planoContas_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PLANOCONTAS_ID"))
	private PlanoContas planoContas;

	@OneToOne
	@JoinColumn(name = "centroCusto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CENTROCUSTO_ID"))
	private CentroCusto centroCusto;

	public EntradaEstoque() {
		// TODO Auto-generated constructor stub
	}

	public final List<ItemEstoque> getItemEstoque() {
		return itemEstoque;
	}

	public final PedidoCompra getPedidoCompra() {
		return pedidoCompra;
	}

	public final Date getDataLancamento() {
		return dataLancamento;
	}

	public final Date getDataEntrega() {
		return dataEntrega;
	}

	public final Fornecedor getFornecedor() {
		return fornecedor;
	}

	public final Finalidade getFinalidade() {
		return finalidade;
	}

	public final TipoCompra getTipoCompra() {
		return tipoCompra;
	}

	public final FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public final BigDecimal getValorFrete() {
		return valorFrete;
	}

	public final BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public final BigDecimal getValorTotal() {
		return valorTotal;
	}

	public final ContasPagar getContasPagar() {
		return contasPagar;
	}

	public final PlanoContas getPlanoContas() {
		return planoContas;
	}

	public final CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setItemEstoque(List<ItemEstoque> itemEstoque) {
		this.itemEstoque = itemEstoque;
	}

	public void setPedidoCompra(PedidoCompra pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setFinalidade(Finalidade finalidade) {
		this.finalidade = finalidade;
	}

	public void setTipoCompra(TipoCompra tipoCompra) {
		this.tipoCompra = tipoCompra;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setContasPagar(ContasPagar contasPagar) {
		this.contasPagar = contasPagar;
	}

	public void setPlanoContas(PlanoContas planoContas) {
		this.planoContas = planoContas;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

}
