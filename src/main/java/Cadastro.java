import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.domain.EnderecoCliente;
import br.com.swaggsige.model.domain.PermissaoAcesso;
import br.com.swaggsige.model.domain.Situacao;
import br.com.swaggsige.model.domain.TipoPessoa;
import br.com.swaggsige.model.domain.UF;
import br.com.swaggsige.model.domain.Usuario;
import br.com.swaggsige.model.service.converter.ConverterDateTime;

public class Cadastro {

	public static void main(String[] args) {

		for(int i =0; i < 100; i++){
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		List<EnderecoCliente> listaEnd = new ArrayList<EnderecoCliente>();

		Usuario usuario = new Usuario();
		usuario.setLogin("nepsterr" + i);
		usuario.setSenha("136");
		//usuario.setPermissao(PermissaoAcesso.CLIENTE);

		Cliente cliente = new Cliente();
		cliente.setNome("Sérgio Juniorh" + i);
		cliente.setCpf("40013989" + i);
		cliente.setCelular("983057416");
		cliente.setTelefone("34451376");
		cliente.setTipo(TipoPessoa.FISICA);
		cliente.setEmail("storinojr@gmail");
		cliente.setCnpj("21214512" + i);
		cliente.setInscEstadual("1455211118" + i);
		cliente.setRazaoSocial("tabarara ja");
		cliente.setRg("4566698" + i);
		cliente.setSituacao(Situacao.ATIVO);
		cliente.setDataCadastro(ConverterDateTime.getConverterStringDate("11/02/2016"));
		cliente.setDataNascimento(ConverterDateTime.getConverterStringDate("03/04/1991"));
		cliente.setUsuario(usuario);


		EnderecoCliente endCliente = new EnderecoCliente();
		endCliente.setBairro("Piraaba");
		endCliente.setCep("13235568");
		endCliente.setCidade("SAO Paulo-SP");
		endCliente.setComplemento("Casa");
		endCliente.setUf(UF.SP);
		endCliente.setLogradouro("Palmiro");
		endCliente.setNumero(Long.parseLong("57"));
		endCliente.setPais("Brasil");
		endCliente.setCliente(cliente);
		listaEnd.add(endCliente);
		cliente.getEnderecoCliente().add(endCliente);

		//em.persist(usuario);
		em.persist(cliente);
		//em.persist(endCliente);
		em.getTransaction().commit();
		em.close();
}

	}
}
