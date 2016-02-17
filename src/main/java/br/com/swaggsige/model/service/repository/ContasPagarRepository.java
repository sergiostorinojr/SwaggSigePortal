package br.com.swaggsige.model.service.repository;

import java.util.Collection;

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

import br.com.swaggsige.model.domain.ContasPagar;
import br.com.swaggsige.model.service.exception.PersistenceException;

/**
 * 
 * SwaggSigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br 
 * TransactionManagementType.CONTAINER
 *          Anotação informa que o tipo de persistencia é por conta do container
 *          TransactionAttributeType.REQUIRED : anotação verifica se existe uma
 *          transação em andamento se existe ele utiliza caso contrario cria uma
 *          nova;
 *
 * @param <T>
 *
 */
@Stateless(mappedName="ContasPagarDAO")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContasPagarRepository implements ContasPagarReceberLocalRepository<ContasPagar> {
	
	@PersistenceContext(unitName="PU")
	private EntityManager em;
	
	private static Log log = LogFactory.getLog(ContasPagar.class);

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContasPagar> getAll() throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasPagar.searchAll");
			
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContasPagar> getAllByRazaoSocialStartsWith(String razaoSocial) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasPagar.searchAllByRazaoSocialFornecedorStartsWith")
																.setParameter("razaoSocial", razaoSocial);
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContasPagar> getAllByPlanoContas(Long idPlanoContas) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasPagar.searchAllByPlanoContas")
															.setParameter("IDPlanoContas", idPlanoContas);
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContasPagar getByCNPJ(String cnpj) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasPagar.searchByCNPJFornecedor")
															.setParameter("cnpjFornecedor", cnpj);
			return (ContasPagar) createNamedQuery.getSingleResult();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContasPagar getByNumDoc(String numDoc) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasPagar.searchByNumDoc")
																.setParameter("numDocumento", numDoc);
			return (ContasPagar) createNamedQuery.getSingleResult();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContasPagar> getAllByRegistrationDate(String data1,String data2) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasPagar.searchAllByRegistrationDate")
																			.setParameter("data1", data1)
																			.setParameter("data2", data2);
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContasPagar> getByDateExtension(String data1, String data2) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasPagar.searchByDateExtension")
																	.setParameter("data1", data1)
																	.setParameter("data2", data2);
		return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContasPagar> getByDateIssue(String data1, String data2) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasPagar.searchByDateIssue")
																.setParameter("data1", data1)
																.setParameter("data2", data2);

			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContasPagar> getByDueDate(String data1, String data2) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasPagar.searchByDueDate")
															.setParameter("data1", data1)
															.setParameter("data2", data2);

			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContasPagar getById(Long id) throws PersistenceException{
		return em.find(ContasPagar.class, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(ContasPagar contasPagar) throws PersistenceException {
		try {
			
			em.persist(contasPagar);
		} catch (Exception e) {

			log.warn("Falha ao Gravar novo Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Gravar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContasPagar update(ContasPagar contasPagar) throws PersistenceException {
		try {
			ContasPagar contas = em.merge(contasPagar);
	
			return contas;
		} catch (Exception e) {

			log.warn("Falha ao Atualizar Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Atualizar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void toRemove(ContasPagar contasPagar) throws PersistenceException {
		try {
			ContasPagar contas = (ContasPagar) em.find(ContasPagar.class, contasPagar.getId());
			if (contas != null) {
				em.remove(contas);
			}
			} catch (Exception e) {

				log.warn("Falha ao Excluir Cadastro "+ e.getMessage());
				throw new PersistenceException("Falha ao Excluir Cadastro ", e);

			}
		
	}

}
