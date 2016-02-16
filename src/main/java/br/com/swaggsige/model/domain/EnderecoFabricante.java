package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "enderecoFabricante", indexes = {
		@Index(name = "IDX_ENDERECOFABRICANTE_CEP", columnList = "cep"),
		@Index(name = "IDX_ENDERECOFABRICANTE_LOGRADOURO", columnList = "logradouro"),
		@Index(name = "IDX_ENDERECOFABRICANTE_BAIRRO", columnList = "bairro"),
		@Index(name = "IDX_ENDERECOFABRICANTE_CIDADE", columnList = "cidade"),
		@Index(name = "IDX_ENDERECOFABRICANTE_PAIS", columnList = "pais") })
public class EnderecoFabricante extends Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "fabricante_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FABRICANTE_ID"))
	private Fabricante fabricante;

	public EnderecoFabricante() {
	}

	public EnderecoFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public final Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}
