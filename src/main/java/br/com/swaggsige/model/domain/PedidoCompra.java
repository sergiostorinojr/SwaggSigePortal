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
 * SigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 * @2016
 * @01:07:11
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "pedidoCompra", indexes = {
		@Index(name = "IDX_PEDIDOCOMPRA_NUMPEDIDO", columnList = "numPedido"),
		@Index(name = "IDX_PEDIDOCOMPRA_DATALANCAMENTO", columnList = "dataLancamento"),
		@Index(name = "IDX_PEDIDOCOMPRA_DATAENTREGA", columnList = "dataEntrega") }, uniqueConstraints = { @UniqueConstraint(name = "PEDIDOCOMPRA_UQ", columnNames = { "numPedido" }) })
@NamedQueries({
		@NamedQuery(name = "pedidoCompra.searchAll", query = "SELECT p FROM PedidoCompra p INNER JOIN p.itemCompra ic INNER JOIN p.formaPagamento f INNER JOIN p.fornecedor for WHERE p.id = ic.pedidoCompra.id AND p.fornecedor.id = for.id AND p.formaPagamento.id = f.id"),
		@NamedQuery(name = "pedidoCompra.searchNumPedido", query = "SELECT p FROM PedidoCompra p INNER JOIN p.itemCompra ic INNER JOIN p.formaPagamento f INNER JOIN p.fornecedor for WHERE p.id = ic.pedidoCompra.id AND p.fornecedor.id = for.id AND p.formaPagamento.id = f.id AND p.numPedido = :numPedido"),
		@NamedQuery(name = "pedidoCompra.searchByFornecedor", query = "SELECT p FROM PedidoCompra p INNER JOIN p.itemCompra ic INNER JOIN p.formaPagamento f INNER JOIN p.fornecedor for WHERE p.id = ic.pedidoCompra.id AND p.fornecedor.id = for.id AND p.formaPagamento.id = f.id AND p.fornecedor.id = :fornecedor"),
		@NamedQuery(name = "pedidoCompra.searchAllByDateDelivery", query = "SELECT p FROM PedidoCompra p INNER JOIN p.itemCompra ic INNER JOIN p.formaPagamento f INNER JOIN p.fornecedor for WHERE p.id = ic.pedidoCompra.id AND p.fornecedor.id = for.id AND p.formaPagamento.id = f.id AND p.dataEntrega BETWEEN :data1 AND :data2"),
		@NamedQuery(name = "pedidoCompra.searchByDateRelease", query = "SELECT p FROM PedidoCompra p INNER JOIN p.itemCompra ic INNER JOIN p.formaPagamento f INNER JOIN p.fornecedor for WHERE p.id = ic.pedidoCompra.id AND p.fornecedor.id = for.id AND p.formaPagamento.id = f.id AND p.dataLancamento BETWEEN :data1 AND :data2") })
@SequenceGenerator(name = "PedidoCompra_SEQ", sequenceName = "PedidoCompra_SEQ", allocationSize = 1, initialValue = 1)
public class PedidoCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PedidoCompra_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@OneToMany(mappedBy = "pedidoCompra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ItemCompra> itemCompra;

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
	}

	public PedidoCompra(Long id, List<ItemCompra> itemCompra, String numPedido,
			Date dataLancamento, Date dataRealizacao, Fornecedor fornecedor,
			Finalidade finalidade, TipoCompra tipoCompra,
			FormaPagamento formaPagamento, BigDecimal valorFrete,
			BigDecimal valorDesconto, BigDecimal valorTotal) {
		this.id = id;
		this.itemCompra = itemCompra;
		this.numPedido = numPedido;
		this.dataLancamento = dataLancamento;
		this.dataEntrega = dataRealizacao;
		this.fornecedor = fornecedor;
		this.finalidade = finalidade;
		this.tipoCompra = tipoCompra;
		this.formaPagamento = formaPagamento;
		this.valorFrete = valorFrete;
		this.valorDesconto = valorDesconto;
		this.valorTotal = valorTotal;
	}

	public void setIdItemCompra(List<ItemCompra> idItemCompra) {
		this.itemCompra = idItemCompra;
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
		return itemCompra;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemCompra(List<ItemCompra> itemCompra) {
		this.itemCompra = itemCompra;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataEntrega = dataRealizacao;
	}

	public final Long getId() {
		return id;
	}

	public final List<ItemCompra> getItemCompra() {
		return itemCompra;
	}

	public final Date getDataRealizacao() {
		return dataEntrega;
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
		PedidoCompra other = (PedidoCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
