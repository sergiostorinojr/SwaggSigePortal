package br.com.swaggsige.model.service.jpa;

import java.util.Collection;

import javax.ejb.Remote;

import br.com.swaggsige.model.domain.AbstractEntity;
import br.com.swaggsige.model.service.exception.PersistenceException;

/**
 * 
 * SwaggSigePortal
 * @author S�rgio Junior - sergio.storinojr@gmail.com
 * 
 */
@Remote
public interface BaseRepositoryRemote<T> {
	
	public T saveOrUpdate(T obj) throws PersistenceException;

	public void toRemove(Long id) throws PersistenceException;

	public Collection<T> findAll();

	public T findById(Long id) ;


}
