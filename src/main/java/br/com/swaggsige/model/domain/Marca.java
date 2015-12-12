package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "marca", indexes = { @Index(name = "IDX_MARCA_DESCRICAO", columnList = "descricao") })
@NamedQueries({
		@NamedQuery(name = "marca.getAll", query = "SELECT m FROM Marca m "),
		@NamedQuery(name = "marca.findById", query = "SELECT m FROM Marca m WHERE m.id = :id"),
		@NamedQuery(name = "marca.getAllByDescriptionStartsWith", query = "SELECT m FROM Marca m WHERE m.descricao LIKE :descricao") })
public class Marca extends AbstractEntity implements Serializable {

	@Column(name = "descricao")
	private String descricao;

	public Marca() {
		// TODO Auto-generated constructor stub
	}

	public final String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
