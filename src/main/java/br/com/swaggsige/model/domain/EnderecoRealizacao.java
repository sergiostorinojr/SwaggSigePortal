package br.com.swaggsige.model.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="enderecoRealizacao", indexes = {
		@Index(name = "IDX_ENDERECOREALIZACAO_CEP", columnList = "cep"),
		@Index(name = "IDX_ENDERECOREALIZACAO_LOGRADOURO", columnList = "logradouro"),
		@Index(name = "IDX_ENDERECOREALIZACAO_BAIRRO", columnList = "bairro"),
		@Index(name = "IDX_ENDERECOREALIZACAO_CIDADE", columnList = "cidade"),
		@Index(name = "IDX_ENDERECOREALIZACAO_PAIS", columnList = "pais") })
public class EnderecoRealizacao extends Endereco {

	@OneToOne
	@JoinColumn(name="processo_id", nullable=false ,foreignKey = @ForeignKey(name="FK_PROCESSO_ID"))
	private Processo processo;

	public final Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	
	


}
