package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "centroCusto", indexes = { @Index(name = "IDX_CENTROCUSTO_DESCRICAO", columnList = "descricao") }, uniqueConstraints = { @UniqueConstraint(name = "CLIENTEPF_UQ", columnNames = { "descricao" }) })
@NamedQueries({
		@NamedQuery(name = "centroCusto.getAll", query = "SELECT c FROM CentroCusto c "),
		@NamedQuery(name = "centroCusto.getAllByDescriptionStartsWith", query = "SELECT c FROM CentroCusto c WHERE c.descricao LIKE :descricao") })
@SequenceGenerator(name = "CentroCusto_SEQ", sequenceName = "CentroCusto_SEQ", allocationSize = 1, initialValue = 1)
public class CentroCusto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CentroCusto_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;
	@Column(name = "descricao", nullable = false, length = 60)
	private String descricao;

	@Column(name = "valorOrcamento", precision = 9, scale = 2)
	private BigDecimal valorOrcamento;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", length = 7)
	private Situacao situacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoOrcamento", length = 15)
	private TipoOrcamento tipoOrcamento;

	public CentroCusto() {
	}

	public CentroCusto(Long id, String descricao, BigDecimal valorOrcamento,
			Situacao situacao, TipoOrcamento tipoOrcamento) {
		this.id = id;
		this.descricao = descricao;
		this.valorOrcamento = valorOrcamento;
		this.situacao = situacao;
		this.tipoOrcamento = tipoOrcamento;
	}

	public final String getDescricao() {
		return descricao;
	}

	public final BigDecimal getValorOrcamento() {
		return valorOrcamento;
	}

	public final Situacao getSituacao() {
		return situacao;
	}

	public final TipoOrcamento getTipoOrcamento() {
		return tipoOrcamento;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValorOrcamento(BigDecimal valorOrcamento) {
		this.valorOrcamento = valorOrcamento;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public void setTipoOrcamento(TipoOrcamento tipoOrcamento) {
		this.tipoOrcamento = tipoOrcamento;
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
		CentroCusto other = (CentroCusto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
