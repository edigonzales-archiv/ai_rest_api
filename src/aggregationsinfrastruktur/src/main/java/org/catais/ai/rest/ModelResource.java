package org.catais.ai.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.catais.ai.dao.CantonDAO;
import org.catais.ai.dao.ModelDAO;
import org.catais.ai.dao.DAOFactory;
import org.catais.ai.model.Canton;
import org.catais.ai.model.Model;

@Path("/cantons/{ct}/models")
public class ModelResource {
	
	// Vars ---------------------------------------------------------------------------------------

	DAOFactory xanadu2 = DAOFactory.getInstance("xanadu2.jdbc");
	CantonDAO cantonDAO = xanadu2.getCantonDAO();
	ModelDAO modelDAO = xanadu2.getModelDAO();

    // Actions ------------------------------------------------------------------------------------

	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
	public Response listModels(@PathParam("ct") String cantonCode) {
		Canton canton = cantonDAO.listCanton(cantonCode.toUpperCase());
		
		if (canton == null) {
			return Response.status(404).build();
		}
		
		List<Model> models = modelDAO.listModels(cantonCode.toUpperCase());
						
		final GenericEntity<List<Model>> entity = new GenericEntity<List<Model>>(models) {};
	
		return Response.status(200).entity(entity).build();
	}


}
