package br.com.whs.jaxrsdemo.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.whs.jaxrsdemo.db.BigDB;
import br.com.whs.jaxrsdemo.model.User;
import br.com.whs.jaxrsdemo.util.GsonUtil;
import br.com.whs.jaxrsdemo.util.JsonUtil;

@Path("user-resource")
public class UserResource {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String select( ) {
		List<User> list = User.testLoad();
		return JsonUtil.toJson(list);
    }
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes({MediaType.APPLICATION_JSON})
    public String add( User user ) {
		BigDB db = new BigDB();
        String cont = db.select("user");
        if( cont == null || cont.trim().length() < 1 ){
        	List<Map<String,Object>> list = new ArrayList<>();
        	//list.add(JsonUtil.fromJson(content));
        	list.add(JsonUtil.fromJson(JsonUtil.toJson(user)));
        	db.add("user", JsonUtil.toJson(list));
        }
        return "{\"code\":200,\"message\":\"Success\"}";
    }

	@POST
	@Path("/add-str")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes({MediaType.APPLICATION_JSON})
    public String addStr( String content ) {
		BigDB db = new BigDB();
        String cont = db.select("user");
        if( cont == null || cont.trim().length() < 1 ){
        	List<Map<String,Object>> list = new ArrayList<>();
        	list.add(GsonUtil.fromJson(content));
        	//list.add(JsonUtil.fromJson(JsonUtil.toJson(user)));
        	db.add("user", JsonUtil.toJson(list));
        }
        return "{\"code\":200,\"message\":\"Success\"}";
    }
}
