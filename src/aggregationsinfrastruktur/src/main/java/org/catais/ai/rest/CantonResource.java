package org.catais.ai.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


@Path("/cantons")
public class CantonResource {
	
	// Returns list of cantons. 
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	public List findAll() {
		return new ArrayList(); // dummy
	}
	
	
	
	@GET
	@Produces("text/html")
	public Response getStartingPage()
	{
		String output = "<h1>Hello World!<h1>" +
				"<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>";
		return Response.status(200).entity(output).build();
	}

	
	
}
