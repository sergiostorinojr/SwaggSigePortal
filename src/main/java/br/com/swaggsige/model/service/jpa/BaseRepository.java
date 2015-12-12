package br.com.swaggsige.model.service.jpa;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.swaggsige.model.domain.AbstractEntity;
import br.com.swaggsige.model.domain.Marca;
import br.com.swaggsige.model.service.exception.MessageJsf;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@Stateless
public class BaseRepository<T extends AbstractEntity> implements
		BaseRepositoryLocal<T>, BaseRepositoryRemote<T> {

	@Inject
	private EntityManager em;

	private Class<?> clazz;

	public BaseRepository(Class<?> clazz) {
		super();
		this.clazz = clazz;

	}

	public BaseRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public T saveOrUpdate(T obj) throws PersistenceException {

		em = Resource.getEntityManager();
		if (obj != null) {

			try {
				if (obj.getId() != null) {

					obj = em.merge(obj);

					new FacesMessageUtil();
					FacesMessageUtil
							.addMsgInfo(MessageJsf.DADOS_ATUALIZADO_COM_SUCESSO
									.toString());

				} else {
					em.persist(obj);

					new FacesMessageUtil();
					FacesMessageUtil.addMsgInfo(MessageJsf.GRAVADO_COM_SUCESSO
							.toString());

				}
			} catch (Exception e) {

				throw new PersistenceException("Falha ao gravar ou atualizar Objeto",
						e);

			} finally {
				if(em != null && em.isOpen()){
				em.close();
				}
			}
		}
		return obj;
	}

	@Override
	public void toRemove(Long id) throws PersistenceException {
		if (id != null) {

			try {
				em.remove(id);

				new FacesMessageUtil();
				FacesMessageUtil
						.addMsgInfo(MessageJsf.DADOS_EXCLUIDO_COM_SUCESSO
								.toString());

			} catch (Exception e) {

				new FacesMessageUtil();
				FacesMessageUtil
						.addMsgFatalError(MessageJsf.FALHA_AO_EXCLUIR_DADOS
								.toString());

				throw new PersistenceException("Falha ao Excluir Objeto", e);

			}
		}
	}

	@Override
	public Collection<T> findAll() {
		TypedQuery<?> createQuery = em.createQuery("", clazz);

		return (Collection<T>) createQuery.getResultList();
	}

	@Override
	public T findById(Long id) {
		return  (T) em.find(clazz , id);
	}
	
	public Marca findByIde(Long id) {
		 return em.find(Marca.class, id);
		 
		 
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public final Class<?> getClazz() {
		return clazz;
	}

}
