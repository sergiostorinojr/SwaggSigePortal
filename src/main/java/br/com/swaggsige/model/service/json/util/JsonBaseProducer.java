package br.com.swaggsige.model.service.json.util;

import java.lang.reflect.Type;
import java.util.Collection;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 * 
 */
public class JsonBaseProducer<T extends br.com.swaggsige.model.domain.AbstractEntity> implements
		JsonLocal<T>, JsonRemote<T> {

	private Gson gson = new Gson();
	private GsonBuilder gsonBuilder = new GsonBuilder();
	private Class<?> clazz;

	public JsonBaseProducer(Class<?> clazz) {
		super();
		this.clazz = clazz;
	}

	@Override
	public String toJson(T obj) {
		return gson.toJson(obj);
	}

	@Override
	public String listaToJson(Collection<T> lista) {
		gson = gsonBuilder.create();
		return gson.toJson(lista);
	}

	@Override
	public Object fromJson(String obj) {
		return gson.fromJson(obj, clazz);
	}

	@Override
	public Collection<T> jsonFromList(String lista) {
		Type type = TypeToken.get(clazz).getType();
		return gson.fromJson(lista, type);
	}

	public final Class<?> getClazz() {
		return clazz;
	}

}
