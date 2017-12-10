package br.com.whs.jaxrsdemo.test.main;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.whs.jaxrsdemo.model.User;
import br.com.whs.jaxrsdemo.util.JsonUtil;

public class UserTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<User> list = User.testLoad();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		System.out.println(json);
		List<Map<String, Object>> listRet = JsonUtil.fromJsonList(json);
		for( int i = 0; i < listRet.size(); i++ ){
			System.out.println(listRet.get(i).toString());
		}
	}

}
