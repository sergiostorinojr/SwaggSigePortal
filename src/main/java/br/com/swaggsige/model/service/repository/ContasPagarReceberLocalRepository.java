package br.com.swaggsige.model.service.repository;

import java.util.Collection;

import javax.ejb.Local;

import br.com.swaggsige.model.service.exception.PersistenceException;

/**
 * 
 *  SwaggSigePortal
 *	@Author: Sérgio D. Storino Junior
 *  @Email: sergio.storinojr@gmail.com
 *  @WebSite: www.sergiostorino.com.br
 *  @Github: github@sergiostorino.com.br
 *
 *  @param <T>
 *
 */
@Local
public interface ContasPagarReceberLocalRepository<T> {

	public Collection<T> getAll() throws PersistenceException;

	public Collection<T> getAllByRazaoSocialStartsWith(String razaoSocial) throws PersistenceException;

	public Collection<T> getAllByPlanoContas(Long idPlanoContas) throws PersistenceException;

	public T getByCNPJ(String cnpj) throws PersistenceException;

	public T getById(Long id)throws PersistenceException;

	public T getByNumDoc(String numDoc) throws PersistenceException;

	public Collection<T> getAllByRegistrationDate(String data1, String data2) throws PersistenceException;

	public Collection<T> getByDateExtension(String data1, String data2) throws PersistenceException;

	public Collection<T> getByDateIssue(String data1, String data2) throws PersistenceException;

	public Collection<T> getByDueDate(String data1, String data2) throws PersistenceException;

	public void save(T obj) throws PersistenceException;

	public T update(T obj) throws PersistenceException;

	public void toRemove(T obj) throws PersistenceException;

}
