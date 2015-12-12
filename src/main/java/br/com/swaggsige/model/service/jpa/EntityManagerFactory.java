package br.com.swaggsige.model.service.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class EntityManagerFactory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Resource resource;
	
	public EntityManager getEntityManager(){
		return resource.getEntityManager();
	}

}
