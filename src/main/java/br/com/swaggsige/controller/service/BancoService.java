package br.com.swaggsige.controller.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.Banco;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;
import br.com.swaggsige.model.service.repository.BaseLocalRepository;

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
@Stateless(mappedName = "BancoService")
@LocalBean
public class BancoService implements BaseLocalRepository<Banco> {

	@EJB(beanName = "BancoDAO")
	private BaseLocalRepository<Banco> bancoDAO;
	
	private static Log log = LogFactory.getLog(BancoService.class);

	@Override
	public Collection<Banco> getAll() {
		try {
			return bancoDAO.getAll();
		} catch (PersistenceException e) {
			FacesMessageUtil.addMsgError("Erro ao Buscar Lista "+ e.getMessage());
			log.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Banco getById(Long id) {
		if (id != null) {
			try {
				return bancoDAO.getById(id);
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
	public Collection<Banco> getAllByDescriptionStartsWith(String description) {
		if (description != null && !description.isEmpty()) {
			try {
				return bancoDAO.getAllByDescriptionStartsWith(description);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar por Descrição "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Falha ao Pesquisar pela Descrição, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Falha ao Pesquisar pela Descrição, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public void save(Banco obj) {
		if (obj != null) {
			try {
				bancoDAO.save(obj);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao salvar novo Cadastro "
						+ e.getMessage());
			}
		} else {
			FacesMessageUtil
					.addMsgError("Falha ao Gravar novo Cadastro,  Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Falha ao Gravar novo Cadastro, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
		}

	}

	@Override
	public Banco update(Banco obj) {
		if (obj != null) {

			try {
				return bancoDAO.update(obj);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao atualizar Cadastro "
						+ e.getMessage());
				return null;
			}
		} else {
			new PersistenceException(
					"Não Existe Objeto para Ser Atualizado: Contate o Administrador do sistema");
			return null;
		}
	}

	@Override
	public void toRemove(Long id) {
		if (id != null) {
			try {
				bancoDAO.toRemove(id);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao excluir Cadastro "
						+ e.getMessage());
			}
		} else {
			new PersistenceException(
					"Falha ao Excluir: Contate o Administrador do sistema");
		}
	}

}
