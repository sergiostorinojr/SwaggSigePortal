package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "centroCusto", indexes = { @Index(name = "IDX_CENTROCUSTO_DESCRICAO", columnList = "descricao") }, 
			uniqueConstraints = { @UniqueConstraint(name = "CLIENTEPF_UQ", columnNames = { "descricao" }) })
public class CentroCusto extends AbstractEntity implements Serializable {

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
		// TODO Auto-generated constructor stub
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

}
