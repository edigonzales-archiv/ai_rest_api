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
	public List<Canton> listActivatedCantons()
	{	
		return cantonDAO.listActivatedCantons();
	}

	
	
}
