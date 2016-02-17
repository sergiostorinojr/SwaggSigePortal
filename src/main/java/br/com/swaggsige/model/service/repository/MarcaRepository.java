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

import br.com.swaggsige.model.domain.Marca;
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
@Stateless(mappedName="MarcaDAO")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MarcaRepository implements MarcaLocalRepository {

	@PersistenceContext(unitName = "PU")
	private EntityManager em;
	
	private static Log log = LogFactory.getLog(MarcaRepository.class);

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Marca> getAll() throws PersistenceException {
		try {
			Query createNamedQuery = em.createNamedQuery("marca.getAll");
			
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Marca getById(Long id) {
		return em.find(Marca.class, id);
				
	}

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Marca> getAllByDescriptionStartsWith(String description) throws PersistenceException {
		try {
			Query createNamedQuery = em.createNamedQuery("marca.getAllByDescriptionStartsWith")
																	.setParameter("descricao", description);
			
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado para Esta Descrição " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado para Esta Descrição ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Marca marca) throws PersistenceException {
		try {
			
			em.persist(marca);
		} catch (Exception e) {

			log.warn("Falha ao Gravar novo Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Gravar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Marca update(Marca marca) throws PersistenceException {
		try {
			Marca m = em.merge(marca);
	
			return m;
		} catch (Exception e) {

			log.warn("Falha ao Atualizar Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Atualizar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void toRemove(Long id) throws PersistenceException {
		try {
			Marca m = (Marca) em.find(Marca.class, id);
			if (m != null) {
				em.remove(m);
			}
			} catch (Exception e) {

				log.warn("Falha ao Excluir Cadastro "+ e.getMessage());
				throw new PersistenceException("Falha ao Excluir Cadastro ", e);

			}
		
	}
	
}
