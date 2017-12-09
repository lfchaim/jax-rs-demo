package br.com.whs.jaxrsdemo.util;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class GsonUtil {

	public static Map<String, Object> fromJson(String json) {
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		Map<String, Object> result = (Map<String, Object>)gson.fromJson(json, Map.class);
		return result;
	}

	public static List<Map<String, Object>> fromJsonList(String json) {
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> result = (List<Map<String, Object>>)gson.fromJson(json, List.class);
		return result;
	}

	public static String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	public static String changeValue( String json, String key, String newValue ){
		String ret = null;
		if( json == null || json.trim().length() < 1 )
			return ret;
		Gson gson = new Gson();
		// E um array
		if( json.trim().startsWith("[") ){
			@SuppressWarnings("unchecked")
			List<Map<String,Object>> list = gson.fromJson(json, List.class);
			if( list != null && list.size() > 0 ){
				for( int i = 0; i < list.size(); i++ ){
					Map<String,Object> map = list.get(i);
					map.put(key, newValue);
				}
				ret = gson.toJson(list);
			}
		} else {
			@SuppressWarnings("unchecked")
			Map<String,Object> map = gson.fromJson(json, Map.class);
			map.put(key, newValue);
			ret = gson.toJson(map);
		}
		return ret;
	}

}
