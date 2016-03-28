package org.catais.ai.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

import org.catais.ai.dao.CantonDAO;
import org.catais.ai.dao.DAOException;
import org.catais.ai.dao.DAOFactory;
import org.catais.ai.model.Canton;

import javax.ws.rs.core.MediaType;


@Path("/cantons")
public class CantonResource {
	
	// Vars ---------------------------------------------------------------------------------------

	DAOFactory xanadu2 = DAOFactory.getInstance("xanadu2.jdbc");
	CantonDAO cantonDAO = xanadu2.getCantonDAO();
	
    // Actions ------------------------------------------------------------------------------------
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
	public List<Canton> listCantons() {	
		return cantonDAO.listCantons();
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
		try {
			cantonDAO.activateCanton(canton);
			return Response.status(201).build();
		} catch (DAOException e) {
			return Response.status(406).build();
		}
	} 
	
	@GET
	@Path("{ct}")
	@Consumes(MediaType.APPLICATION_XML)
	public Canton listCanton(@PathParam("ct") String cantonCode) {		
		return cantonDAO.listCanton(cantonCode.toUpperCase());
	}
	
	@PUT
	@Path("{ct}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateCanton(@PathParam("ct") String cantonCode, Canton canton) {
		
		
		System.out.println(cantonCode);
		System.out.println(canton);

		
		return Response.status(200).build(); 
	}
	
	
//	@PUT
//	@Path("{ct}")
//    @Consumes(MediaType.APPLICATION_XML)
//	public Response changeCantonStatus(@PathParam("ct") String cantonCode, @QueryParam("activated") boolean activated) {			
//		cantonDAO.changeCantonStatus(cantonCode.toUpperCase(), activated);
//		return Response.status(200).build();
//	}

	
	
}
