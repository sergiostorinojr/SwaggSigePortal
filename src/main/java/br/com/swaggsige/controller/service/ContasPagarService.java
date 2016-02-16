package br.com.swaggsige.controller.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.ContasPagar;
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
@Stateless(mappedName = "ContasPagarService")
@LocalBean
public class ContasPagarService implements ContasPagarReceberLocalRepository<ContasPagar> {

	@EJB(beanName = "ContasPagarDAO")
	private ContasPagarReceberLocalRepository<ContasPagar> contasPagarDAO;
	
	private static Log log = LogFactory.getLog(ContasPagarService.class);

	public ContasPagarService() {
	}

	@Override
	public Collection<ContasPagar> getAll() {
		try {
			return contasPagarDAO.getAll();
		} catch (PersistenceException e) {
			FacesMessageUtil.addMsgError("Erro ao Buscar Lista "+ e.getMessage());
			log.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Collection<ContasPagar> getAllByRazaoSocialStartsWith(String razaoSocial) {
		if (razaoSocial != null && !razaoSocial.isEmpty()) {
			try {
				return contasPagarDAO.getAllByRazaoSocialStartsWith(razaoSocial);
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
	public Collection<ContasPagar> getAllByPlanoContas(Long idPlanoContas) {
		if (idPlanoContas != null) {
			try {
				return contasPagarDAO.getAllByPlanoContas(idPlanoContas);
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
	public ContasPagar getByCNPJ(String cnpj) {
		if (cnpj != null && !cnpj.isEmpty()) {
			try {
				return contasPagarDAO.getByCNPJ(cnpj);
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
	public ContasPagar getByNumDoc(String numDoc) {
		if (numDoc != null && !numDoc.isEmpty()) {
			try {
				return contasPagarDAO.getByNumDoc(numDoc);
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
	public Collection<ContasPagar> getAllByRegistrationDate(String data1,String data2) {
		if (data1 != null && data2 != null) {
			try {
				return contasPagarDAO.getAllByRegistrationDate(data1, data2);
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
	public Collection<ContasPagar> getByDateExtension(String data1, String data2) {
		if (data1 != null && data2 != null) {
			try {
				return contasPagarDAO.getByDateExtension(data1, data2);
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
	public Collection<ContasPagar> getByDateIssue(String data1, String data2) {
		if (data1 != null && data2 != null) {
			try {
				return contasPagarDAO.getByDateIssue(data1, data2);
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
	public Collection<ContasPagar> getByDueDate(String data1, String data2) {
		if (data1 != null && data2 != null) {
			try {
				return contasPagarDAO.getByDueDate(data1, data2);
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
	public ContasPagar getById(Long id) {
		if (id != null) {
			try {
				return contasPagarDAO.getById(id);
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
	public void save(ContasPagar obj) {
		if (obj != null) {
			try {
				contasPagarDAO.save(obj);
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
	public ContasPagar update(ContasPagar obj) {
		if (obj != null) {

			try {
				return contasPagarDAO.update(obj);
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
	public void toRemove(ContasPagar contasPagar) {
		if (contasPagar != null) {
			try {
				contasPagarDAO.toRemove(contasPagar);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao excluir Cadastro "+ e.getMessage());
			}
		} else {
			new PersistenceException("Falha ao Excluir: Contate o Administrador do sistema");
		}

	}


}
