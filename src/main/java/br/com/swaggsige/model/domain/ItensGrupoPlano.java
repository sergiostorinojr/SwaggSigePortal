package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
 * @22:06:04
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "itensGrupoPlano", indexes = {
		@Index(name = "IDX_ITENSGRUPOPLANO_CODREDUZIDO", columnList = "codReduzido"),
		@Index(name = "IDX_ITENSGRUPOPLANO_DESCRICAO", columnList = "descricao") })
@SequenceGenerator(name = "ItensGrupoPlano_SEQ", sequenceName = "ItensGrupoPlano_SEQ", allocationSize = 1, initialValue = 1)
public class ItensGrupoPlano implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ItensGrupoPlano_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "codReduzido", length = 60)
	private String codReduzido;

	@Column(name = "descricao", length = 100)
	private String descricao;

	@Enumerated(EnumType.STRING)
	private TipoPlano tipoPlano;

	@ManyToOne
	@JoinColumn(name = "planoContas_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PLANOCONTAS_ID"))
	private PlanoContas planoContas;

	@Column(name = "previsaogasto", scale = 2, precision = 9)
	private BigDecimal previsaoGasto;

	public ItensGrupoPlano() {
	}

	public ItensGrupoPlano(Long id, String codReduzido, String descricao,
			TipoPlano tipoPlano, PlanoContas planoContas,
			BigDecimal previsaoGasto) {
		this.id = id;
		this.codReduzido = codReduzido;
		this.descricao = descricao;
		this.tipoPlano = tipoPlano;
		this.planoContas = planoContas;
		this.previsaoGasto = previsaoGasto;
	}

	public final String getCodReduzido() {
		return codReduzido;
	}

	public final String getDescricao() {
		return descricao;
	}

	public final TipoPlano getTipoPlano() {
		return tipoPlano;
	}

	public final PlanoContas getPlanoContas() {
		return planoContas;
	}

	public final BigDecimal getPrevisaoGasto() {
		return previsaoGasto;
	}

	public void setCodReduzido(String codReduzido) {
		this.codReduzido = codReduzido;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setTipoPlano(TipoPlano tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public void setPlanoContas(PlanoContas planoContas) {
		this.planoContas = planoContas;
	}

	public void setPrevisaoGasto(BigDecimal previsaoGasto) {
		this.previsaoGasto = previsaoGasto;
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
		ItensGrupoPlano other = (ItensGrupoPlano) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
