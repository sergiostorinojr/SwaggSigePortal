package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
 * SwaggSigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 * @2016
 * @14:45:07
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "planoContas", indexes = { @Index(name = "IDX_PLANOCONTAS_DESCRICAO", columnList = "descricao") }, uniqueConstraints = { @UniqueConstraint(name = "PLANOCONTAS_UQ", columnNames = { "descricao" }) })
@NamedQueries({
		@NamedQuery(name = "planoContas.searchAll", query = "SELECT p FROM PlanoContas p INNER JOIN p.itensGrupoPlano ip WHERE p.id = ip.id"),
		@NamedQuery(name = "planoContas.searchNumPedido", query = "SELECT p FROM PlanoContas p INNER JOIN p.itensGrupoPlano ip WHERE p.id = ip.id AND ip.descricao LIKE :descricao") })
@SequenceGenerator(name = "PlanoContas_SEQ", sequenceName = "PlanoContas_SEQ", allocationSize = 1, initialValue = 1)
public class PlanoContas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PlanoContas_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "descricao", length = 60)
	private String descricao;

	@OneToMany(mappedBy = "planoContas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ItensGrupoPlano> itensGrupoPlano;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	public PlanoContas() {
	}

	public PlanoContas(Long id, String descricao,
			List<ItensGrupoPlano> itensGrupoPlano, Situacao situacao) {
		this.id = id;
		this.descricao = descricao;
		this.itensGrupoPlano = itensGrupoPlano;
		this.situacao = situacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItensGrupoPlano(List<ItensGrupoPlano> itensGrupoPlano) {
		this.itensGrupoPlano = itensGrupoPlano;
	}

	public final Long getId() {
		return id;
	}

	public final List<ItensGrupoPlano> getItensGrupoPlano() {
		return itensGrupoPlano;
	}

	public final String getDescricao() {
		return descricao;
	}

	public final List<ItensGrupoPlano> getIdItensGrupoPlano() {
		return itensGrupoPlano;
	}

	public final Situacao getSituacao() {
		return situacao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setIdItensGrupoPlano(List<ItensGrupoPlano> idItensGrupoPlano) {
		this.itensGrupoPlano = idItensGrupoPlano;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
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
		PlanoContas other = (PlanoContas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
