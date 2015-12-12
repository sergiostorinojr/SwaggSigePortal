package br.com.swaggsige.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "controleLog4j")
public class Log4j extends AbstractEntity implements Serializable {

	@Column(name = "data", length = 25)
	private String data;
	@Column(name = "applicacao", length = 2000)
	private String applicacao;
	@Column(name = "thread", length = 200)
	private String thread;
	@Column(name = "categoria", length = 200)
	private String categoria;
	@Column(name = "prioridade", length = 400)
	private String prioridade;
	@Column(name = "mensagem", length = 500)
	private String mensagem;

	public Log4j() {
		// TODO Auto-generated constructor stub
	}

	public final String getData() {
		return data;
	}

	public final String getApplicacao() {
		return applicacao;
	}

	public final String getThread() {
		return thread;
	}

	public final String getCategoria() {
		return categoria;
	}

	public final String getPrioridade() {
		return prioridade;
	}

	public final String getMensagem() {
		return mensagem;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setApplicacao(String applicacao) {
		this.applicacao = applicacao;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
