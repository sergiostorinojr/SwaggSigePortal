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
@Table(name = "pedidoCompra", indexes = {
		@Index(name = "IDX_PEDIDOCOMPRA_NUMPEDIDO", columnList = "numPedido"),
		@Index(name = "IDX_PEDIDOCOMPRA_DATALANCAMENTO", columnList = "dataLancamento"),
		@Index(name = "IDX_PEDIDOCOMPRA_DATAENTREGA", columnList = "dataEntrega") },
		uniqueConstraints = { @UniqueConstraint(name = "PEDIDOCOMPRA_UQ", columnNames = { "numPedido" }) })
public class PedidoCompra extends AbstractEntity implements Serializable {

	@OneToMany(mappedBy = "pedidoCompra", cascade = CascadeType.ALL)
	private List<ItemCompra> idItemCompra;

	@Column(name = "numPedido", length = 20)
	private String numPedido;

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
	@Column(name = "finalidade", length = 15)
	private Finalidade finalidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoCompra", length = 15)
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
	
	public PedidoCompra() {
		// TODO Auto-generated constructor stub
	}

	public void setIdItemCompra(List<ItemCompra> idItemCompra) {
		this.idItemCompra = idItemCompra;
	}

	public void setNumPedido(String numPedido) {
		this.numPedido = numPedido;
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

	public final List<ItemCompra> getIdItemCompra() {
		return idItemCompra;
	}

	public final String getNumPedido() {
		return numPedido;
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

}
