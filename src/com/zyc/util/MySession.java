package com.zyc.util;

import java.util.HashMap;
import java.util.Map;

public class MySession {
	private static Map<String,Object> objects = new HashMap<String,Object>();
	
	/**
	 * 
	 */
	public MySession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Map<String, Object> getObjects() {
		return objects;
	}

	public static void setObjects(Map<String, Object> objects) {
		MySession.objects = objects;
	}
	public static void add(String key,Object value){
		objects.put(key, value);
	}
	public static Object get(String key){
		return objects.get(key);
	}
}
