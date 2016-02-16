package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 *  SigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *  @2016
 *  @22:03:57
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "ItemCompra", indexes = { @Index(name = "IDX_ITEMCOMPRA_QUANTIDADE", columnList = "quantidade") })
@SequenceGenerator(name = "ItemCompra_SEQ", sequenceName = "ItemCompra_SEQ", allocationSize = 1, initialValue = 1)
public class ItemCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ItemCompra_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@OneToOne
	@JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUTO_ID"))
	private Produto produto;

	@Column(name = "quantidade")
	private Long quantidade;

	@Column(name = "precUnitario", scale = 2, precision = 9)
	private BigDecimal precUnitario;

	@ManyToOne
	@JoinColumn(name = "pedidoCompra_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PEDIDOCOMPRA_ID"))
	private PedidoCompra pedidoCompra;

	public ItemCompra() {
	}

	public ItemCompra(Long id, Produto produto, Long quantidade,
			BigDecimal precUnitario, PedidoCompra pedidoCompra) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.precUnitario = precUnitario;
		this.pedidoCompra = pedidoCompra;
	}

	public final Produto getProduto() {
		return produto;
	}

	public final Long getQuantidade() {
		return quantidade;
	}

	public final BigDecimal getPrecUnitario() {
		return precUnitario;
	}

	public final PedidoCompra getPedidoCompra() {
		return pedidoCompra;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public void setPrecUnitario(BigDecimal precUnitario) {
		this.precUnitario = precUnitario;
	}

	public void setPedidoCompra(PedidoCompra pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public final Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCompra other = (ItemCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
