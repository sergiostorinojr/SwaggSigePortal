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
 *  SigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *  @2016
 *  @22:47:55
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "movimentacaoBancaria", indexes = {
		@Index(name = "IDX_MOVIMENTACAOBANCARIA_NUMMOVIMENTACAO", columnList = "numMovimentacao"),
		@Index(name = "IDX_MOVIMENTACAOBANCARIA_NUMCHEQUE", columnList = "numCheque"),
		@Index(name = "IDX_MOVIMENTACAOBANCARIA_DATALANCAMENTO", columnList = "dataLancamento"),
		@Index(name = "IDX_MOVIMENTACAOBANCARIA_CHNOMINAL", columnList = "chNominal") }, uniqueConstraints = { @UniqueConstraint(name = "MOVIMENTACAOBANCARIA_UQ", columnNames = {
		"numMovimentacao", "numCheque" }) })
@NamedQueries({
		@NamedQuery(name = "MovimentacaoBancaria.searchAll", query = "SELECT m FROM MovimentacaoBancaria m INNER JOIN m.centroCusto c INNER JOIN m.planoContas p INNER JOIN m.contaBancaria cb INNER JOIN m.funcionario f WHERE m.centroCusto.id = c.id AND m.planoContas.id = c.id AND m.contaBancaria.id = cb.id AND m.funcionario.id = c.id"),
		@NamedQuery(name = "contasPagar.searchByNumMov", query = "SELECT m FROM MovimentacaoBancaria m INNER JOIN m.centroCusto c INNER JOIN m.planoContas p INNER JOIN m.contaBancaria cb INNER JOIN m.funcionario f WHERE m.centroCusto.id = c.id AND m.planoContas.id = c.id AND m.contaBancaria.id = cb.id AND m.funcionario.id = c.id AND m.numMovimentacao = :numMovimentacao"),
		@NamedQuery(name = "contasPagar.searchNumCheque", query = "SELECT m FROM MovimentacaoBancaria m INNER JOIN m.centroCusto c INNER JOIN m.planoContas p INNER JOIN m.contaBancaria cb INNER JOIN m.funcionario f WHERE m.centroCusto.id = c.id AND m.planoContas.id = c.id AND m.contaBancaria.id = cb.id AND m.funcionario.id = c.id AND m.numCheque = :numCheque"),
		@NamedQuery(name = "contasPagar.searchAllPlanoContas", query = "SELECT m FROM MovimentacaoBancaria m INNER JOIN m.centroCusto c INNER JOIN m.planoContas p INNER JOIN m.contaBancaria cb INNER JOIN m.funcionario f WHERE m.centroCusto.id = c.id AND m.planoContas.id = c.id AND m.contaBancaria.id = cb.id AND m.funcionario.id = c.id AND m.planoContas.id = :idPlanoContas"),
		@NamedQuery(name = "contasPagar.searchByDateRelease", query = "SELECT m FROM MovimentacaoBancaria m INNER JOIN m.centroCusto c INNER JOIN m.planoContas p INNER JOIN m.contaBancaria cb INNER JOIN m.funcionario f WHERE m.centroCusto.id = c.id AND m.planoContas.id = c.id AND m.contaBancaria.id = cb.id AND m.funcionario.id = c.id AND m.dataLancamento BETWEEN :data1 AND :data2"),
		@NamedQuery(name = "contasPagar.searchByDateMovement", query = "SELECT m FROM MovimentacaoBancaria m INNER JOIN m.centroCusto c INNER JOIN m.planoContas p INNER JOIN m.contaBancaria cb INNER JOIN m.funcionario f WHERE m.centroCusto.id = c.id AND m.planoContas.id = c.id AND m.contaBancaria.id = cb.id AND m.funcionario.id = c.id AND m.dataMovimentacao BETWEEN :data1 AND :data2") })
@SequenceGenerator(name = "MovimentacaoBancaria_SEQ", sequenceName = "MovimentacaoBancaria_SEQ", allocationSize = 1, initialValue = 1)
public class MovimentacaoBancaria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MovimentacaoBancaria_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "numMovimentacao")
	private Long numMovimentacao;

	@OneToOne
	@JoinColumn(name = "contaBancaria_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CONTABANCARIA_ID"))
	private ContaBancaria contaBancaria;

	@OneToOne
	@JoinColumn(name = "funcionario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FUNCIONARIO_ID"))
	private Funcionario funcionario;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoOperacao", length = 20)
	private TipoOperacao tipoOperacao;

	@OneToOne
	@JoinColumn(name = "centroCusto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CENTROCUSTO_ID"))
	private CentroCusto centroCusto;

	@OneToOne
	@JoinColumn(name = "planoContas_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PLANOCONTAS_ID"))
	private PlanoContas planoContas;

	@OneToMany(mappedBy = "movBancaria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContasReceber> contasReceber;

	@OneToMany(mappedBy = "movBancaria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContasPagar> contasPagar;

	@Column(name = "numCheque")
	private Long numCheque;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataLancamento")
	private Date dataLancamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataMovimentacao")
	private Date dataMovimentacao;

	@Column(name = "valor", scale = 2, precision = 9)
	private BigDecimal valor;

	@Column(name = "chNominal", length = 60)
	private String chNominal;

	@Column(name = "observacoes", length = 500)
	private String observacoes;

	public MovimentacaoBancaria() {
	}

	public MovimentacaoBancaria(Long id, Long numMovimentacao,
			ContaBancaria contaBancaria, Funcionario funcionario,
			TipoOperacao tipoOperacao, CentroCusto centroCusto,
			PlanoContas planoContas, List<ContasReceber> contasReceber,
			List<ContasPagar> contasPagar, Long numCheque, Date dataLancamento,
			Date dataMovimentacao, BigDecimal valor, String chNominal,
			String observacoes) {
		this.id = id;
		this.numMovimentacao = numMovimentacao;
		this.contaBancaria = contaBancaria;
		this.funcionario = funcionario;
		this.tipoOperacao = tipoOperacao;
		this.centroCusto = centroCusto;
		this.planoContas = planoContas;
		this.contasReceber = contasReceber;
		this.contasPagar = contasPagar;
		this.numCheque = numCheque;
		this.dataLancamento = dataLancamento;
		this.dataMovimentacao = dataMovimentacao;
		this.valor = valor;
		this.chNominal = chNominal;
		this.observacoes = observacoes;
	}

	public final Long getNumMovimentacao() {
		return numMovimentacao;
	}

	public final ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public final Funcionario getFuncionario() {
		return funcionario;
	}

	public final TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public final CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public final PlanoContas getPlanoContas() {
		return planoContas;
	}

	public final List<ContasReceber> getIdcontasReceber() {
		return contasReceber;
	}

	public final List<ContasPagar> getIdcontasPagar() {
		return contasPagar;
	}

	public final Long getNumCheque() {
		return numCheque;
	}

	public final Date getDataLancamento() {
		return dataLancamento;
	}

	public final Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public final BigDecimal getValor() {
		return valor;
	}

	public final String getChNominal() {
		return chNominal;
	}

	public final String getObservacoes() {
		return observacoes;
	}

	public void setNumMovimentacao(Long numMovimentacao) {
		this.numMovimentacao = numMovimentacao;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public void setPlanoContas(PlanoContas planoContas) {
		this.planoContas = planoContas;
	}

	public void setIdcontasReceber(List<ContasReceber> idcontasReceber) {
		this.contasReceber = idcontasReceber;
	}

	public void setIdcontasPagar(List<ContasPagar> idcontasPagar) {
		this.contasPagar = idcontasPagar;
	}

	public void setNumCheque(Long numCheque) {
		this.numCheque = numCheque;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setChNominal(String chNominal) {
		this.chNominal = chNominal;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public final Long getId() {
		return id;
	}

	public final List<ContasReceber> getContasReceber() {
		return contasReceber;
	}

	public final List<ContasPagar> getContasPagar() {
		return contasPagar;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setContasReceber(List<ContasReceber> contasReceber) {
		this.contasReceber = contasReceber;
	}

	public void setContasPagar(List<ContasPagar> contasPagar) {
		this.contasPagar = contasPagar;
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
		MovimentacaoBancaria other = (MovimentacaoBancaria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
