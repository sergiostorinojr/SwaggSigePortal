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
 *  @22:03:49
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "itemEstoque", indexes = { @Index(name = "IDX_ITEMESTOQUE_QUANTIDADE", columnList = "quantidade") })
@SequenceGenerator(name = "ItemEstoque_SEQ", sequenceName = "ItemEstoque_SEQ", allocationSize = 1, initialValue = 1)
public class ItemEstoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ItemEstoque_SEQ")
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
	@JoinColumn(name = "entradaEstoque_id", nullable = false, foreignKey = @ForeignKey(name = "FK_ENTRADAESTOQUE_ID"))
	private EntradaEstoque entradaEstoque;

	public ItemEstoque() {
	}

	public ItemEstoque(Long id, Produto produto, Long quantidade,
			BigDecimal precUnitario, EntradaEstoque entradaEstoque) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.precUnitario = precUnitario;
		this.entradaEstoque = entradaEstoque;
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

	public final EntradaEstoque getEntradaEstoque() {
		return entradaEstoque;
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

	public void setEntradaEstoque(EntradaEstoque entradaEstoque) {
		this.entradaEstoque = entradaEstoque;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
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
		ItemEstoque other = (ItemEstoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
