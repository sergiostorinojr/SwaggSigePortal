package br.com.swaggsige.controller.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.domain.TipoPessoa;

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
public interface ClienteLocalService {
	
	public List<Cliente> getAll();
	
	public Cliente getById(Long id);
	
	public Cliente getByCpf(String cpf);
	
	public Cliente getByCnpj(String cnpj);
	
	public Cliente getByIe(String ie);
	
	public Cliente getByIm(String im);
	
	public Collection<Cliente> getByName(String name);
	
	public Collection<Cliente> getByBirthdayDate(Date birthdayDateOne, Date birthdayDateTwo);
	
	public Collection<Cliente> getByRegistrationDate(Date registrationDateOne, Date registrationDateTwo);
	
	public Collection<Cliente> getByTypePerson(TipoPessoa typePerson);
	
	public void save(Cliente obj);

	public Cliente update(Cliente obj);

	public void toRemove(Long id);

}
