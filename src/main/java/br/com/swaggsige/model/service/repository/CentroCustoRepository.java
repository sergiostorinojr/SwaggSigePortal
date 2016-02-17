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

import br.com.swaggsige.model.domain.CentroCusto;
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
@LocalBean
@Stateless(mappedName = "CentroCustoDAO")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CentroCustoRepository implements CentroCustoLocalRepository {

	@PersistenceContext(unitName = "PU")
	private EntityManager em;
	
	private static Log log = LogFactory.getLog(CentroCustoRepository.class);

	public CentroCustoRepository() {
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<CentroCusto> getAll() throws PersistenceException{
		try{
			Query createNamedQuery = em.createNamedQuery("centroCusto.getAll");
			
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public CentroCusto getById(Long id) {
		return em.find(CentroCusto.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<CentroCusto> getAllByDescriptionStartsWith(String description) throws PersistenceException{
		try {
			Query createNamedQuery = em.createNamedQuery("centroCusto.getAllByDescriptionStartsWith")
																			.setParameter("descricao", description);
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado para Este Banco " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado para Este Banco ", e);
				
		}
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(CentroCusto centroCusto) throws PersistenceException {
			try {
				
				em.persist(centroCusto);
			} catch (Exception e) {

				log.warn("Falha ao Gravar novo Cadastro "+ e.getMessage());
				throw new PersistenceException("Falha ao Gravar novo Cadastro ", e);

			}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public CentroCusto update(CentroCusto centroCusto) throws PersistenceException {
		try {
			centroCusto = em.merge(centroCusto);
	
			return centroCusto;
		} catch (Exception e) {

			log.warn("Falha ao Atualizar Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Atualizar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void toRemove(CentroCusto centroCusto) throws PersistenceException {
		try {
		CentroCusto cCusto = (CentroCusto) em.find(CentroCusto.class, centroCusto.getId());
		if (cCusto != null) {
			em.remove(cCusto);
		}
		} catch (Exception e) {

			log.warn("Falha ao Excluir Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Excluir Cadastro ", e);

		}

	}

}
