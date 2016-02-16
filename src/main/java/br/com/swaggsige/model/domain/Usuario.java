package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * SigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 * @2016
 * @20:36:54
 *
 *
 */
@XmlRootElement
@Entity
@Table(name = "usuario", indexes = {
		@Index(name = "IDX_USUARIO_LOGIN", columnList = "login"),
		@Index(name = "IDX_USUARIO_SENHA", columnList = "senha") }, uniqueConstraints = { @UniqueConstraint(name = "USUARIO_UQ", columnNames = { "login" }) })
@NamedQueries({
		@NamedQuery(name = "usuario.searchAll", query = "SELECT u FROM Usuario u"),
		@NamedQuery(name = "usuario.searchLogin", query = "SELECT u FROM Usuario u  WHERE  u.login LIKE :login") })
@SequenceGenerator(name = "Usuario_SEQ", sequenceName = "Usuario_SEQ", allocationSize = 1, initialValue = 1)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Usuario_SEQ")
	@Column(name = "id", nullable = false, insertable = false, updatable = false, columnDefinition = "serial")
	private Long id;

	@Column(name = "login", length = 20)
	private String login;

	@Column(name = "senha", length = 20)
	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(name = "permissaoAcesso", length = 20)
	private PermissaoAcesso permissao;

	public Usuario() {
	}

	public Usuario(Long id, String login, String senha,
			PermissaoAcesso permissao) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.permissao = permissao;
	}

	public final String getLogin() {
		return login;
	}

	public final String getSenha() {
		return senha;
	}

	public final PermissaoAcesso getPermissao() {
		return permissao;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setPermissao(PermissaoAcesso permissao) {
		this.permissao = permissao;
	}

	public final Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha
				+ ", permissao=" + permissao + "]";
	}
	
	

}
