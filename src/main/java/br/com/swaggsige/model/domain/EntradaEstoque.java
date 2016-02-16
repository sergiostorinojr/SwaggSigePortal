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
 * @15:57:56
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "entradaEstoque", indexes = {
		@Index(name = "IDX_ENTRADAESTOQUE_DATALANCAMENTO", columnList = "dataLancamento"),
		@Index(name = "IDX_ENTRADAESTOQUE_DATAENTREGA", columnList = "dataEntrega") })
@NamedQueries({
		@NamedQuery(name = "entradaEstoque.searchAll", query = "SELECT e FROM EntradaEstoque e INNER JOIN e.centroCusto c INNER JOIN e.pedidoCompra pc INNER JOIN e.planoContas p INNER JOIN e.formaPagamento fp INNER JOIN e.fornecedor f INNER JOIN e.itemEstoque ie INNER JOIN e.contasPagar cp WHERE e.centroCusto.id = c.id AND e.pedidoCompra.id = pc.id AND p.id = e.planoContas.id AND e.fornecedor.id = fp.id AND e.fornecedor.id = f.id AND e.id = ie.entradaEstoque.id AND e.contasPagar.id = cp.id"),
		@NamedQuery(name = "entradaEstoque.searchAllByRazaoSocialFornecedorStartsWith", query = "SELECT e FROM EntradaEstoque e INNER JOIN e.centroCusto c INNER JOIN e.pedidoCompra pc INNER JOIN e.planoContas p INNER JOIN e.formaPagamento fp INNER JOIN e.fornecedor f INNER JOIN e.itemEstoque ie INNER JOIN e.contasPagar cp WHERE e.centroCusto.id = c.id AND e.pedidoCompra.id = pc.id AND p.id = e.planoContas.id AND e.fornecedor.id = fp.id AND e.fornecedor.id = f.id AND e.id = ie.entradaEstoque.id AND e.contasPagar.id = cp.id AND f.razaoSocial LIKE  :razaoSocial"),
		@NamedQuery(name = "entradaEstoque.searchByCNPJFornecedor", query = "SELECT e FROM EntradaEstoque e INNER JOIN e.centroCusto c INNER JOIN e.pedidoCompra pc INNER JOIN e.planoContas p INNER JOIN e.formaPagamento fp INNER JOIN e.fornecedor f INNER JOIN e.itemEstoque ie INNER JOIN e.contasPagar cp WHERE e.centroCusto.id = c.id AND e.pedidoCompra.id = pc.id AND p.id = e.planoContas.id AND e.fornecedor.id = fp.id AND e.fornecedor.id = f.id AND e.id = ie.entradaEstoque.id AND e.contasPagar.id = cp.id AND f.cnpj = :cnpjFornecedor"),
		@NamedQuery(name = "entradaEstoque.searchAllByPlanoContas", query = "SELECT e FROM EntradaEstoque e INNER JOIN e.centroCusto c INNER JOIN e.pedidoCompra pc INNER JOIN e.planoContas p INNER JOIN e.formaPagamento fp INNER JOIN e.fornecedor f INNER JOIN e.itemEstoque ie INNER JOIN e.contasPagar cp WHERE e.centroCusto.id = c.id AND e.pedidoCompra.id = pc.id AND p.id = e.planoContas.id AND e.fornecedor.id = fp.id AND e.fornecedor.id = f.id AND e.id = ie.entradaEstoque.id AND e.contasPagar.id = cp.id AND e.planoContas.id = :IDPlanoContas"),
		@NamedQuery(name = "entradaEstoque.searchAllByReleaseDate", query = "SELECT e FROM EntradaEstoque e INNER JOIN e.centroCusto c INNER JOIN e.pedidoCompra pc INNER JOIN e.planoContas p INNER JOIN e.formaPagamento fp INNER JOIN e.fornecedor f INNER JOIN e.itemEstoque ie INNER JOIN e.contasPagar cp WHERE e.centroCusto.id = c.id AND e.pedidoCompra.id = pc.id AND p.id = e.planoContas.id AND e.fornecedor.id = fp.id AND e.fornecedor.id = f.id AND e.id = ie.entradaEstoque.id AND e.contasPagar.id = cp.id AND e.dataLancamento BETWEEN :data1 AND :data2"),
		@NamedQuery(name = "entradaEstoque.searchByDateDelivery", query = "SELECT e FROM EntradaEstoque e INNER JOIN e.centroCusto c INNER JOIN e.pedidoCompra pc INNER JOIN e.planoContas p INNER JOIN e.formaPagamento fp INNER JOIN e.fornecedor f INNER JOIN e.itemEstoque ie INNER JOIN e.contasPagar cp WHERE e.centroCusto.id = c.id AND e.pedidoCompra.id = pc.id AND p.id = e.planoContas.id AND e.fornecedor.id = fp.id AND e.fornecedor.id = f.id AND e.id = ie.entradaEstoque.id AND e.contasPagar.id = cp.id AND e.dataEntrega BETWEEN :data1 AND :data2") })
@SequenceGenerator(name = "EntradaEstoque_SEQ", sequenceName = "EntradaEstoque_SEQ", allocationSize = 1, initialValue = 1)
public class EntradaEstoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EntradaEstoque_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@OneToMany(mappedBy = "entradaEstoque", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
	}

	public EntradaEstoque(Long id, List<ItemEstoque> itemEstoque,
			PedidoCompra pedidoCompra, Date dataLancamento, Date dataEntrega,
			Fornecedor fornecedor, Finalidade finalidade,
			TipoCompra tipoCompra, FormaPagamento formaPagamento,
			BigDecimal valorFrete, BigDecimal valorDesconto,
			BigDecimal valorTotal, ContasPagar contasPagar,
			PlanoContas planoContas, CentroCusto centroCusto) {
		this.id = id;
		this.itemEstoque = itemEstoque;
		this.pedidoCompra = pedidoCompra;
		this.dataLancamento = dataLancamento;
		this.dataEntrega = dataEntrega;
		this.fornecedor = fornecedor;
		this.finalidade = finalidade;
		this.tipoCompra = tipoCompra;
		this.formaPagamento = formaPagamento;
		this.valorFrete = valorFrete;
		this.valorDesconto = valorDesconto;
		this.valorTotal = valorTotal;
		this.contasPagar = contasPagar;
		this.planoContas = planoContas;
		this.centroCusto = centroCusto;
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
		EntradaEstoque other = (EntradaEstoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
