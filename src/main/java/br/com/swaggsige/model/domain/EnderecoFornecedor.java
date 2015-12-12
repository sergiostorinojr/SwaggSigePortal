package br.com.swaggsige.model.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "enderecoFornecedor", indexes = {
		@Index(name = "IDX_ENDERECOFORNECEDOR_CEP", columnList = "cep"),
		@Index(name = "IDX_ENDERECOFORNECEDOR_LOGRADOURO", columnList = "logradouro"),
		@Index(name = "IDX_ENDERECOFORNECEDOR_BAIRRO", columnList = "bairro"),
		@Index(name = "IDX_ENDERECOFORNECEDOR_CIDADE", columnList = "cidade"),
		@Index(name = "IDX_ENDERECOFORNECEDOR_PAIS", columnList = "pais") })
public class EnderecoFornecedor extends Endereco {

	@ManyToOne
	@JoinColumn(name = "fornecedor_id", nullable=false ,foreignKey = @ForeignKey(name="FK_FORNECEDOR_ID"))
	private Fornecedor fornecedor;
	
	public EnderecoFornecedor() {
		// TODO Auto-generated constructor stub
	}

	public final Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
