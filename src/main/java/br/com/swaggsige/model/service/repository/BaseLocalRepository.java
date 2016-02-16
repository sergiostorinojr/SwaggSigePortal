package br.com.swaggsige.model.service.repository;

import java.util.Collection;

import javax.ejb.Local;

import br.com.swaggsige.model.service.exception.PersistenceException;

@Local
public interface BaseLocalRepository<T> {
	
	public Collection<T> getAll() throws PersistenceException;
	
	public T getById(Long id) throws PersistenceException;
	
	public Collection<T> getAllByDescriptionStartsWith(String description) throws PersistenceException;
	
	public void save(T obj) throws PersistenceException;

	public T update(T obj) throws PersistenceException;

	public void toRemove(Long id) throws PersistenceException;

}
