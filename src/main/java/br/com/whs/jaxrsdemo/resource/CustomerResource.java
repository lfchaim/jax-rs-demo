package br.com.whs.jaxrsdemo.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.whs.jaxrsdemo.util.GsonUtil;

@Path("customer")
public class CustomerResource {

	@POST
	@Path("/add")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String add( String value ){
		System.out.println(value);
		value = GsonUtil.changeValue(value, "name", "Frank Sinatra");
		value = GsonUtil.changeValue(value, "active", "false");
		System.out.println(value);
		return value;
	}
}
