package br.com.swaggsige.model.service.jpa;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class Resource implements Serializable{
	
	private static EntityManagerFactory emFactory;
	
	@Produces
	public static EntityManager getEntityManager(){
		emFactory = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emFactory.createEntityManager();
		return em;
	}

}
