package br.com.swaggsige.controller.service;

import java.util.Collection;

import javax.ejb.Local;

import br.com.swaggsige.model.domain.Marca;

@Local
public interface MarcaLocalService {
	
	public Collection<Marca> getAll();
	
	public Marca getById(Long id);
	
	public Collection<Marca> getAllByDescriptionStartsWith(String description);
	
	public void save(Marca obj);

	public Marca update(Marca obj);

	public void toRemove(Long id);

}
