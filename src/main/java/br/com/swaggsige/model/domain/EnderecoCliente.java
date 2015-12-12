package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="enderecoCliente", indexes = {
		@Index(name = "IDX_ENDERECOCLIENTE", columnList = "cep"),
		@Index(name = "IDX_ENDERECOCLIENTE_LOGRADOURO", columnList = "logradouro"),
		@Index(name = "IDX_ENDERECOCLIENTE_BAIRRO", columnList = "bairro"),
		@Index(name = "IDX_ENDERECOCLIENTE_CIDADE", columnList = "cidade"),
		@Index(name = "IDX_ENDERECOCLIENTE_PAIS", columnList = "pais") })
public class EnderecoCliente extends Endereco implements Serializable{

	@ManyToOne
	@JoinColumn(name="cliente_id", nullable=false,foreignKey = @ForeignKey(name="FK_CLIENTE_ID"))
	private Cliente cliente;
	
	public EnderecoCliente() {
	}

	public final Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	


}
