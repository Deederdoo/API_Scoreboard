package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.SpaceGameScore_DaoImpl;
import model.SpaceGameScore;

@Path("spacegamescore_resource")
public class SpaceGameScore_Resource {

	private SpaceGameScore_DaoImpl dao;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		
		return "SpaceGameScore_Resource Path";
	}
	
	@GET
	@Path("allscores")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<SpaceGameScore> findAllScores(){
		
		dao = new SpaceGameScore_DaoImpl();
		
		return dao.findAll();
	}
	
	@GET
	@Path("allscores/desc")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<SpaceGameScore> findAllScoresASC(){
		
		dao = new SpaceGameScore_DaoImpl();
		
		return dao.findAllASC();
	}
	
	@POST
	@Path("inscore")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createScore(SpaceGameScore score) {
		
		dao = new SpaceGameScore_DaoImpl();
		
		dao.createScore(score);
		
		return Response
				.status(Response.Status.OK)
				.build();
	}
}
