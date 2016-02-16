package br.com.swaggsige.controller.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.domain.TipoPessoa;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;
import br.com.swaggsige.model.service.repository.ClienteLocalRepository;
import br.com.swaggsige.model.service.repository.PessoaLocalRepository;

/**
 * 
 * SwaggSigePortal
 *
 * @Author: Sérgio D. Storino Junior
 * @Email: sergio.storinojr@gmail.com
 * @WebSite: www.sergiostorino.com.br
 * @Github: github@sergiostorino.com.br
 *
 *          Camada Service Classe Responsável por Delegar seu comportamento para
 *          Camada DAO
 *
 */
@Stateless(mappedName = "ClienteService")
@LocalBean
public class ClienteService implements ClienteLocalService {

	@EJB(beanName = "ClienteDAO")
	private ClienteLocalRepository clienteDAO;

	private static Log log = LogFactory.getLog(ClienteService.class);

	public ClienteService() {
	}

	@Override
	public List<Cliente> getAll() {
		try {
			return clienteDAO.getAll();
		} catch (PersistenceException e) {
			FacesMessageUtil.addMsgError("Erro ao Buscar Lista "+ e.getMessage());
			log.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Cliente getById(Long id) {
		if (id != null) {
			try {
				return clienteDAO.getBydId(id);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar por ID "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Falha ao Pesquisar por ID Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.error("Falha ao Pesquisar por ID Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Cliente getByCpf(String cpf) {
		if (cpf != null && !cpf.isEmpty()) {
			try {
				return clienteDAO.getByCpf(cpf);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar por CPF "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Falha ao Pesquisar por CPF Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Falha ao Pesquisar por CPF Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Cliente getByCnpj(String cnpj) {
		if (cnpj != null && !cnpj.isEmpty()) {
			try {
				return clienteDAO.getByCnpj(cnpj);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar por CNPJ "
						+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil
					.addMsgError("Falha ao Pesquisar por CNPJ Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Falha ao Pesquisar por CNPJ Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Cliente getByIe(String ie) {
		if (ie != null && !ie.isEmpty()) {
			try {
				return clienteDAO.getByIe(ie);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar por IE "
						+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil
					.addMsgError("Falha ao Pesquisar por IE Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Falha ao Pesquisar por IE Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Deprecated
	@Override
	public Cliente getByIm(String im) {
		try {
			return clienteDAO.getByIm(im);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Collection<Cliente> getByName(String name) {
		if (name != null && !name.isEmpty()) {
			try {
				return clienteDAO.getByName(name);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar por Nome "
						+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil
					.addMsgError("Falha ao Pesquisar por Nome Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Falha ao Pesquisar por Nome Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Collection<Cliente> getByBirthdayDate(Date birthdayDateOne,
			Date birthdayDateTwo) {
		if (birthdayDateOne != null && birthdayDateTwo != null) {
			try {
				return clienteDAO.getByBirthdayDate(birthdayDateOne,
						birthdayDateTwo);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil
						.addMsgError("Erro ao Buscar por Data Nascimento "
								+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil
					.addMsgError("Falha ao Pesquisar por Data Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Falha ao Pesquisar por Data Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Collection<Cliente> getByRegistrationDate(Date registrationDateOne,
			Date registrationDateTwo) {
		if (registrationDateOne != null && registrationDateTwo != null) {
			try {
				return clienteDAO.getByRegistrationDate(registrationDateOne,
						registrationDateTwo);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil
						.addMsgError("Erro ao Buscar por Data Cadastro "
								+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil
					.addMsgError("Falha ao Pesquisar por Data Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Falha ao Pesquisar por Data Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	/**
	 * Não há query programada para Busca por tipo de pessoa
	 */
	@Deprecated
	@Override
	public Collection<Cliente> getByTypePerson(TipoPessoa typePerson) {
		return null;
	}

	@Override
	public void save(Cliente obj) {
		if (obj != null) {
			try {
				clienteDAO.save(obj);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao salvar novo Cadastro "+ e.getMessage());
			}
		} else {
			FacesMessageUtil
					.addMsgError("Falha ao Gravar novo Cadastro,  Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Falha ao Gravar novo Cadastro, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
		}

	}

	@Override
	public Cliente update(Cliente obj) {
		if (obj != null) {

			try {
				return clienteDAO.update(obj);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao atualizar Cadastro "+ e.getMessage());
				return null;
			}
		} else {
			new PersistenceException("Não Existe Objeto para Ser Atualizado: Contate o Administrador do sistema");
			return null;
		}
	}

	@Override
	public void toRemove(Long id) {
		if (id != null) {
			try {
				clienteDAO.toRemove(id);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao excluir Cadastro "+ e.getMessage());
			}
		} else {
			new PersistenceException("Falha ao Excluir: Contate o Administrador do sistema");
		}

	}


}
