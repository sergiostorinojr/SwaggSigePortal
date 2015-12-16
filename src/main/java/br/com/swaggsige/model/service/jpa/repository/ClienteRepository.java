package br.com.swaggsige.model.service.jpa.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.domain.EnderecoCliente;
import br.com.swaggsige.model.domain.TipoPessoa;
import br.com.swaggsige.model.service.jpa.Resource;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;
import br.com.swaggsige.ulti.jpa.Interface.ClienteRepositoryLocal;
import br.com.swaggsige.ulti.jpa.Interface.ClienteRepositoryRemote;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@Stateless
public class ClienteRepository implements ClienteRepositoryLocal,
		ClienteRepositoryRemote {

	@Inject
	private EntityManager em;
	private static Log log = LogFactory.getLog(ClienteRepository.class);

	@Override
	public Collection<Cliente> getAll() {
		this.em = Resource.getEntityManager();

		try {

			if (this.em != null && this.em.isOpen()) {

				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<Cliente> cquery = cb.createQuery(Cliente.class);
				Root<Cliente> fromCliente = cquery.from(Cliente.class);
				Root<EnderecoCliente> fromEndereco = cquery.from(EnderecoCliente.class);
				Join<Cliente, EnderecoCliente> theJoin = fromCliente.join("enderecoCliente");
				cquery = cquery.select(fromCliente).where(cb.equal(fromCliente.get("id"), 1L));
				
				//Cliente cliente = em.createQuery(cquery).getSingleResult();
				List<Cliente> resultList = em.createQuery(cquery).getResultList();
				log.info("Lista de Cliente gerada com sucesso!!!");
				return resultList;

				/*Query query = this.em.createQuery(" FROM  ", Cliente.class);
					log.info("Lista de Marca gerada com sucesso!!!");
					return query.getResultList();*/

			} else {
				log.warn("Falha ao buscar a Lista de marca no banco de dados: ");
				FacesMessageUtil
						.addMsgError("Falha ao buscar a lista de Cliente no banco de dados\n Contate o Administrador do Sistema");
				return null;
			}
		} finally {
			if (this.em != null && this.em.isOpen()) {
				this.em.close();
				log.info("Conexão getAll marca finalizada com sucesso ");
			}
		}
	}

	@Override
	public Cliente getBydId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getByCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getByCnpj(String cnpj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getByIe(String ie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getByIm(String im) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getByBirthdayDate(Date birthdayDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getByRegistrationDate(Date registrationDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getByTypePerson(TipoPessoa typePerson) {
		// TODO Auto-generated method stub
		return null;
	}

}
