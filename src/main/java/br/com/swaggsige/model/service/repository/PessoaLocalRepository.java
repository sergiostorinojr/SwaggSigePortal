package br.com.swaggsige.model.service.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import br.com.swaggsige.model.domain.TipoPessoa;
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
public interface PessoaLocalRepository<T> {
	
	public List<T> getAll() throws PersistenceException;
	
	public T getBydId(Long id) throws PersistenceException;
	
	public T getByCpf(String cpf) throws PersistenceException;
	
	public T getByCnpj(String cnpj) throws PersistenceException;
	
	public T getByIe(String ie) throws PersistenceException;
	
	public T getByIm(String im) throws PersistenceException;
	
	public Collection<T> getByName(String name) throws PersistenceException;
	
	public Collection<T> getByBirthdayDate(Date birthdayDateOne, Date birthdayDateTwo) throws PersistenceException;
	
	public Collection<T> getByRegistrationDate(Date registrationDateOne, Date registrationDateTwo) throws PersistenceException;
	
	public Collection<T> getByTypePerson(TipoPessoa typePerson) throws PersistenceException;
	
	public void save(T obj) throws PersistenceException;

	public T update(T obj) throws PersistenceException;

	public void toRemove(Long id) throws PersistenceException;

}
