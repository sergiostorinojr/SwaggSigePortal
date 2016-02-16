package br.com.swaggsige.controller.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.ContasReceber;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;
import br.com.swaggsige.model.service.repository.ContasPagarReceberLocalRepository;

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
@Stateless(mappedName = "ContasReceberService")
@LocalBean
public class ContasReceberService implements ContasPagarReceberLocalRepository<ContasReceber> {

	@EJB(beanName = "ContasPagarDAO")
	private ContasPagarReceberLocalRepository<ContasReceber> contasReceberDAO;

	private static Log log = LogFactory.getLog(ContasReceberService.class);

	public ContasReceberService() {
	}

	@Override
	public Collection<ContasReceber> getAll() {
		try {
			return contasReceberDAO.getAll();
		} catch (PersistenceException e) {
			FacesMessageUtil.addMsgError("Erro ao Buscar Lista "+ e.getMessage());
			log.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Collection<ContasReceber> getAllByRazaoSocialStartsWith(String razaoSocial) {
		if (razaoSocial != null && !razaoSocial.isEmpty()) {
			try {
				return contasReceberDAO.getAllByRazaoSocialStartsWith(razaoSocial);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao realizar a Busca "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Collection<ContasReceber> getAllByPlanoContas(Long idPlanoContas) {
		if (idPlanoContas != null) {
			try {
				return contasReceberDAO.getAllByPlanoContas(idPlanoContas);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao realizar a Busca "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public ContasReceber getByCNPJ(String cnpj) {
		if (cnpj != null && !cnpj.isEmpty()) {
			try {
				return contasReceberDAO.getByCNPJ(cnpj);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao realizar a Busca "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public ContasReceber getByNumDoc(String numDoc) {
		if (numDoc != null && !numDoc.isEmpty()) {
			try {
				return contasReceberDAO.getByNumDoc(numDoc);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao realizar a Busca "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Collection<ContasReceber> getAllByRegistrationDate(String data1,String data2) {
		if (data1 != null && data2 != null) {
			try {
				return contasReceberDAO.getAllByRegistrationDate(data1, data2);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao realizar a Busca "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Collection<ContasReceber> getByDateExtension(String data1, String data2) {
		if (data1 != null && data2 != null) {
			try {
				return contasReceberDAO.getByDateExtension(data1, data2);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao realizar a Busca "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Collection<ContasReceber> getByDateIssue(String data1, String data2) {
		if (data1 != null && data2 != null) {
			try {
				return contasReceberDAO.getByDateIssue(data1, data2);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao realizar a Busca "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Collection<ContasReceber> getByDueDate(String data1, String data2) {
		if (data1 != null && data2 != null) {
			try {
				return contasReceberDAO.getByDueDate(data1, data2);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao realizar a Busca "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao realizar a Busca, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public ContasReceber getById(Long id) {
		if (id != null) {
			try {
				return contasReceberDAO.getById(id);
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
	public void save(ContasReceber obj) {
		if (obj != null) {
			try {
				contasReceberDAO.save(obj);
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
	public ContasReceber update(ContasReceber obj) {
		if (obj != null) {

			try {
				return contasReceberDAO.update(obj);
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
	public void toRemove(ContasReceber contasReceber) {
		if (contasReceber != null) {
			try {
				contasReceberDAO.toRemove(contasReceber);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao excluir Cadastro "+ e.getMessage());
			}
		} else {
			new PersistenceException("Falha ao Excluir: Contate o Administrador do sistema");
		}

	}


}
