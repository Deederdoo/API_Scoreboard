package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ScoreboardDaoImpl;
import model.Score;
import tools.FormatRanking;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	private ScoreboardDaoImpl dao;
	private FormatRanking fr;
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got itt!";
    }
    
    @GET
    @Path("scores/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Score testTargetGET(@PathParam("id") int id) {
    	
    	dao = new ScoreboardDaoImpl();
    	
    	return dao.getScoreByID(id);
    }
    
    @GET
    @Path("scores")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Score> getAllScores() {
    	
    	dao = new ScoreboardDaoImpl();
    	
    	return dao.getAllScores();
    }
    
    @POST
    @Path("score")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createScore(Score score) {
    	
    	List<Score> updatedScores;
    	
    	dao = new ScoreboardDaoImpl();
    	fr = new FormatRanking();
    	
    	dao.createScore(score);
    	
    	updatedScores = fr.shuffleNewRanking();
    	
    	for(int i = 0; i < updatedScores.size(); i++) {
    		
    		dao.updateRankingByID(updatedScores.get(i).getId(), updatedScores.get(i).getRanking());
    	}
    }
}




