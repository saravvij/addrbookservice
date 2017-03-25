package com.adb.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.adb.business.ContactService;
import com.adb.model.Contact;

/**
ContactRest API
*/
@Path("{userId}")
public class ContactResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("contact")
	public List<Contact> getAllContacts(@PathParam ("userId") int userId){
		ContactService service = new ContactService();
		List<Contact> contacts = service.getAllContacts(userId);
		return contacts;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("contact/{contactId}")
	public Contact getContact(@PathParam ("userId") int userId, @PathParam ("contactId") int contactId){
		ContactService service = new ContactService();
		Contact contact = service.getContact(contactId);
		return contact;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("contact")
	public Response create(Contact contact){
		ContactService service = new ContactService();
		Contact insertedContact = service.insert(contact);
		//Response Status Code = 201
		// Response should have newly contact (entity)
		Response response = Response.status(Status.CREATED).entity(insertedContact).build();
		return response;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("contact")
	public void update(Contact contact){
		ContactService service = new ContactService();
		service.update(contact);
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("contact/{contactId}")
	public void deleteContact(@PathParam ("userId") int userId, @PathParam ("contactId") int contactId){
		ContactService service = new ContactService();
		 service.deleteContact(contactId);
	}
	
	
}
