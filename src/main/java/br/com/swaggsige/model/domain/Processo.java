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
 *  SigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *  @2016
 *  @16:26:20
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "processo", indexes = {
		@Index(name = "IDX_PROCESSO_DATAEMISSAO", columnList = "dataEmissao"),
		@Index(name = "IDX_PROCESSO_DATAREALIZACAO", columnList = "dataRealizacao") })
@NamedQueries({
		@NamedQuery(name = "processo.searchAll", query = "SELECT p FROM Processo p INNER JOIN p.contasReceber c INNER JOIN p.enderecoRealizacao er INNER JOIN p.formaPagamento f INNER JOIN p.itemProcesso ip INNER JOIN p.vendedor v INNER JOIN p.cliente cli WHERE p.cliente.id = cli.id AND p.vendedor.id = v.id AND p.id = ip.processo.id AND p.formaPagamento.id = f.id AND p.id = er.processo.id AND p.contasReceber.id = c.id"),
		@NamedQuery(name = "processo.searchByCliente", query = "SELECT p FROM Processo p INNER JOIN p.contasReceber c INNER JOIN p.enderecoRealizacao er INNER JOIN p.formaPagamento f INNER JOIN p.itemProcesso ip INNER JOIN p.vendedor v INNER JOIN p.cliente cli WHERE p.cliente.id = cli.id AND p.vendedor.id = v.id AND p.id = ip.processo.id AND p.formaPagamento.id = f.id AND p.id = er.processo.id AND p.contasReceber.id = c.id AND p.cliente.id = :cliente"),
		@NamedQuery(name = "processo.searchAllByDateIssuance", query = "SELECT p FROM Processo p INNER JOIN p.contasReceber c INNER JOIN p.enderecoRealizacao er INNER JOIN p.formaPagamento f INNER JOIN p.itemProcesso ip INNER JOIN p.vendedor v INNER JOIN p.cliente cli WHERE p.cliente.id = cli.id AND p.vendedor.id = v.id AND p.id = ip.processo.id AND p.formaPagamento.id = f.id AND p.id = er.processo.id AND p.contasReceber.id = c.id AND p.dataEmissao BETWEEN :data1 AND :data2"),
		@NamedQuery(name = "processo.searchAllByDateCompletion", query = "SELECT p FROM Processo p INNER JOIN p.contasReceber c INNER JOIN p.enderecoRealizacao er INNER JOIN p.formaPagamento f INNER JOIN p.itemProcesso ip INNER JOIN p.vendedor v INNER JOIN p.cliente cli WHERE p.cliente.id = cli.id AND p.vendedor.id = v.id AND p.id = ip.processo.id AND p.formaPagamento.id = f.id AND p.id = er.processo.id AND p.contasReceber.id = c.id AND p.dataRealizacao BETWEEN :data1 AND :data2") })
@SequenceGenerator(name = "Processo_SEQ", sequenceName = "Processo_SEQ", allocationSize = 1, initialValue = 1)
public class Processo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Processo_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataEmissao")
	private Date dataEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataRealizacao")
	private Date dataRealizacao;

	@Column(name = "observacao", length = 500)
	private String observacao;

	@Column(name = "valorDesconto", scale = 2, precision = 9)
	private BigDecimal valorDesconto;

	@Column(name = "valorTotal", scale = 2, precision = 9)
	private BigDecimal valorTotal;

	@OneToOne
	@JoinColumn(name = "funcionario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FUNCIONARIO_ID"))
	private Funcionario vendedor;

	@OneToOne
	@JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENTE_ID"))
	private Cliente cliente;

	@OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ItemProcesso> itemProcesso;

	@OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnderecoRealizacao> enderecoRealizacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", length = 15)
	private SituacaoProcesso situacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoProcesso", length = 15)
	private TipoProcesso tipo;

	@ManyToOne
	@JoinColumn(name = "contasReceber_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CONTASRECEBER_ID"))
	private ContasReceber contasReceber;

	@OneToOne
	@JoinColumn(name = "formaPagamento_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FORMAPAGAMENTO_ID"))
	private FormaPagamento formaPagamento;

	public Processo() {
	}

	public Processo(Long id, Date dataEmissao, Date dataRealizacao,
			String observacao, BigDecimal valorDesconto, BigDecimal valorTotal,
			Funcionario vendedor, Cliente cliente,
			List<ItemProcesso> itemProcesso,
			List<EnderecoRealizacao> enderecoRealizacao,
			SituacaoProcesso situacao, TipoProcesso tipo,
			ContasReceber contasReceber, FormaPagamento formaPagamento) {
		this.id = id;
		this.dataEmissao = dataEmissao;
		this.dataRealizacao = dataRealizacao;
		this.observacao = observacao;
		this.valorDesconto = valorDesconto;
		this.valorTotal = valorTotal;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.itemProcesso = itemProcesso;
		this.enderecoRealizacao = enderecoRealizacao;
		this.situacao = situacao;
		this.tipo = tipo;
		this.contasReceber = contasReceber;
		this.formaPagamento = formaPagamento;
	}

	public final Date getDataEmissao() {
		return dataEmissao;
	}

	public final Date getDataRealizacao() {
		return dataRealizacao;
	}

	public final String getObservacao() {
		return observacao;
	}

	public final BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public final BigDecimal getValorTotal() {
		return valorTotal;
	}

	public final Funcionario getVendedor() {
		return vendedor;
	}

	public final Cliente getCliente() {
		return cliente;
	}

	public final List<ItemProcesso> getItemProcesso() {
		return itemProcesso;
	}

	public final List<EnderecoRealizacao> getEnderecoRealizacao() {
		return enderecoRealizacao;
	}

	public final SituacaoProcesso getSituacao() {
		return situacao;
	}

	public final TipoProcesso getTipo() {
		return tipo;
	}

	public final ContasReceber getContasReceber() {
		return contasReceber;
	}

	public final FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setItemProcesso(List<ItemProcesso> itemProcesso) {
		this.itemProcesso = itemProcesso;
	}

	public void setEnderecoRealizacao(
			List<EnderecoRealizacao> enderecoRealizacao) {
		this.enderecoRealizacao = enderecoRealizacao;
	}

	public void setSituacao(SituacaoProcesso situacao) {
		this.situacao = situacao;
	}

	public void setTipo(TipoProcesso tipo) {
		this.tipo = tipo;
	}

	public void setContasReceber(ContasReceber contasReceber) {
		this.contasReceber = contasReceber;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
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
		Processo other = (Processo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
