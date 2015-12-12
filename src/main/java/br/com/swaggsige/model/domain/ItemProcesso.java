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
@Table(name = "itemProcesso", indexes = { @Index(name = "IDX_ITEMPROCESSO_QUANTIDADE", columnList = "quantidade") })
public class ItemProcesso extends AbstractEntity implements Serializable {

	@OneToOne
	@JoinColumn(name = "produto_id",nullable=false, foreignKey = @ForeignKey(name="FK_PRODUTO_ID"))
	private Produto produto;

	@Column(name = "quantidade")
	private Long quantidade;

	@Column(name = "precUnitario", scale = 2, precision = 9)
	private BigDecimal precUnitario;

	@ManyToOne
	@JoinColumn(name = "processo_id",nullable=false, foreignKey = @ForeignKey(name="FK_PROCESSO_ID"))
	private Processo processo;

	public final Produto getProduto() {
		return produto;
	}

	public final Long getQuantidade() {
		return quantidade;
	}

	public final BigDecimal getPrecUnitario() {
		return precUnitario;
	}

	public final Processo getProcesso() {
		return processo;
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

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

}
