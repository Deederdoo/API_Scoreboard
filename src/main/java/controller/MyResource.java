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
        return "Dedoru API";
    }
    
    @GET
    @Path("scores_easy/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Score testTargetGET(@PathParam("id") int id) {
    	
    	dao = new ScoreboardDaoImpl();
    	
    	return dao.getScoreByID(id, "easy");
    }
    
    @GET
    @Path("scores_easy")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Score> getAllEasyScores() {
    	
    	dao = new ScoreboardDaoImpl();
    	
    	return dao.getAllScores("easy");
    }
    
    @POST
    @Path("score_easy")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createEasyScore(Score score) {
    	
    	List<Score> updatedScores;
    	
    	dao = new ScoreboardDaoImpl();
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
    	
    	dao = new ScoreboardDaoImpl();
    	
    	return dao.getAllScores("intermediate");
    }
    
    @POST
    @Path("score_intermediate")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createIntermediateScore(Score score) {
    	
    	List<Score> updatedScores;
    	
    	dao = new ScoreboardDaoImpl();
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
    	
    	dao = new ScoreboardDaoImpl();
    	
    	return dao.getAllScores("hard");
    }
    
    @POST
    @Path("score_hard")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createHardScore(Score score) {
    	
    	List<Score> updatedScores;
    	
    	dao = new ScoreboardDaoImpl();
    	fr = new FormatRanking();
    	
    	dao.createScore(score, "hard");
    	
    	updatedScores = fr.shuffleNewRanking("hard");
    	
    	for(int i = 0; i < updatedScores.size(); i++) {
    		
    		dao.updateRankingByID(updatedScores.get(i).getId(), updatedScores.get(i).getRanking(), "hard");
    	}
    }
    
    @GET
    @Path("scores_savant")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Score> getAllSavantScores() {
    	
    	dao = new ScoreboardDaoImpl();
    	
    	return dao.getAllScores("savant");
    }
    
    @POST
    @Path("score_savant")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createSavantScore(Score score) {
    	
    	List<Score> updatedScores;
    	
    	dao = new ScoreboardDaoImpl();
    	fr = new FormatRanking();
    	
    	dao.createScore(score, "savant");
    	
    	updatedScores = fr.shuffleNewRanking("savant");
    	
    	for(int i = 0; i < updatedScores.size(); i++) {
    		
    		dao.updateRankingByID(updatedScores.get(i).getId(), updatedScores.get(i).getRanking(), "savant");
    	}
    }
}




