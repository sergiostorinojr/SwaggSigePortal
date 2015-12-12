package br.com.swaggsige.model.service.ws.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.swaggsige.model.service.resource.ClienteService;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class SwaggApplication extends Application{
	
	public SwaggApplication() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> clazz = new HashSet<Class<?>>();
		clazz.add(ClienteService.class);
		return clazz;
	}

}
