package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "produto", indexes = {
		@Index(name = "IDX_PRODUTO_DESCRICAO", columnList = "descricao"),
		@Index(name = "IDX_PRODUTO_CODBARRA", columnList = "codigoBarra"),
		@Index(name = "IDX_PRODUTO_QTDESTOQUE", columnList = "qtEstoque") }, uniqueConstraints = { 
		@UniqueConstraint(name = "PRODUTO_UQ", columnNames = {"descricao", "codigoBarra" }) })
public class Produto extends AbstractEntity implements Serializable {

	@OneToOne
	@JoinColumn(name = "marca_id", nullable=false, foreignKey =@ForeignKey(name="FK_MARCA_ID") )
	private Marca marca;

	@OneToOne
	@JoinColumn(name = "prateleira_id", nullable=false, foreignKey =@ForeignKey(name="FK_PRATELEIRA_ID") )
	private Prateleira prateleira;

	@OneToOne
	@JoinColumn(name = "fabricante_id", nullable=false, foreignKey =@ForeignKey(name="FK_FABRICANTE_ID") )
	private Fabricante fabricante;

	@OneToOne
	@JoinColumn(name = "fornecedor_id", nullable=false, foreignKey =@ForeignKey(name="FK_FORNECEDOR_ID") )
	private Fornecedor fornecedor;

	@Column(name = "descricao", length = 60)
	private String descricao;

	@Column(name = "codigoBarra", length = 40)
	private String codigoBarras;

	@OneToOne
	@JoinColumn(name = "unMedida_id", nullable=false, foreignKey =@ForeignKey(name="FK_UNMEDIDA_ID") )
	private UnidadeMedida unidadeMedida;

	@Column(name = "qtEstoque")
	private Long qtEstoque;

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
		// TODO Auto-generated constructor stub
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
		return qtEstoque;
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
		this.qtEstoque = qtEstoque;
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


}
