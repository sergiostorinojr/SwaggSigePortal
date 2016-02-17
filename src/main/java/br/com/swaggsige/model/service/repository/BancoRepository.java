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

import br.com.swaggsige.model.domain.Banco;
import br.com.swaggsige.model.service.exception.PersistenceException;

/**
 * SwaggSigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 *
 *
 */
@Stateless(mappedName = "BancoDAO")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BancoRepository implements BaseLocalRepository<Banco> {

	@PersistenceContext(unitName = "PU")
	private EntityManager em;
	
	private static Log log = LogFactory.getLog(BancoRepository.class);

	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Banco> getAll() throws PersistenceException{
		try{
			Query createNamedQuery = em.createNamedQuery("banco.getAll");
			
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado  " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado  ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Banco getById(Long id) throws PersistenceException{
		return em.find(Banco.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Banco> getAllByDescriptionStartsWith(String nomeBanco) throws PersistenceException {
		try {
			Query createNamedQuery = em.createNamedQuery("banco.getAllByNameBankStartsWith")
																			.setParameter("nomeBanco", nomeBanco);
			return createNamedQuery.getResultList();
		}catch(NoResultException e){
			
			log.warn("Nennhum Resultado foi encontrado para Este Banco " + e.getMessage());
			throw new PersistenceException("Nennhum Resultado foi encontrado para Este Banco ", e);
				
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Banco banco) throws PersistenceException {
		try {
			
			em.persist(banco);
		} catch (Exception e) {

			log.warn("Falha ao Gravar novo Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Gravar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Banco update(Banco banco) throws PersistenceException {
		try {
			Banco b = em.merge(banco);
	
			return b;
		} catch (Exception e) {

			log.warn("Falha ao Atualizar Cadastro "+ e.getMessage());
			throw new PersistenceException("Falha ao Atualizar novo Cadastro ", e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void toRemove(Long id) throws PersistenceException {
		try {
			Banco b = (Banco) em.find(Banco.class, id);
			if (b != null) {
				em.remove(b);
			}
			} catch (Exception e) {

				log.warn("Falha ao Excluir Cadastro "+ e.getMessage());
				throw new PersistenceException("Falha ao Excluir Cadastro ", e);

			}
		
	}

}
