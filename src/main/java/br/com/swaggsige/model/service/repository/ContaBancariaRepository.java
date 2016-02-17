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

import br.com.swaggsige.model.domain.ContaBancaria;
import br.com.swaggsige.model.service.exception.PersistenceException;

/**
 * 
 * SwaggSigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 *
 *          Camada Service Classe Responsável por Delegar seu comportamento para
 *          Camada DAO
 *
 */
@Stateless(mappedName = "ContaBancariaDAO")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContaBancariaRepository implements ContaBancariaLocalRepository {

	@PersistenceContext(unitName = "PU")
	private EntityManager em;

	private static Log log = LogFactory.getLog(ContaBancariaRepository.class);
	
	public ContaBancariaRepository() {
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContaBancaria> getAll() throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("contaBancaria.searchAll");
			
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContaBancaria getById(Long id) {
		return em.find(ContaBancaria.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContaBancaria> getAllByDescriptionStartsWith(String description) throws PersistenceException {
		try {
			Query createNamedQuery = em.createNamedQuery("contaBancaria.searchAllByDescriptionStartsWith")
																			.setParameter("descricao", description);
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado para Este Banco " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado para Este Banco ", e);
				
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContaBancaria> getAllByCity(String cidade) throws PersistenceException {
		try {
			Query createNamedQuery = em.createNamedQuery("contaBancaria.searchAllByCity")
																			.setParameter("cidade", cidade);
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado Encontrado " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado Encontrado ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContaBancaria getByCC(Long contaCorrente) throws PersistenceException {
		try {
			Query createNamedQuery = em.createNamedQuery("contaBancaria.searchByCC")
													.setParameter("contaCorrente", contaCorrente);

			return (ContaBancaria) createNamedQuery.getSingleResult();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado Encontrado " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado Encontrado ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContaBancaria getByAgency(Long agencia) throws PersistenceException {
		try {
			Query createNamedQuery = em.createNamedQuery("contaBancaria.searchByAgency")
					.setParameter("agencia", agencia);
	
			return (ContaBancaria) createNamedQuery.getSingleResult();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado Encontrado " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado Encontrado ", e);
			
		}
			
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ContaBancaria> getByRegistrationDate(String data1, String data2) throws PersistenceException {
		try {
			Query createNamedQuery = em.createNamedQuery("contaBancaria.searchByRegistrationDate")
																		.setParameter("data1", data1)
																		.setParameter("data2", data2);
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado Encontrado " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado Encontrado ", e);
			
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(ContaBancaria contaBancaria) throws PersistenceException {
			try {
				
				em.persist(contaBancaria);
			} catch (Exception e) {

				log.warn("Falha ao Gravar novo Cadastro "+ e.getMessage());
				throw new PersistenceException("Falha ao Gravar novo Cadastro ", e);

			}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContaBancaria update(ContaBancaria contaBancaria) throws PersistenceException {
		try {
			contaBancaria = em.merge(contaBancaria);
	
			return contaBancaria;
		} catch (Exception e) {

			log.warn("Falha ao Atualizar Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Atualizar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void toRemove(ContaBancaria contaBancaria) throws PersistenceException {
		try {
			ContaBancaria conta = (ContaBancaria) em.find(ContaBancaria.class, contaBancaria.getId());
			if (conta != null) {
				em.remove(conta);
			}
			} catch (Exception e) {

				log.warn("Falha ao Excluir Cadastro "+ e.getMessage());
				throw new PersistenceException("Falha ao Excluir Cadastro ", e);

			}
	}

}
