package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
 * @2016
 * @20:12:35
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "produto", indexes = {
		@Index(name = "IDX_PRODUTO_DESCRICAO", columnList = "descricao"),
		@Index(name = "IDX_PRODUTO_CODBARRA", columnList = "codigoBarra"),
		@Index(name = "IDX_PRODUTO_QTDESTOQUE", columnList = "qtdEstoque") }, uniqueConstraints = { @UniqueConstraint(name = "PRODUTO_UQ", columnNames = {
		"descricao", "codigoBarra" }) })
@NamedQueries({
		@NamedQuery(name = "produto.searchAll", query = "SELECT p FROM Produto p INNER JOIN p.fabricante f INNER JOIN p.fornecedor for INNER JOIN p.marca m INNER JOIN p.prateleira prat INNER JOIN p.unidadeMedida un WHERE p.unidadeMedida.id = un.id AND p.prateleira.id = prat.id AND p.marca.id = m.id AND p.fornecedor.id = for.id AND p.fabricante.id = f.id"),
		@NamedQuery(name = "produto.searchByDescricao", query = "SELECT p FROM Produto p INNER JOIN p.fabricante f INNER JOIN p.fornecedor for INNER JOIN p.marca m INNER JOIN p.prateleira prat INNER JOIN p.unidadeMedida un WHERE p.unidadeMedida.id = un.id AND p.prateleira.id = prat.id AND p.marca.id = m.id AND p.fornecedor.id = for.id AND p.fabricante.id = f.id AND  p.descricao LIKE :descricao"),
		@NamedQuery(name = "produto.searchByCodigoBarras", query = "SELECT p FROM Produto p INNER JOIN p.fabricante f INNER JOIN p.fornecedor for INNER JOIN p.marca m INNER JOIN p.prateleira prat INNER JOIN p.unidadeMedida un WHERE p.unidadeMedida.id = un.id AND p.prateleira.id = prat.id AND p.marca.id = m.id AND p.fornecedor.id = for.id AND p.fabricante.id = f.id AND  p.codigoBarras = :codigoBarras") })
@SequenceGenerator(name = "Produto_SEQ", sequenceName = "Produto_SEQ", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Produto_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@OneToOne
	@JoinColumn(name = "marca_id", nullable = false, foreignKey = @ForeignKey(name = "FK_MARCA_ID"))
	private Marca marca;

	@OneToOne
	@JoinColumn(name = "prateleira_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PRATELEIRA_ID"))
	private Prateleira prateleira;

	@OneToOne
	@JoinColumn(name = "fabricante_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FABRICANTE_ID"))
	private Fabricante fabricante;

	@OneToOne
	@JoinColumn(name = "fornecedor_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FORNECEDOR_ID"))
	private Fornecedor fornecedor;

	@Column(name = "descricao", length = 60)
	private String descricao;

	@Column(name = "codigoBarra", length = 40)
	private String codigoBarras;

	@OneToOne
	@JoinColumn(name = "unMedida_id", nullable = false, foreignKey = @ForeignKey(name = "FK_UNMEDIDA_ID"))
	private UnidadeMedida unidadeMedida;

	@Column(name = "qtdEstoque")
	private Long qtdEstoque;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataCadastro")
	private Date dataCadastro;

	@Column(name = "precoCusto", scale = 2, precision = 9)
	private BigDecimal precoCusto;

	@Column(name = "percVenda", scale = 2, precision = 9)
	private BigDecimal percVenda;

	@Column(name = "precoVenda", scale = 2, precision = 9)
	private BigDecimal precoVenda;

	public Produto() {
	}

	public Produto(Long id, Marca marca, Prateleira prateleira,
			Fabricante fabricante, Fornecedor fornecedor, String descricao,
			String codigoBarras, UnidadeMedida unidadeMedida, Long qtdEstoque,
			Date dataCadastro, BigDecimal precoCusto, BigDecimal percVenda,
			BigDecimal precoVenda) {
		this.id = id;
		this.marca = marca;
		this.prateleira = prateleira;
		this.fabricante = fabricante;
		this.fornecedor = fornecedor;
		this.descricao = descricao;
		this.codigoBarras = codigoBarras;
		this.unidadeMedida = unidadeMedida;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.precoCusto = precoCusto;
		this.percVenda = percVenda;
		this.precoVenda = precoVenda;
	}

	public final Marca getMarca() {
		return marca;
	}

	public final Prateleira getPrateleira() {
		return prateleira;
	}

	public final Fabricante getFabricante() {
		return fabricante;
	}

	public final Fornecedor getFornecedor() {
		return fornecedor;
	}

	public final String getDescricao() {
		return descricao;
	}

	public final String getCodigoBarras() {
		return codigoBarras;
	}

	public final UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public final Long getQtEstoque() {
		return qtdEstoque;
	}

	public final Date getDataCadastro() {
		return dataCadastro;
	}

	public final BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public final BigDecimal getPercVenda() {
		return percVenda;
	}

	public final BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void setPrateleira(Prateleira prateleira) {
		this.prateleira = prateleira;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public void setQtEstoque(Long qtEstoque) {
		this.qtdEstoque = qtEstoque;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public void setPercVenda(BigDecimal percVenda) {
		this.percVenda = percVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public final Long getId() {
		return id;
	}

	public final Long getQtdEstoque() {
		return qtdEstoque;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQtdEstoque(Long qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
