package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "parcelasFormaPgto", indexes = {
		@Index(name = "IDX_PARCELASFORMAPGTO_DIAS", columnList = "dias"),
		@Index(name = "IDX_PARCELASFOMAPGTO_PARCELAS", columnList = "parcelas")})
public class ParcelasFormaPgto extends AbstractEntity implements Serializable {

	@ManyToOne
	@JoinColumn(name = "formaPagamento_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FORMAPAGAMENTO_ID"))
	private FormaPagamento formaPagamento;

	@Column(name = "parcelas")
	private Integer parcelas;

	@Column(name = "dias")
	private Integer dias;

	public ParcelasFormaPgto() {
		// TODO Auto-generated constructor stub
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

}
