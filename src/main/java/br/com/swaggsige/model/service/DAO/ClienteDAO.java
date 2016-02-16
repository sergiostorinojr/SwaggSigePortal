package br.com.swaggsige.model.service.DAO;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.domain.TipoPessoa;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.repository.ClienteLocalRepository;
import br.com.swaggsige.model.service.repository.PessoaLocalRepository;

/**
 * 
 *  SwaggSigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *
 *	Camada DAO Responsável por realizar a Persistencia ao Banco de Dados
 *
 */
@Stateless(mappedName="ClienteDAO")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClienteDAO implements ClienteLocalRepository {

	@PersistenceContext(unitName="PU")
	private EntityManager em;

	private static Log log = LogFactory.getLog(ClienteDAO.class);

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Cliente> getAll() throws PersistenceException {
		try{
			Query createNamedQuery =  em.createNamedQuery("cliente.searchAll");
	
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Cliente getBydId(Long id) throws PersistenceException {
		try {
			
		Query setParameter = em.createNamedQuery("cliente.searchById")
														.setParameter("id", id)
														.setMaxResults(1);

			return (Cliente) setParameter.getSingleResult();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado com essa ID " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado com essa ID ", e);
				
		  }
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Cliente getByCpf(String cpf) throws PersistenceException {
			try {
				Query setParameter = em.createNamedQuery("cliente.searchByCPF")
														.setParameter("cpf", cpf)
														.setMaxResults(1);
				
				return (Cliente) setParameter.getSingleResult();
			}catch(NoResultException e){
				
				log.warn("Nennhum Resultado foi encontrado para Este CPF " + e.getMessage());
				throw new PersistenceException("Nennhum Resultado foi encontrado para Este CPF ", e);
					
			}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Cliente getByCnpj(String cnpj) throws PersistenceException {
			try {
				Query setParameter = em.createNamedQuery("cliente.searchByCNPJ")
															.setParameter("cnpj", cnpj)
															.setMaxResults(1);
		
				return (Cliente) setParameter.getSingleResult();
			}catch(NoResultException e){
				
				log.warn("Nennhum Resultado foi encontrado para Este CNPJ " + e.getMessage());
				throw new PersistenceException("Nennhum Resultado foi encontrado para Este CNPJ ", e);
					
			}
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Cliente getByIe(String ie) throws PersistenceException {
			try{
				Query setParameter = em.createNamedQuery("cliente.searchByInscEstadual")
																		.setParameter("ie", ie)
																		.setMaxResults(1);
		
				return (Cliente) setParameter.getSingleResult();
			}catch(NoResultException e){
				
				log.warn("Nennhum Resultado foi encontrado para Esta Insc. Estadual " + e.getMessage());
				throw new PersistenceException("Nennhum Resultado foi encontrado para Esta Insc. Estadual ", e);
					
			}
	}

	/**
	 * Método se encontra depreciado Cliente não possui Inscrição Municipal
	 */
	@Deprecated
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Cliente getByIm(String im) {
		// TODO Cliente não Possui INSC. MUNICIPAL
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cliente> getByName(String name) throws PersistenceException {
			try{
				Query setParameter = em.createNamedQuery("cliente.searchAllByNameStartsWith")
																.setParameter("nome", name);
		
				return setParameter.getResultList();
			}catch(NoResultException e){
				
				log.warn("Nennhum Resultado foi encontrado para Este nome " + e.getMessage());
				throw new PersistenceException("Nennhum Resultado foi encontrado para Este nome ", e);
					
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Cliente> getByBirthdayDate(Date birthdayDateOne, Date birthdayDateTwo) throws PersistenceException {
			try{
				Query setParameter = em.createNamedQuery("cliente.searchByBirthdayDate")
																.setParameter("data1", birthdayDateOne)
																.setParameter("data2", birthdayDateTwo);
		
				return setParameter.getResultList();
			}catch(NoResultException e){
				
				log.warn("Nennhum Resultado foi encontrado Entre as Datas informada  " + e.getMessage());
				throw new PersistenceException("Nennhum Resultado foi encontrado Entre as Datas informada ", e);
					
				}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Cliente> getByRegistrationDate(Date registrationDateOne, Date registrationDateTwo) throws PersistenceException {
			try{
				Query setParameter = em.createNamedQuery("cliente.searchByRegistrationDate")
																.setParameter("data1", registrationDateOne)
																.setParameter("data2", registrationDateTwo);
		
				return setParameter.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado Entre as Datas informada  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado Entre as Datas informada ", e);
				
		}
	}

	/**
	 * Não há query programada para Busca por tipo de pessoa
	 */
	@Deprecated
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Cliente> getByTypePerson(TipoPessoa typePerson) {
		//TODO Não há query programada para Busca por tipo de pessoa
		return null;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Cliente cliente) throws PersistenceException {
			try {
				
				em.persist(cliente);
			} catch (Exception e) {

				log.warn("Falha ao Gravar novo Cadastro "+ e.getMessage());
				throw new PersistenceException("Falha ao Gravar novo Cadastro ", e);

			}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Cliente update(Cliente cliente) throws PersistenceException {
		try {
			cliente = em.merge(cliente);
	
			return cliente;
		} catch (Exception e) {

			log.warn("Falha ao Atualizar Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Atualizar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void toRemove(Long id) throws PersistenceException {
		try {
		Cliente cliente = (Cliente) em.find(Cliente.class, id);
		if (cliente != null) {
			em.remove(cliente);
		}
		} catch (Exception e) {

			log.warn("Falha ao Excluir Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Excluir Cadastro ", e);

		}
	}
}
