package br.com.swaggsige.model.service.json.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.domain.EnderecoCliente;
import br.com.swaggsige.model.domain.PermissaoAcesso;
import br.com.swaggsige.model.domain.Situacao;
import br.com.swaggsige.model.domain.TipoPessoa;
import br.com.swaggsige.model.domain.UF;
import br.com.swaggsige.model.domain.Usuario;
import br.com.swaggsige.model.service.converter.ConverterDateTime;

/**
 * 
 *  SwaggSigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *  @2016
 *  @08:54:00
 *
 *
 */
public class BindParserJsonCliente implements BindParserJsonLocal<Cliente>, BindParserJsonRemote<Cliente>{

	@Override
	public String getBindListJson(List<Cliente> listaClientes) {
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();

		if (!listaClientes.isEmpty()) {

			for (Cliente cliente : listaClientes) {
				jsonObject = new JSONObject();
				jsonObject.put("cliente_id", cliente.getId());
				jsonObject.put("nome", cliente.getNome());

				if (cliente.getSituacao() == null) {
					jsonObject.put("situacao", Situacao.INATIVO);
					
				} else {

					jsonObject.put("situacao", cliente.getSituacao());
				}

				if (cliente.getTipo() == null) {
					jsonObject.put("tipoPessoa", TipoPessoa.FISICA);
					
				} else {

					jsonObject.put("tipoPessoa", cliente.getTipo());
				}
				
				jsonObject.put("telefone", cliente.getTelefone());
				jsonObject.put("celular", cliente.getCelular());
				jsonObject.put("email", cliente.getEmail());
				jsonObject.put("dataNascimento", cliente.getDataNascimento());
				jsonObject.put("razaoSocial", cliente.getRazaoSocial());
				jsonObject.put("cpf", cliente.getCpf());
				jsonObject.put("cnpj", cliente.getCnpj());
				jsonObject.put("inscEstadual", cliente.getInscEstadual());
				jsonObject.put("rg", cliente.getRg());
				jsonObject.put("dataCadastro", cliente.getDataCadastro());

				List<EnderecoCliente> enderecoCliente = cliente
						.getEnderecoCliente();

				for (EnderecoCliente endereco : enderecoCliente) {
					jsonObject.put("endereco_id", endereco.getId());
					jsonObject.put("logradouro", endereco.getLogradouro());
					jsonObject.put("numero", endereco.getNumero());
					jsonObject.put("complemento", endereco.getComplemento());
					jsonObject.put("bairro", endereco.getBairro());
					jsonObject.put("cidade", endereco.getCidade());
					jsonObject.put("cep", endereco.getCep());

					if (endereco.getUf() == null) {
						jsonObject.put("uf", UF.SP);
					} else {

						jsonObject.put("uf", endereco.getUf());
					}
					jsonObject.put("pais", endereco.getPais());

				}
				jsonObject.put("usuario_id", cliente.getUsuario().getId());
				jsonObject.put("login", cliente.getUsuario().getLogin());
				jsonObject.put("senha", cliente.getUsuario().getSenha());
				if (cliente.getUsuario().getPermissao() == null) {
					jsonObject
							.put("permissaoAcesso",
									PermissaoAcesso.CLIENTE);

				} else {
					jsonObject.put("permissaoAcesso", cliente.getUsuario()
							.getPermissao());
				}

				jsonArray.put(jsonObject);
			}
		}
		return jsonArray.toString();
	}
	
	@Override
	public String getBindObjectJson(Cliente cliente) {
		JSONArray jsonArray = new JSONArray();

		if (cliente != null) {

			JSONObject 	jsonObject = new JSONObject();
				jsonObject.put("cliente_id", cliente.getId());
				jsonObject.put("nome", cliente.getNome());
				
				if (cliente.getSituacao() == null) {
					jsonObject.put("situacao", Situacao.INATIVO);
					
				} else {

					jsonObject.put("situacao", cliente.getSituacao());
				}
				
				if (cliente.getTipo() == null) {
					jsonObject.put("tipoPessoa", TipoPessoa.FISICA);
					
				} else {

					jsonObject.put("tipoPessoa", cliente.getTipo());
				}
				
				jsonObject.put("telefone", cliente.getTelefone());
				jsonObject.put("celular", cliente.getCelular());
				jsonObject.put("email", cliente.getEmail());
				jsonObject.put("dataNascimento", cliente.getDataNascimento());
				jsonObject.put("razaoSocial", cliente.getRazaoSocial());
				jsonObject.put("cpf", cliente.getCpf());
				jsonObject.put("cnpj", cliente.getCnpj());
				jsonObject.put("inscEstadual", cliente.getInscEstadual());
				jsonObject.put("rg", cliente.getRg());
				jsonObject.put("dataCadastro", cliente.getDataCadastro());

				List<EnderecoCliente> enderecoCliente = cliente
						.getEnderecoCliente();

				for (EnderecoCliente endereco : enderecoCliente) {
					jsonObject.put("endereco_id", endereco.getId());
					jsonObject.put("logradouro", endereco.getLogradouro());
					jsonObject.put("numero", endereco.getNumero());
					jsonObject.put("complemento", endereco.getComplemento());
					jsonObject.put("bairro", endereco.getBairro());
					jsonObject.put("cidade", endereco.getCidade());
					jsonObject.put("cep", endereco.getCep());

					if (endereco.getUf() == null) {
						jsonObject.put("uf", UF.SP);
					} else {

						jsonObject.put("uf", endereco.getUf());
					}
					jsonObject.put("pais", endereco.getPais());

				}
				jsonObject.put("usuario_id", cliente.getUsuario().getId());
				jsonObject.put("login", cliente.getUsuario().getLogin());
				jsonObject.put("senha", cliente.getUsuario().getSenha());
				if (cliente.getUsuario().getPermissao() == null) {
					
					jsonObject.put("permissaoAcesso",PermissaoAcesso.CLIENTE);

				} else {
					jsonObject.put("permissaoAcesso", cliente.getUsuario()
																		.getPermissao());
				}

				jsonArray.put(jsonObject);
			}
		
		return jsonArray.toString();
	}
	
	
}
