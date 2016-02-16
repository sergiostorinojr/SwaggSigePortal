package br.com.swaggsige.model.service.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import br.com.swaggsige.model.domain.Cliente;
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
 *
 */
@Local
public interface ClienteLocalRepository {
	
	public List<Cliente> getAll() throws PersistenceException;
	
	public Cliente getBydId(Long id) throws PersistenceException;
	
	public Cliente getByCpf(String cpf) throws PersistenceException;
	
	public Cliente getByCnpj(String cnpj) throws PersistenceException;
	
	public Cliente getByIe(String ie) throws PersistenceException;
	
	public Cliente getByIm(String im) throws PersistenceException;
	
	public Collection<Cliente> getByName(String name) throws PersistenceException;
	
	public Collection<Cliente> getByBirthdayDate(Date birthdayDateOne, Date birthdayDateTwo) throws PersistenceException;
	
	public Collection<Cliente> getByRegistrationDate(Date registrationDateOne, Date registrationDateTwo) throws PersistenceException;
	
	public Collection<Cliente> getByTypePerson(TipoPessoa typePerson) throws PersistenceException;
	
	public void save(Cliente obj) throws PersistenceException;

	public Cliente update(Cliente obj) throws PersistenceException;

	public void toRemove(Long id) throws PersistenceException;

}
