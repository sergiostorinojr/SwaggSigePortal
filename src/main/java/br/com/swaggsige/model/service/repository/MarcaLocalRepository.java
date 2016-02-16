package br.com.swaggsige.model.service.repository;

import java.util.Collection;

import javax.ejb.Local;

import br.com.swaggsige.model.domain.Marca;
import br.com.swaggsige.model.service.exception.PersistenceException;

@Local
public interface MarcaLocalRepository {
	
	public Collection<Marca> getAll() throws PersistenceException;
	
	public Marca getById(Long id) throws PersistenceException;
	
	public Collection<Marca> getAllByDescriptionStartsWith(String description) throws PersistenceException;
	
	public void save(Marca obj) throws PersistenceException;

	public Marca update(Marca obj) throws PersistenceException;

	public void toRemove(Long id) throws PersistenceException;

}
