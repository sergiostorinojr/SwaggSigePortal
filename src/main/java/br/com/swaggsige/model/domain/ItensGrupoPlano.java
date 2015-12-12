package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="itensGrupoPlano", indexes = { @Index(name = "IDX_ITENSGRUPOPLANO_CODREDUZIDO", columnList = "codReduzido"),
		@Index(name = "IDX_ITENSGRUPOPLANO_DESCRICAO", columnList = "descricao")})
public class ItensGrupoPlano extends AbstractEntity implements Serializable{

	@Column(name="codReduzido", length=60)
	private String codReduzido;

	@Column(name="descricao", length=100)
	private String descricao;

	@Enumerated(EnumType.STRING)
	private TipoPlano tipoPlano;

	@ManyToOne
	@JoinColumn(name="planoContas_id",nullable=false, foreignKey = @ForeignKey(name="FK_PLANOCONTAS_ID"))
	private PlanoContas planoContas;

	@Column(name="previsaogasto", scale=2, precision=9)
	private BigDecimal previsaoGasto;
	
	public ItensGrupoPlano() {
		// TODO Auto-generated constructor stub
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
	
	


}
