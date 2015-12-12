package br.com.swaggsige.controller.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.model.domain.Marca;
import br.com.swaggsige.model.domain.PermissaoAcesso;
import br.com.swaggsige.model.domain.Usuario;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.jpa.BaseRepositoryLocal;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
@ManagedBean(name="marcaMB")
@RequestScoped
public class MarcaMB implements Serializable{
	
	@EJB
	private BaseRepositoryLocal<Marca> baseRepository; //= new BaseRepository<Marca>(Marca.class);
	@EJB
	private BaseRepositoryLocal<Usuario> br ;
	private static Log log = LogFactory.getLog(Marca.class);
	
	private Marca marca = new Marca();
	
	public MarcaMB() {
		// TODO Auto-generated constructor stub
	}
	
	public void salvar() throws PersistenceException{
			baseRepository.saveOrUpdate(marca);
			log.info("Cadastro salvo com sucesso");
			
	}

	public final Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	

}
