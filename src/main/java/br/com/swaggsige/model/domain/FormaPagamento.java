package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
 *  @17:16:40
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "formaPagamento", indexes = { @Index(name = "IDX_FORMAPAGAMENTO_DESCRICAO", columnList = "descricao") }, uniqueConstraints = { @UniqueConstraint(name = "FORMAPAGAMENTO_UQ", columnNames = { "descricao" }) })
@NamedQueries({
		@NamedQuery(name = "formaPagamento.searchAll", query = "SELECT f FROM FormaPagamento f INNER JOIN f.parcelasFormaPgto fpgto WHERE f.id = fpgto.formaPagamento.id"),
		@NamedQuery(name = "formaPagamento.searchByDescriptionStartsWith", query = "SELECT f FROM FormaPagamento f INNER JOIN f.parcelasFormaPgto fpgto WHERE f.id = fpgto.formaPagamento.id AND f.descricao LIKE :descricao"),
		@NamedQuery(name = "formaPagamento.searchAllByCondicaoPagamento", query = "SELECT f FROM FormaPagamento f INNER JOIN f.parcelasFormaPgto fpgto WHERE f.id = fpgto.formaPagamento.id AND f.condicaoPagamento LIKE  :condicaoPagamento"),
		@NamedQuery(name = "formaPagamento.searchAllByTipoPagamento", query = "SELECT f FROM FormaPagamento f INNER JOIN f.parcelasFormaPgto fpgto WHERE f.id = fpgto.formaPagamento.id AND f.tipoPagamento = :tipoPagamento") })
@SequenceGenerator(name = "FormaPagamento_SEQ", sequenceName = "FormaPagamento_SEQ", allocationSize = 1, initialValue = 1)
public class FormaPagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FormaPagamento_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "descricao", length = 60)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "condPagamento")
	private CondicaoPagamento condicaoPagamento;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoPagamento")
	private TipoPagamento tipoPagamento;

	@OneToMany(mappedBy = "formaPagamento", cascade = CascadeType.ALL)
	private List<ParcelasFormaPgto> parcelasFormaPgto;

	@Column(name = "numPagamento")
	private Integer numPagamento;

	public FormaPagamento() {
	}

	public FormaPagamento(Long id, String descricao,
			CondicaoPagamento condicaoPagamento, TipoPagamento tipoPagamento,
			List<ParcelasFormaPgto> parcelasFormaPgto, Integer numPagamento) {
		this.id = id;
		this.descricao = descricao;
		this.condicaoPagamento = condicaoPagamento;
		this.tipoPagamento = tipoPagamento;
		this.parcelasFormaPgto = parcelasFormaPgto;
		this.numPagamento = numPagamento;
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
		return parcelasFormaPgto;
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
		this.parcelasFormaPgto = idParcFormaPagto;
	}

	public void setNumPagamento(Integer numPagamento) {
		this.numPagamento = numPagamento;
	}

	public final Long getId() {
		return id;
	}

	public final List<ParcelasFormaPgto> getParcelasFormaPgto() {
		return parcelasFormaPgto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setParcelasFormaPgto(List<ParcelasFormaPgto> parcelasFormaPgto) {
		this.parcelasFormaPgto = parcelasFormaPgto;
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
		FormaPagamento other = (FormaPagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
