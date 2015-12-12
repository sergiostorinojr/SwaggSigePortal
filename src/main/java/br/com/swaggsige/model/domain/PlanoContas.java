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
@Table(name = "planoContas", indexes = { 
		@Index(name = "IDX_PLANOCONTAS_DESCRICAO", columnList = "descricao") }, uniqueConstraints = { 
		@UniqueConstraint(name = "PLANOCONTAS_UQ", columnNames = { "descricao" }) })
public class PlanoContas extends AbstractEntity implements Serializable {

	@Column(name = "descricao", length = 60)
	private String descricao;

	@OneToMany(mappedBy = "planoContas", cascade = CascadeType.ALL)
	private List<ItensGrupoPlano> idItensGrupoPlano;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	public PlanoContas() {
		// TODO Auto-generated constructor stub
	}

	public final String getDescricao() {
		return descricao;
	}

	public final List<ItensGrupoPlano> getIdItensGrupoPlano() {
		return idItensGrupoPlano;
	}

	public final Situacao getSituacao() {
		return situacao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setIdItensGrupoPlano(List<ItensGrupoPlano> idItensGrupoPlano) {
		this.idItensGrupoPlano = idItensGrupoPlano;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

}
