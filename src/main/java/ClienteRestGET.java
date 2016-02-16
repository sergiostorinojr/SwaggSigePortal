import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

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
 *	classe de teste
 *
 */
public class ClienteRestGET {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		try {
			URL url = new URL("http://localhost:8080/SwaggSigePortal/rest/cliente/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoInput(true);
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");

			if(con.getResponseCode() == 200){
			
			InputStream in = con.getInputStream();
			
			BufferedReader buf = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String readLine = null;

			while((readLine = buf.readLine()) != null){
				sb.append(readLine);
				System.err.println(readLine);
				System.err.println(sb.length());
				
			}
			List<Cliente> setJson = setJson(sb.toString());
			
			for (Cliente cliente : setJson) {
				System.out.println(cliente.getNome());
				System.out.println(cliente.getDataNascimento());
				System.err.println(cliente.getDataCadastro());
				System.out.println(cliente.getUsuario().getLogin());
				List<EnderecoCliente> enderecoCliente = cliente.getEnderecoCliente();
				for (EnderecoCliente endereco : enderecoCliente) {
					
					System.out.println(endereco.getLogradouro());
				}
			}
			
			con.disconnect();
			in.close();
			buf.close();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<Cliente> setJson(String json){
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<EnderecoCliente> endereco = new ArrayList<EnderecoCliente>();
		
		
		JSONArray array = new JSONArray(json);
		
		Cliente cliente = null;
		Usuario usuario = null;
		EnderecoCliente enderecoCliente = null;
		
		
		for(int i=0; i < array.length(); i++){
			cliente = new Cliente();
			cliente.setId(Long.parseLong(array.getJSONObject(i).get("cliente_id").toString()));
			cliente.setNome(String.valueOf(array.getJSONObject(i).get("nome").toString()));
			cliente.setSituacao(Enum.valueOf(Situacao.class, array.getJSONObject(i).get("situacao").toString()));
			cliente.setTipo(Enum.valueOf(TipoPessoa.class, array.getJSONObject(i).get("tipoPessoa").toString()));
			cliente.setTelefone(String.valueOf(array.getJSONObject(i).get("telefone").toString()));
			cliente.setCelular(String.valueOf(array.getJSONObject(i).get("celular").toString()));
			cliente.setEmail(String.valueOf(array.getJSONObject(i).get("email").toString()));
			
			cliente.setDataNascimento(ConverterDateTime
													.getConverterStringDate(ConverterDateTime
													.getConverterDateString(ConverterDateTime
													.getConverterStringDateBanco(
																		String.valueOf(array.getJSONObject(i).get("dataNascimento").toString())))));
			cliente.setRazaoSocial(String.valueOf(array.getJSONObject(i).get("razaoSocial").toString()));
			cliente.setCpf(String.valueOf(array.getJSONObject(i).get("cpf").toString()));
			cliente.setCnpj(String.valueOf(array.getJSONObject(i).get("cnpj").toString()));
			cliente.setInscEstadual(String.valueOf(array.getJSONObject(i).get("inscEstadual").toString()));
			cliente.setRg(String.valueOf(array.getJSONObject(i).get("rg").toString()));
			
			cliente.setDataCadastro(ConverterDateTime
												.getConverterStringDate(ConverterDateTime
												.getConverterDateString(ConverterDateTime
												.getConverterStringDateBanco(
																		String.valueOf(array.getJSONObject(i).get("dataCadastro").toString())))));
			
			
			//Parse json Object Usuario
			usuario = new Usuario();
			usuario.setId(Long.parseLong(array.getJSONObject(i).get("usuario_id").toString()));
			usuario.setLogin(String.valueOf(array.getJSONObject(i).getString("login").toString()));
			usuario.setSenha(String.valueOf(array.getJSONObject(i).getString("senha").toString()));
			usuario.setPermissao(Enum.valueOf(PermissaoAcesso.class,array.getJSONObject(i).getString("permissaoAcesso").toString()));
			cliente.setUsuario(usuario);
			
			//Parse Json Object EnderecoCliente
			enderecoCliente = new EnderecoCliente();
			enderecoCliente.setId(Long.parseLong(array.getJSONObject(i).get("endereco_id").toString()));
			enderecoCliente.setLogradouro(String.valueOf(array.getJSONObject(i).getString("logradouro").toString()));
			enderecoCliente.setBairro(String.valueOf(array.getJSONObject(i).getString("bairro").toString()));
			enderecoCliente.setCidade(String.valueOf(array.getJSONObject(i).getString("cidade").toString()));
			enderecoCliente.setCep(String.valueOf(array.getJSONObject(i).getString("cep").toString()));
			enderecoCliente.setUf(Enum.valueOf(UF.class, array.getJSONObject(i).getString("uf").toString()));
			enderecoCliente.setPais(String.valueOf(array.getJSONObject(i).getString("pais").toString()));
			
			endereco.add(enderecoCliente);
			cliente.setEnderecoCliente(endereco);
			clientes.add(cliente);
		}
		
		
		return clientes;
	}

}
