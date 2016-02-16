package br.com.swaggsige.controller.service;

import java.util.Collection;

import javax.ejb.Local;

@Local
public interface BaseLocalService<T> {
	
	public Collection<T> getAll();
	
	public T getById(Long id);
	
	public Collection<T> getAllByDescriptionStartsWith(String description);
	
	public void save(T obj);

	public T update(T obj);

	public void toRemove(Long id);

}
