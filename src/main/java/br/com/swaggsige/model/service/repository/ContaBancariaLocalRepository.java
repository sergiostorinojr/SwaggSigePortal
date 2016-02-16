package br.com.swaggsige.model.service.repository;

import java.util.Collection;

import javax.ejb.Local;

import br.com.swaggsige.model.domain.ContaBancaria;
import br.com.swaggsige.model.service.exception.PersistenceException;

/**
 * 
 *  SwaggSigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *
 *
 */
@Local
public interface ContaBancariaLocalRepository {

	public Collection<ContaBancaria> getAll() throws PersistenceException;
	
	public Collection<ContaBancaria> getAllByDescriptionStartsWith(String description) throws PersistenceException;
	
	public Collection<ContaBancaria> getAllByCity(String cidade) throws PersistenceException;

	public ContaBancaria getByCC(Long contaCorrente) throws PersistenceException;

	public ContaBancaria getByAgency(Long agencia) throws PersistenceException;
	
	public ContaBancaria getById(Long id)throws PersistenceException;

	public Collection<ContaBancaria> getByRegistrationDate(String data1, String data2) throws PersistenceException;

	public void save(ContaBancaria contaBancaria) throws PersistenceException;

	public ContaBancaria update(ContaBancaria contaBancaria) throws PersistenceException;

	public void toRemove(ContaBancaria contaBancaria) throws PersistenceException;
}
