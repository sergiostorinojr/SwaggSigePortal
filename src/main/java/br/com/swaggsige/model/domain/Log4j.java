package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 *  SigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *  @2016
 *  @22:09:49
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "controleLog4j")
@SequenceGenerator(name = "Log4j_SEQ", sequenceName = "Log4j_SEQ", allocationSize = 1, initialValue = 1)
public class Log4j implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Log4j_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;
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
	@Column(name = "mensagem", length = 22500)
	private String mensagem;

	public Log4j() {
	}

	public Log4j(Long id, String data, String applicacao, String thread,
			String categoria, String prioridade, String mensagem) {
		this.id = id;
		this.data = data;
		this.applicacao = applicacao;
		this.thread = thread;
		this.categoria = categoria;
		this.prioridade = prioridade;
		this.mensagem = mensagem;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log4j other = (Log4j) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
