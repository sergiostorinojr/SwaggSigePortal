package br.com.model.service.ws.application;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ws.rs.core.Application;

import br.com.swaggsige.model.service.resource.ClienteServiceWs;

@Stateless
public class SwaggApplication extends Application {

	public SwaggApplication() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> clazz = new HashSet<Class<?>>();
		clazz.add(ClienteServiceWs.class);
		return clazz;
	}

}
