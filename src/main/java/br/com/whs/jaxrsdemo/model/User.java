package br.com.whs.jaxrsdemo.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User {

	private String name;
	private String pass;
	private boolean active;
	private String createDate;
	private String updateDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public static List<User> testLoad(){
		List<User> ret = new ArrayList<User>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for( int i = 0; i < 1000; i++){
			User u = new User();
			u.setName("First Last "+(i+1));
			u.setPass(UUID.randomUUID().toString().substring(0,8));
			u.setActive(true);
			u.setCreateDate(sdf.format(new Date()));
			u.setUpdateDate(sdf.format(new Date()));
			ret.add(u);
		}
		return ret;
	}

}
