package br.com.swaggsige.ulti.jpa.Interface;

import java.util.Collection;

import javax.ejb.Local;

import br.com.swaggsige.model.domain.Marca;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@Local
public interface MarcaRepositoryLocal {
	
	public Collection<Marca> getAll();
	public Marca getById(Long id);
	public Collection<Marca> getAllBydescriptionStartsWith(String description);

}
