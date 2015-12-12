package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "itemEstoque", indexes = { @Index(name = "IDX_ITEMESTOQUE_QUANTIDADE", columnList = "quantidade") })
public class ItemEstoque extends AbstractEntity implements Serializable {

	@OneToOne
	@JoinColumn(name = "produto_id",nullable=false, foreignKey = @ForeignKey(name="FK_PRODUTO_ID"))
	private Produto produto;

	@Column(name = "quantidade")
	private Long quantidade;

	@Column(name = "precUnitario", scale = 2, precision = 9)
	private BigDecimal precUnitario;

	@ManyToOne
	@JoinColumn(name = "entradaEstoque_id",nullable=false, foreignKey = @ForeignKey(name="FK_ENTRADAESTOQUE_ID"))
	private EntradaEstoque entradaEstoque;

	public ItemEstoque() {
		// TODO Auto-generated constructor stub
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

}
