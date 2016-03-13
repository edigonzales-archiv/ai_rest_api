package org.catais.ai.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	
	// Vars ---------------------------------------------------------------------------------------

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
	
    // Actions ------------------------------------------------------------------------------------
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
	public List<Canton> listActivatedCantons() {	
		return cantonDAO.listActivatedCantons();
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public int countActivatedCantons() {
		return cantonDAO.countActivatedCantons();
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_XML)
	public Response activateCanton(Canton canton) {		
		cantonDAO.activateCanton(canton);
		return Response.status(201).build();
	}

	
	
}
