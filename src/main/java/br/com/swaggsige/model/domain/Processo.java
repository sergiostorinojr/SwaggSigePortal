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
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "processo", indexes = {
		@Index(name = "IDX_PROCESSO_DATAEMISSAO", columnList = "dataEmissao"),
		@Index(name = "IDX_PROCESSO_DATAREALIZACAO", columnList = "dataRealizacao")})
public class Processo extends AbstractEntity implements Serializable {

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

	@OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
	private List<ItemProcesso> itemProcesso;

	@OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
	private List<EnderecoRealizacao> enderecoRealizacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", length = 15)
	private SituacaoProcesso situacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoProcesso", length = 15)
	private TipoProcesso tipo;

	@ManyToOne
	@JoinColumn(name = "contasReceber_id", nullable=false, foreignKey = @ForeignKey(name="FK_CONTASRECEBER_ID"))
	private ContasReceber contasReceber;

	@OneToOne
	@JoinColumn(name = "formaPagamento_id", nullable=false, foreignKey = @ForeignKey(name="FK_FORMAPAGAMENTO_ID") )
	private FormaPagamento formaPagamento;
	
	public Processo() {
		// TODO Auto-generated constructor stub
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

}
