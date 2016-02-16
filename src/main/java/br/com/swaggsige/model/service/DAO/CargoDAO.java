package br.com.swaggsige.model.service.DAO;

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

import br.com.swaggsige.model.domain.Cargo;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.repository.BaseLocalRepository;

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
@Stateless(mappedName = "CargoDAO")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CargoDAO implements BaseLocalRepository<Cargo> {

	@PersistenceContext(unitName = "PU")
	private EntityManager em;
	
	private static Log log = LogFactory.getLog(CargoDAO.class);

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Cargo> getAll() throws PersistenceException {
		try{
			Query createNamedQuery = em.createNamedQuery("cargo.getAll");
			
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Cargo getById(Long id) {
		return em.find(Cargo.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cargo> getAllByDescriptionStartsWith(String description) throws PersistenceException {
		try {
			Query createNamedQuery = em.createNamedQuery("cargo.getAllByDescriptionStartsWith")
																.setParameter("descricao", description);
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado para Esta Descrição " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado para Esta Descrição ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Cargo cargo) throws PersistenceException {
		try {
			
			em.persist(cargo);
		} catch (Exception e) {

			log.warn("Falha ao Gravar novo Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Gravar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Cargo update(Cargo cargo) throws PersistenceException {
		try {
			Cargo c = em.merge(cargo);
	
			return c;
		} catch (Exception e) {

			log.warn("Falha ao Atualizar Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Atualizar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void toRemove(Long id) throws PersistenceException {
		try {
			Cargo c = (Cargo) em.find(Cargo.class, id);
			if (c != null) {
				em.remove(c);
			}
			} catch (Exception e) {

				log.warn("Falha ao Excluir Cadastro "+ e.getMessage());
				throw new PersistenceException("Falha ao Excluir Cadastro ", e);

			}
		
	}

}
