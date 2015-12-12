package br.com.swaggsige.model.service.exception;

import java.io.Serializable;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public enum MessageJsf implements Serializable{
	
	GRAVADO_COM_SUCESSO("Dados Gravados com Sucesso!!!"),
	DADOS_ATUALIZADO_COM_SUCESSO("Dados Atualizado com Sucesso!!!"),
	FALHA_AO_GRAVAR_DADOS("Falha ao gravar ou atualizar Dados"),
	
    DADOS_EXCLUIDO_COM_SUCESSO("FacesMessageUtil"),
    FALHA_AO_EXCLUIR_DADOS("Falha ao Excluir Dados!!!");

	private String nome;

	private MessageJsf(String nome) {
		this.nome = nome;
	}

	public final String toString() {
		return nome;
	}
	
	

}
