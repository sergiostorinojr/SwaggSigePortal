package br.com.swaggsige.model.service.mail;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.swaggsige.model.service.exception.EmailException;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class EmailTextServiceUtil implements Serializable {

	private String emailRemetente;
	private String emailDestinario;
	private String emailCco;
	private String emailCc;
	private String email;
	private String senha;
	private String servidorSmtp;
	private String porta;
	private String assuntoEmail;
	private String msgCorpo;
	private boolean autenticacaoSSL;
	private boolean autenticacaoTLS;
	private boolean copiaOculta;
	private boolean emailCopia;
	private final String EMAIL_TEXTO = "text/plain; charset=UTF-8";

	public EmailTextServiceUtil(String emailRemetente, String emailDestinario,
			String emailCco, String emailCc, String email, String senha,
			String servidorSmtp, String porta, String assuntoEmail,
			String msgCorpo, boolean autenticacaoSSL, boolean autenticacaoTLS,
			boolean copiaOculta, boolean emailCopia) {
		super();
		this.emailRemetente = emailRemetente;
		this.emailDestinario = emailDestinario;
		this.emailCco = emailCco;
		this.emailCc = emailCc;
		this.email = email;
		this.senha = senha;
		this.servidorSmtp = servidorSmtp;
		this.porta = porta;
		this.assuntoEmail = assuntoEmail;
		this.msgCorpo = msgCorpo;
		this.autenticacaoSSL = autenticacaoSSL;
		this.autenticacaoTLS = autenticacaoTLS;
		this.copiaOculta = copiaOculta;
		this.emailCopia = emailCopia;
	}
	
	public EmailTextServiceUtil(String email, String senha,
			String servidorSmtp, String porta, boolean autenticacaoSSL,
			boolean autenticacaoTLS) {
		super();
		this.email = email;
		this.senha = senha;
		this.servidorSmtp = servidorSmtp;
		this.porta = porta;
		this.autenticacaoSSL = autenticacaoSSL;
		this.autenticacaoTLS = autenticacaoTLS;
	}



	public EmailTextServiceUtil() {
		System.err.println("Um nova sessão de email criada");
	}

	public void Envio() throws EmailException {
		Properties props = new Properties();

		if (getServidorSmtp() != null && !getServidorSmtp().isEmpty()) {

			props.put("mail.smtp.host", getServidorSmtp().trim());
		} else {

			FacesMessageUtil
					.addMsgError("Servidor SMTP Não pode ser vazio.\n Contate o administrador do Sistema");

			throw new EmailException(
					"Falha ao Enviar Email:\n Servidor SMTP Não pode ser vazio.\n Contate o administrador do Sistema");
		}

		if (getPorta() != null && !getPorta().isEmpty()) {
			props.put("mail.smtp.socketFactory.port", getPorta().trim());
			props.put("mail.smtp.socketFactory.fallback", "false");

		} else {

			FacesMessageUtil
					.addMsgError("A porta do Servidor Não pode ser vazia.\n Contate o administrador do Sistema");

			throw new EmailException(
					"Falha ao Enviar Email:\n A porta do Servidor Não pode ser vazia.\n Contate o administrador do Sistema");

		}

		/**
		 * Se for verdadeiro "Servidor precisar de autenticação SSL" então faça
		 */
		if (isAutenticacaoSSL()) {
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");

		} else {

			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "false");

		}

		/**
		 * Se for verdadeiro "Servidor precisar de autenticação TLS" então faça
		 */
		if (isAutenticacaoTLS()) {

			props.put("mail.smtp.starttls.enable", "true");

		} else {

			props.put("mail.smtp.starttls.enable", "false");

		}

		Session session = Session.getDefaultInstance(props,
				new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						if (getEmail() != null && !getEmail().isEmpty()
								|| getSenha() != null && !getSenha().isEmpty()) {

							return new PasswordAuthentication(
									getEmail().trim(), getSenha().trim());
						} else {

							FacesMessageUtil
									.addMsgError("Email ou a Senha não poder ser vazia.\n Contate o administrador do Sistema");

							return null;
						}
					}
					
					

				});

		session.setDebug(true);

		try {
			Message msg = new MimeMessage(session);
			msg.setHeader("Content-Type", "text/plain; charset=UTF-8");

			if (getEmailRemetente() != null && !getEmailRemetente().isEmpty()) {

				Address from = new InternetAddress(getEmailRemetente().trim());
				msg.setFrom(from);

			} else {

				FacesMessageUtil
						.addMsgError("Email Rementente não pode Ser vazio\n Por Favor contate o Administrador do Sistema!");

				throw new EmailException(
						"Falha ao Enviar Email:\n Email Rementente não pode ser vazio!!");
			}

			if (getEmailDestinario() != null && !getEmailDestinario().isEmpty()) {

				Address[] destinatarios = InternetAddress
						.parse(getEmailDestinario().trim());

				msg.setRecipients(Message.RecipientType.TO, destinatarios);
			} else {

				FacesMessageUtil.addMsgError("Informe um Destinatario");

				throw new EmailException(
						"Falha ao Enviar Email:\n Destinatario não ficar sem preencher");
			}

			/**
			 * Se estiver marcado a opção para envio de email com copia Oculta
			 * Então pega a lista de email verifica se não esta nula e vazia
			 * 
			 */
			if (isCopiaOculta()) {

				if (getEmailCco() != null && !getEmailCco().isEmpty()) {

					Address[] cco = InternetAddress.parse(getEmailCco().trim());

					msg.setRecipients(Message.RecipientType.BCC, cco);

				} else {

					FacesMessageUtil
							.addMsgError("Favor Preencher os email para Cópia Oculta ou Desmarque a Opção");

					throw new EmailException(
							"Falha ao Enviar Email:\n Favor preencher os email que ira receber cópia Oculta");
				}
			}

			/**
			 * Se estiver marcado a opção para envio de email com copia Então
			 * pega a lista de email verifica se não esta nula e vazia
			 * 
			 */
			if (isEmailCopia()) {

				if (getEmailCc() != null && !getEmailCc().isEmpty()) {

					Address[] cc = InternetAddress.parse(getEmailCc().trim());

					msg.setRecipients(Message.RecipientType.CC, cc);

				} else {

					FacesMessageUtil
							.addMsgError("Favor Preencher os email para Cópia  ou Desmarque a Opção");

					throw new EmailException(
							"Falha ao Enviar Email:\n Favor preencher os email que ira receber cópia");
				}
			}

			if (getAssuntoEmail() != null && !getAssuntoEmail().isEmpty()) {

				msg.setSentDate(new Date());
				msg.setSubject(getAssuntoEmail().trim());
			} else {

				FacesMessageUtil
						.addMsgError("Assunto do Email deve Ser informado");

				throw new EmailException(
						"Falha ao Enviar Email:\n Assunto do Email deve Ser informado");

			}

			if (getMsgCorpo() != null && !getMsgCorpo().isEmpty()
					&& !getMsgCorpo().equals(" ")) {

				msg.setContent(getMsgCorpo().trim(), EMAIL_TEXTO);

			} else {

				FacesMessageUtil
						.addMsgError("Corpo do Email não pode Ser Vazio");

				throw new EmailException(
						"Falha ao Enviar Email:\n Corpo do Email não pode Ser Vazio");
			}

			// Chamada do método para enviar a Mensagem
			 Transport.send(msg);
			 
			FacesMessageUtil
					.addMsgInfo("Email Enviado com Sucesso!!!");

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final String getEmailRemetente() {
		return emailRemetente;
	}

	public final String getEmailDestinario() {
		return emailDestinario;
	}

	public final String getEmailCco() {
		return emailCco;
	}

	public final String getEmailCc() {
		return emailCc;
	}

	public final String getEmail() {
		return email;
	}

	public final String getSenha() {
		return senha;
	}

	public final String getServidorSmtp() {
		return servidorSmtp;
	}

	public final String getPorta() {
		return porta;
	}

	public final String getAssuntoEmail() {
		return assuntoEmail;
	}

	public final String getMsgCorpo() {
		return msgCorpo;
	}

	public final boolean isAutenticacaoSSL() {
		return autenticacaoSSL;
	}

	public final boolean isAutenticacaoTLS() {
		return autenticacaoTLS;
	}

	public final boolean isCopiaOculta() {
		return copiaOculta;
	}

	public final boolean isEmailCopia() {
		return emailCopia;
	}

	public void setEmailRemetente(String emailRemetente) {
		this.emailRemetente = emailRemetente;
	}

	public void setEmailDestinario(String emailDestinario) {
		this.emailDestinario = emailDestinario;
	}

	public void setEmailCco(String emailCco) {
		this.emailCco = emailCco;
	}

	public void setEmailCc(String emailCc) {
		this.emailCc = emailCc;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setServidorSmtp(String servidorSmtp) {
		this.servidorSmtp = servidorSmtp;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public void setAssuntoEmail(String assuntoEmail) {
		this.assuntoEmail = assuntoEmail;
	}

	public void setMsgCorpo(String msgCorpo) {
		this.msgCorpo = msgCorpo;
	}

	public void setAutenticacaoSSL(boolean autenticacaoSSL) {
		this.autenticacaoSSL = autenticacaoSSL;
	}

	public void setAutenticacaoTLS(boolean autenticacaoTLS) {
		this.autenticacaoTLS = autenticacaoTLS;
	}

	public void setCopiaOculta(boolean copiaOculta) {
		this.copiaOculta = copiaOculta;
	}

	public void setEmailCopia(boolean emailCopia) {
		this.emailCopia = emailCopia;
	}

}
