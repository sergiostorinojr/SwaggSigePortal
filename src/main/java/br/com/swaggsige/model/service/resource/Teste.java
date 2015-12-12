package br.com.swaggsige.model.service.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.domain.EnderecoCliente;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class Teste {
	
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
		
       /* Usuario usuario = new Usuario();
        usuario.setLogin("Sergio Junio");
        usuario.setSenha("sasa");
        usuario.setPermissao(PermissaoAcesso.ADMINISTRADOR);
        
        Usuario us = em.find(Usuario.class, 1L);
        		
        		Cliente cliente = new Cliente();
        		cliente.setNome("Sergio Junior");
        		cliente.setUsuario(us);
        		cliente.setTipo(TipoPessoa.FISICA);
        		cliente.setCnpj("22121212");
        		cliente.setCpf("009888");
        		cliente.setSituacao(Situacao.ATIVO);
        		
        		//cliente.setEnderecoCliente(listaEnd);
        		
        		List<EnderecoCliente> endli = new ArrayList<EnderecoCliente>();
        		
        		EnderecoCliente endCliente = new EnderecoCliente();
        		endCliente.setBairro("Planalto");
        		endCliente.setCep("13485084");
        		endCliente.setCidade("Limeira-SP");
        		endCliente.setComplemento("Casa");
        		endCliente.setCliente(cliente);
        		
        		endli.add(endCliente);
        		
        		cliente.setEnderecoCliente(endli);*/
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> cquery = cb.createQuery(Cliente.class);
		Root<Cliente> fromCliente = cquery.from(Cliente.class);
		Root<EnderecoCliente> fromEndereco = cquery.from(EnderecoCliente.class);
		Join<Cliente, EnderecoCliente> theJoin = fromCliente.join("enderecoCliente");
		cquery = cquery.select(fromCliente).where(cb.equal(fromCliente.get("id"), 1L));
		
		//Cliente cliente = 
			//	Cliente singleResult = em.createQuery(cquery).getSingleResult();
	
			List<Cliente> resultList = em.createQuery(cquery).getResultList();
		
		//System.out.println("Nome: "+cliente.getNome());
		
		for (Cliente cliente : resultList) {
			System.out.println("Nome: "+ cliente.getNome());
			
			
			System.out.println("Logradouro: "+ cliente.getEnderecoCliente());
		}
		
		/*em.getTransaction().begin();
		//em.merge(usuario);
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();*/
		
		
		
	}

}
