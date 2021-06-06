package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.Scoreboard_DaoImpl;
import model.Score;
import tools.FormatRanking;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource") // keep this named as is (My Android Application uses this to get data)
public class Score_Resource {

	private Scoreboard_DaoImpl dao;
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
        return "Dedoru Scoreboard Resource";
    }
    
    /**
     * Method handling HTTP GET requests. Connect 
     * 
     * @return String that will return a JSON type file
     * 
     * */
    @GET
    @Path("scores_easy/ux_id/{ux_id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Score testTargetGET(@PathParam("ux_id") int id) {
    	
    	dao = new Scoreboard_DaoImpl();
    	
    	return dao.getScoreByUXID(id, "easy");
    }
    
    @GET
    @Path("scores_easy")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Score> getAllEasyScores() {
    	
    	dao = new Scoreboard_DaoImpl();
    	
    	return dao.getAllScores("easy");
    }
    
    @POST
    @Path("score_easy")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createEasyScore(Score score) {
    	
    	List<Score> updatedScores;
    	
    	dao = new Scoreboard_DaoImpl();
    	fr = new FormatRanking();
    	
    	dao.createScore(score, "easy");
    	
    	updatedScores = fr.shuffleNewRanking("easy");
    	
    	for(int i = 0; i < updatedScores.size(); i++) {
    		
    		dao.updateRankingByID(updatedScores.get(i).getId(), updatedScores.get(i).getRanking(), "easy");
    	}
    }
    
    @GET
    @Path("scores_intermediate")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Score> getAllIntermediateScores() {
    	
    	dao = new Scoreboard_DaoImpl();
    	
    	return dao.getAllScores("intermediate");
    }
    
    @POST
    @Path("score_intermediate")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createIntermediateScore(Score score) {
    	
    	List<Score> updatedScores;
    	
    	dao = new Scoreboard_DaoImpl();
    	fr = new FormatRanking();
    	
    	dao.createScore(score, "intermediate");
    	
    	updatedScores = fr.shuffleNewRanking("intermediate");
    	
    	for(int i = 0; i < updatedScores.size(); i++) {
    		
    		dao.updateRankingByID(updatedScores.get(i).getId(), updatedScores.get(i).getRanking(), "intermediate");
    	}
    }
    
    @GET
    @Path("scores_hard")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Score> getAllHardScores() {
    	
    	dao = new Scoreboard_DaoImpl();
    	
    	return dao.getAllScores("hard");
    }
    
    @POST
    @Path("score_hard")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createHardScore(Score score) {
    	
    	List<Score> updatedScores;
    	
    	dao = new Scoreboard_DaoImpl();
    	fr = new FormatRanking();
    	
    	dao.createScore(score, "hard");
    	
    	updatedScores = fr.shuffleNewRanking("hard");
    	
    	for(int i = 0; i < updatedScores.size(); i++) {
    		
    		dao.updateRankingByID(updatedScores.get(i).getId(), updatedScores.get(i).getRanking(), "hard");
    	}
    }
    
    @GET
    @Path("scores_endurance")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Score> getAllEnduranceScores() {
    	
    	dao = new Scoreboard_DaoImpl();
    	
    	return dao.getAllScores("endurance");
    }
    
    @POST
    @Path("score_endurance")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createEnduranceScore(Score score) {
    	
    	List<Score> updatedScores;
    	
    	dao = new Scoreboard_DaoImpl();
    	fr = new FormatRanking();
    	
    	dao.createScore(score, "endurance");
    	
    	updatedScores = fr.shuffleNewRanking("endurance");
    	
    	for(int i = 0; i < updatedScores.size(); i++) {
    		
    		dao.updateRankingByID(updatedScores.get(i).getId(), updatedScores.get(i).getRanking(), "endurance");
    	}
    }
}




