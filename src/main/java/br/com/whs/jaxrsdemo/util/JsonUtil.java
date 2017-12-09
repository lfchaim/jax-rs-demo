package br.com.whs.jaxrsdemo.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JsonUtil {

	public static Map<String, Object> fromJson( String json ){
		Map<String, Object> result = null;
		ObjectMapper mapper = null;
		TypeFactory factory = null;
		MapType type = null;
		try{
			factory = TypeFactory.defaultInstance();
			type    = factory.constructMapType(HashMap.class, String.class, Object.class);
			mapper  = new ObjectMapper();
			result  = mapper.readValue(json, type);
		}catch( JsonMappingException e ){
			e.printStackTrace();;
		}catch( JsonParseException e ){
			e.printStackTrace();
		}catch( IOException e ){
			e.printStackTrace();
		}
		return result;
	}

	public static List<Map<String, Object>> fromJsonList( String json ){
		List<Map<String, Object>> result = null;
		ObjectMapper mapper = null;
		TypeReference<List<Map<String, Object>>> mapType = null;
		try{
			mapType = new TypeReference<List<Map<String, Object>>>() {};
			mapper  = new ObjectMapper();
			result  = mapper.readValue(json, mapType);
		}catch( JsonMappingException e ){
			e.printStackTrace();;
		}catch( JsonParseException e ){
			e.printStackTrace();
		}catch( IOException e ){
			e.printStackTrace();
		}
		return result;
	}
	
	public static String toJson( Object obj ){
		String ret = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			ret = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
