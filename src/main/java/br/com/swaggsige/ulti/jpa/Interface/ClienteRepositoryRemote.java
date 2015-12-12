package br.com.swaggsige.ulti.jpa.Interface;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Remote;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.domain.Marca;
import br.com.swaggsige.model.domain.TipoPessoa;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@Remote
public interface ClienteRepositoryRemote {
	
	public Collection<Cliente> getAll();
	public Cliente getBydId(Long id);
	public Cliente getByCpf(String cpf);
	public Cliente getByCnpj(String cnpj);
	public Cliente getByIe(String ie);
	public Cliente getByIm(String im);
	public Cliente getByName(String name);
	public Cliente getByBirthdayDate(Date birthdayDate);
	public Cliente getByRegistrationDate(Date registrationDate);
	public Cliente getByTypePerson(TipoPessoa typePerson);

}
