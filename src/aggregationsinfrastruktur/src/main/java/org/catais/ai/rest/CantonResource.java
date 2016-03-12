package org.catais.ai.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

import org.catais.ai.dao.CantonDAO;
import org.catais.ai.dao.DAOFactory;
import org.catais.ai.model.Canton;

import javax.ws.rs.core.MediaType;


@Path("/cantons")
public class CantonResource {
	
	DAOFactory xanadu2 = DAOFactory.getInstance("xanadu2.jdbc");
	CantonDAO cantonDAO = xanadu2.getCantonDAO();

	
    //CantonDAO cantonDao = new CantonDAOImpl();
	
	// Returns list of cantons. 
//	@GET
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
//	public List<Canton> findAll() {
//		
//		System.out.println("*********fubar");
//		
//		return new ArrayList(); // dummy
//	}
	
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	public List<Canton> getStartingPage()
	{
		
		
		System.out.println(cantonDAO.list());
		
		return cantonDAO.list(); //XML-Output only
		
//		List<Canton> matched;
//		GenericEntity<List<Canton>> entity;
//		
//		matched = cantonDAO.list();
//		entity = new GenericEntity<List<Canton>>(matched){};
//		
//		return Response.ok(entity).build();
		

		
//		String output = "<h1>Hello World!<h1>" +
//				"<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>";
//		return Response.status(200).entity(output).build();
	}

	
	
}
