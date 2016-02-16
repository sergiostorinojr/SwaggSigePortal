package br.com.swaggsige.controller.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.CentroCusto;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;
import br.com.swaggsige.model.service.repository.CentroCustoLocalRepository;

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
@Stateless(mappedName="CentroCustoService")
@LocalBean
public class CentroCustoService implements CentroCustoLocalRepository{
	
	@EJB(beanName="CentroCustoDAO")
	private CentroCustoLocalRepository centroCustoDAO;
	
	private static Log log = LogFactory.getLog(CentroCustoService.class);
	
	public CentroCustoService() {
	}

	@Override
	public Collection<CentroCusto> getAll() {
		try {
			return centroCustoDAO.getAll();
		} catch (PersistenceException e) {
			FacesMessageUtil.addMsgError("Erro ao Buscar Lista "+ e.getMessage());
			log.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public CentroCusto getById(Long id) {
		if (id != null) {
			try {
				return centroCustoDAO.getById(id);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar por ID "
						+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Falha ao Pesquisar por ID Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.error("Falha ao Pesquisar por ID Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Collection<CentroCusto> getAllByDescriptionStartsWith(String description) {
		if (description != null && !description.isEmpty()) {
			try {
				return centroCustoDAO.getAllByDescriptionStartsWith(description);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar pela Descrição "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao Buscar pela Descrição, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao Buscar pela Descrição, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public void save(CentroCusto centroCusto) {
		if (centroCusto != null) {
			try {
				centroCustoDAO.save(centroCusto);
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
	public CentroCusto update(CentroCusto centroCusto) {
		if (centroCusto != null) {

			try {
				return centroCustoDAO.update(centroCusto);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao atualizar Cadastro "
						+ e.getMessage());
				return null;
			}
		} else {
			new PersistenceException("Não Existe Objeto para Ser Atualizado: Contate o Administrador do sistema");
			return null;
		}
	}

	@Override
	public void toRemove(CentroCusto centroCusto) {
		if (centroCusto != null) {
			try {
				centroCustoDAO.toRemove(centroCusto);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao excluir Cadastro "+ e.getMessage());
			}
		} else {
			new PersistenceException("Falha ao Excluir: Contate o Administrador do sistema");
		}

	}

}
