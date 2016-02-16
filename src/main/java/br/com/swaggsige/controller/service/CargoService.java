package br.com.swaggsige.controller.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.Cargo;
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
@Stateless(mappedName = "CargoService")
@LocalBean
public class CargoService implements BaseLocalRepository<Cargo> {

	@EJB(beanName = "CargoDAO")
	private BaseLocalRepository<Cargo> cargoDAO;
	
	private static Log log = LogFactory.getLog(CargoService.class);
	
	public CargoService() {
	}

	@Override
	public Collection<Cargo> getAll() {
		try {
			return cargoDAO.getAll();
		} catch (PersistenceException e) {
			FacesMessageUtil.addMsgError("Erro ao Buscar Lista "+ e.getMessage());
			log.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Cargo getById(Long id) {
		if (id != null) {
			try {
				return cargoDAO.getById(id);
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
	public Collection<Cargo> getAllByDescriptionStartsWith(String description) {
	if (description != null && !description.isEmpty()) {
		try {
			return cargoDAO.getAllByDescriptionStartsWith(description);
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
	public void save(Cargo obj) {
		if (obj != null) {
			try {
				cargoDAO.save(obj);
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
	public Cargo update(Cargo obj) {
		if (obj != null) {

			try {
				return cargoDAO.update(obj);
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
				cargoDAO.toRemove(id);
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
