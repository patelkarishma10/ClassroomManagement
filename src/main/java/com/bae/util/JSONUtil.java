package com.bae.util;

import com.google.gson.Gson;

public class JSONUtil {

	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public String getJSONForObject(Object obj) {
		// return JSONValue.toJSONString(obj);
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		// return (T) JSONValue.parse(jsonString);
		return gson.fromJson(jsonString, clazz);
	}

}