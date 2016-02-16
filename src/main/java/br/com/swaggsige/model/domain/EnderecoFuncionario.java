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
@Table(name = "enderecoFuncionario", indexes = {
		@Index(name = "IDX_ENDERECOFUNCIONARIO_CEP", columnList = "cep"),
		@Index(name = "IDX_ENDERECOFUNCIONARIO_LOGRADOURO", columnList = "logradouro"),
		@Index(name = "IDX_ENDERECOFUNCIONARIO_BAIRRO", columnList = "bairro"),
		@Index(name = "IDX_ENDERECOFUNCIONARIO_CIDADE", columnList = "cidade"),
		@Index(name = "IDX_ENDERECOFUNCIONARIO_PAIS", columnList = "pais") })
public class EnderecoFuncionario extends Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FUNCIONARIO_ID"))
	private Funcionario funcionario;

	public EnderecoFuncionario() {
	}

	public EnderecoFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public final Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
