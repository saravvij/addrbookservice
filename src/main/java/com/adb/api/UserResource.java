package com.adb.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adb.model.User;

@Path("/")
public class UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam ("userId") int userId){
		User user = new User();
		user.setId(1);
		user.setLogonId("saran");
		user.setPassword("xnbsdnsbds");
		return user;
	}
}
