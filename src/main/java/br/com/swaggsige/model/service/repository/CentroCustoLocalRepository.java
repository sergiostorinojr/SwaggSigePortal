package br.com.swaggsige.model.service.repository;

import java.util.Collection;

import javax.ejb.Local;

import br.com.swaggsige.model.domain.CentroCusto;
import br.com.swaggsige.model.service.exception.PersistenceException;

/**
 * 
 * SwaggSigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 *
 *
 */
@Local
public interface CentroCustoLocalRepository {
	
	public void save(CentroCusto centroCusto) throws PersistenceException;

	public CentroCusto update(CentroCusto centroCusto) throws PersistenceException;

	public void toRemove(CentroCusto centroCusto) throws PersistenceException;
	
	public Collection<CentroCusto> getAll() throws PersistenceException;
	
	public CentroCusto getById(Long id) throws PersistenceException;
	
	public Collection<CentroCusto> getAllByDescriptionStartsWith(String description) throws PersistenceException;

}
