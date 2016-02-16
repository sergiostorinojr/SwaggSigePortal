package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * SigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 * @2016
 * @22:51:48
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "parcelasFormaPgto", indexes = {
		@Index(name = "IDX_PARCELASFORMAPGTO_DIAS", columnList = "dias"),
		@Index(name = "IDX_PARCELASFOMAPGTO_PARCELAS", columnList = "parcelas") })
@SequenceGenerator(name = "ParcelasFormaPgto_SEQ", sequenceName = "ParcelasFormaPgto_SEQ", allocationSize = 1, initialValue = 1)
public class ParcelasFormaPgto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ParcelasFormaPgto_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "formaPagamento_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FORMAPAGAMENTO_ID"))
	private FormaPagamento formaPagamento;

	@Column(name = "parcelas")
	private Integer parcelas;

	@Column(name = "dias")
	private Integer dias;

	public ParcelasFormaPgto() {
	}

	public ParcelasFormaPgto(Long id, FormaPagamento formaPagamento,
			Integer parcelas, Integer dias) {
		super();
		this.id = id;
		this.formaPagamento = formaPagamento;
		this.parcelas = parcelas;
		this.dias = dias;
	}

	public final FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public final Integer getParcelas() {
		return parcelas;
	}

	public final Integer getDias() {
		return dias;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
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
		ParcelasFormaPgto other = (ParcelasFormaPgto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
