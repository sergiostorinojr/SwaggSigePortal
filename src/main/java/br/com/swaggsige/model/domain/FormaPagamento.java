package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "formaPagamento", indexes = {
		@Index(name = "IDX_FORMAPAGAMENTO_DESCRICAO", columnList = "descricao")}, 
		uniqueConstraints = { @UniqueConstraint(name = "FORMAPAGAMENTO_UQ", columnNames = {
		"descricao"}) })
public class FormaPagamento extends AbstractEntity implements Serializable {

	@Column(name = "descricao", length = 60)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "condPagamento")
	private CondicaoPagamento condicaoPagamento;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoPagamento")
	private TipoPagamento tipoPagamento;

	@OneToMany(mappedBy = "formaPagamento", cascade = CascadeType.ALL)
	private List<ParcelasFormaPgto> idParcFormaPagto;

	@Column(name = "numPagamento")
	private Integer numPagamento;

	public FormaPagamento() {
		// TODO Auto-generated constructor stub
	}

	public final String getDescricao() {
		return descricao;
	}

	public final CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public final TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public final List<ParcelasFormaPgto> getIdParcFormaPagto() {
		return idParcFormaPagto;
	}

	public final Integer getNumPagamento() {
		return numPagamento;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public void setIdParcFormaPagto(List<ParcelasFormaPgto> idParcFormaPagto) {
		this.idParcFormaPagto = idParcFormaPagto;
	}

	public void setNumPagamento(Integer numPagamento) {
		this.numPagamento = numPagamento;
	}

}
