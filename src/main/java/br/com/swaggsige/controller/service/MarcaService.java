package br.com.swaggsige.controller.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.Marca;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;
import br.com.swaggsige.model.service.repository.MarcaLocalRepository;

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
@Stateless(mappedName = "MarcaService")
@LocalBean
public class MarcaService implements MarcaLocalService {

	@EJB(beanName = "MarcaDAO")
	private MarcaLocalRepository marcaDAO;
	
	private static Log log = LogFactory.getLog(MarcaService.class);

	public MarcaService() {
	}
	
	@Override
	public void save(Marca obj) {
		if (obj != null) {
			try {
				marcaDAO.save(obj);
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
	public Marca update(Marca obj) {
		if (obj != null) {

			try {
				return marcaDAO.update(obj);
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
				marcaDAO.toRemove(id);
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


	@Override
	public Collection<Marca> getAll() {
		try {
			return marcaDAO.getAll();
		} catch (PersistenceException e) {
			FacesMessageUtil.addMsgError("Erro ao Buscar Lista "+ e.getMessage());
			log.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Marca getById(Long id) {
		if (id != null) {
			try {
				return marcaDAO.getById(id);
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
	public Collection<Marca> getAllByDescriptionStartsWith(String description) {
		if (description != null && !description.isEmpty()) {
			try {
				return marcaDAO.getAllByDescriptionStartsWith(description);
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

}
