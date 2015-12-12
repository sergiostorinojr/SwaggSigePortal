package br.com.swaggsige.model.service.jpa.repository;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.Marca;
import br.com.swaggsige.model.service.jpa.Resource;
import br.com.swaggsige.model.service.jsf.util.FacesMessageUtil;
import br.com.swaggsige.ulti.jpa.Interface.MarcaRepositoryLocal;
import br.com.swaggsige.ulti.jpa.Interface.MarcaRepositoryRemote;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@Stateless
public class MarcaRepository implements MarcaRepositoryLocal,
		MarcaRepositoryRemote {

	@Inject
	private EntityManager em;
	private static Log log = LogFactory.getLog(MarcaRepository.class);

	@Override
	public Collection<Marca> getAll() {
		this.em = Resource.getEntityManager();

		try {

			if (this.em != null && this.em.isOpen()) {

				Query query = this.em.createNamedQuery("marca.getAll");
				log.info("Lista de Marca gerada com sucesso!!!");
				return query.getResultList();

			} else {
				log.warn("Falha ao buscar a Lista de marca no banco de dados: ");
				FacesMessageUtil
						.addMsgError("Falha ao buscar a lista de Marca no banco de dados\n Contate o Administrador do Sistema");
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
	public Marca getById(Long id) {
		this.em = Resource.getEntityManager();
		try {

			if (this.em != null && this.em.isOpen()) {
				
				Query query = this.em.createNamedQuery("marca.findById");
				query.setParameter("id", id);
				return (Marca) query.getSingleResult();

			} else {

				log.warn("Falha ao buscar Marca Por ID: ");
				FacesMessageUtil
						.addMsgError("Falha ao buscar Marca Por ID\n Contate o Administrador do Sistema");
				return null;
			}
		} finally {
			if (this.em != null && this.em.isOpen()) {
				this.em.close();
				log.info("Conexão getById marca finalizada com sucesso ");
			}
		}
	}

	@Override
	public Collection<Marca> getAllBydescriptionStartsWith(String description) {
		this.em = Resource.getEntityManager();
		try {

			if (this.em != null && this.em.isOpen()) {
				
				Query query = this.em.createNamedQuery("marca.getAllByDescriptionStartsWith");
				String descricao = "%"+description+"%";
				query.setParameter("descricao", descricao);
				return query.getResultList();

			} else {

				log.warn("Falha ao buscar Marca pela Descrição ");
				FacesMessageUtil
						.addMsgError("Falha ao buscar Marca pela Descrição\n Contate o Administrador do Sistema");
				return null;
			}
		} finally {
			if (this.em != null && this.em.isOpen()) {
				this.em.close();
				log.info("Conexão getAllBydescriptionStartsWith marca finalizada com sucesso ");
			}
		}
	}

}
