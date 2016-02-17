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

import br.com.swaggsige.model.domain.ContasReceber;
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
@Stateless(mappedName="ContasReceberDAO")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContasReceberRepository implements ContasPagarReceberLocalRepository<ContasReceber> {
	
	@PersistenceContext(unitName="PU")
	private EntityManager em;

	private static Log log = LogFactory.getLog(ContasReceber.class);

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContasReceber> getAll() throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasReceber.searchAll");
			
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContasReceber> getAllByRazaoSocialStartsWith(String razaoSocial) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasReceber.searchAllByRazaoSocialClienteStartsWith")
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
	public Collection<ContasReceber> getAllByPlanoContas(Long idPlanoContas) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasReceber.searchAllByPlanoContas")
															.setParameter("IDPlanoContas", idPlanoContas);
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContasReceber getByCNPJ(String cnpj) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasReceber.searchByCNPJCliente")
															.setParameter("cnpjCliente", cnpj);
			return (ContasReceber) createNamedQuery.getSingleResult();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContasReceber getByNumDoc(String numDoc) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasReceber.searchByNumDoc")
																.setParameter("numDocumento", numDoc);
			return (ContasReceber) createNamedQuery.getSingleResult();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContasReceber> getAllByRegistrationDate(String data1,String data2) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasReceber.searchAllByRegistrationDate")
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
	public Collection<ContasReceber> getByDateExtension(String data1, String data2) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasReceber.searchByDateExtension")
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
	public Collection<ContasReceber> getByDateIssue(String data1, String data2) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasReceber.searchByDateIssue")
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
	public Collection<ContasReceber> getByDueDate(String data1, String data2) throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contasReceber.searchByDueDate")
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
	public ContasReceber getById(Long id) throws PersistenceException{
		return em.find(ContasReceber.class, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(ContasReceber contasReceber) throws PersistenceException {
		try {
			
			em.persist(contasReceber);
		} catch (Exception e) {

			log.warn("Falha ao Gravar novo Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Gravar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContasReceber update(ContasReceber contasReceber) throws PersistenceException {
		try {
			ContasReceber contas = em.merge(contasReceber);
	
			return contas;
		} catch (Exception e) {

			log.warn("Falha ao Atualizar Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Atualizar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void toRemove(ContasReceber contasReceber) throws PersistenceException {
		try {
			ContasReceber contas = (ContasReceber) em.find(ContasReceber.class, contasReceber.getId());
			if (contas != null) {
				em.remove(contas);
			}
			} catch (Exception e) {

				log.warn("Falha ao Excluir Cadastro "+ e.getMessage());
				throw new PersistenceException("Falha ao Excluir Cadastro ", e);

			}
		
	}

}
