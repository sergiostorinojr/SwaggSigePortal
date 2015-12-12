package br.com.swaggsige.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "usuario", indexes = {
		@Index(name = "IDX_USUARIO_LOGIN", columnList = "login"),
		@Index(name = "IDX_USUARIO_SENHA", columnList = "senha") },
		uniqueConstraints = { @UniqueConstraint(name = "USUARIO_UQ", columnNames = { "login" }) })
public class Usuario extends AbstractEntity implements Serializable {

	@Column(name = "login", length = 20)
	private String login;

	@Column(name = "senha", length = 20)
	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(name = "permissaoAcesso", length = 20)
	private PermissaoAcesso permissao;

	public Usuario() {
		// TODO Auto-generated constructor stub
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

}
