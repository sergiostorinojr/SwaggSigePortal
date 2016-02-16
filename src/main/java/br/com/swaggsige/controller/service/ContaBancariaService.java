package br.com.swaggsige.controller.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.ContaBancaria;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;
import br.com.swaggsige.model.service.repository.ContaBancariaLocalRepository;

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
@Stateless(mappedName = "ContaBancariaService")
@LocalBean
public class ContaBancariaService implements ContaBancariaLocalRepository {
	
	@EJB(beanName="ContaBancariaDAO")
	private ContaBancariaLocalRepository contaBancariaDAO;

	private static Log log = LogFactory.getLog(ContaBancariaService.class);
	
	@Override
	public Collection<ContaBancaria> getAll() {
		try {
			return contaBancariaDAO.getAll();
		} catch (PersistenceException e) {
			FacesMessageUtil.addMsgError("Erro ao Buscar Lista "+ e.getMessage());
			log.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public ContaBancaria getById(Long id) {
		if (id != null) {
			try {
				return contaBancariaDAO.getById(id);
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
	public Collection<ContaBancaria> getAllByDescriptionStartsWith(String description) {
		if (description != null && !description.isEmpty()) {
			try {
				return contaBancariaDAO.getAllByDescriptionStartsWith(description);
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
	public Collection<ContaBancaria> getAllByCity(String cidade)throws PersistenceException {
		if (cidade != null && !cidade.isEmpty()) {
			try {
				
				return contaBancariaDAO.getAllByCity(cidade);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar pela Cidade "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao Buscar pela Cidade, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao Buscar pela Cidade, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public ContaBancaria getByCC(Long contaCorrente)throws PersistenceException {
		if (contaCorrente != null) {
			try {
				
				return contaBancariaDAO.getByCC(contaCorrente);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar pela Conta Corrente "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao Buscar pela Conta Corrente, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao Buscar pela Conta Corrente, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public ContaBancaria getByAgency(Long agencia) throws PersistenceException {
		if (agencia != null) {
			try {
				
				return contaBancariaDAO.getByAgency(agencia);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar pela Agencia "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao Buscar pela Agencia, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao Buscar pela Agencia, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public Collection<ContaBancaria> getByRegistrationDate(String data1,String data2) throws PersistenceException {
		if (data1 != null && data2 != null) {
			try {
				
				return contaBancariaDAO.getByRegistrationDate(data1, data2);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao Buscar pela Data de Cadastro "+ e.getMessage());
				return null;
			}
		} else {
			FacesMessageUtil.addMsgError("Erro ao Buscar pela Data de Cadastro, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			log.warn("Erro ao Buscar pela Data de Cadastro, Parametro Ivalido ou Nulo para o tipo de Pesquisa");
			return null;
		}
	}

	@Override
	public void save(ContaBancaria contaBancaria) {
		if (contaBancaria != null) {
			try {
				contaBancariaDAO.save(contaBancaria);
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
	public ContaBancaria update(ContaBancaria contaBancaria) {
		if (contaBancaria != null) {

			try {
				return contaBancariaDAO.update(contaBancaria);
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
	public void toRemove(ContaBancaria contaBancaria) {
		if (contaBancaria != null) {
			try {
				contaBancariaDAO.toRemove(contaBancaria);
			} catch (PersistenceException e) {
				log.warn(e.getMessage());
				FacesMessageUtil.addMsgError("Erro ao excluir Cadastro "+ e.getMessage());
			}
		} else {
			new PersistenceException("Falha ao Excluir: Contate o Administrador do sistema");
		}

	}



}
