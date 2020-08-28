package tools;

import java.util.List;

import dao.ScoreboardDaoImpl;
import model.Score;

public class FormatRanking {
	
	private ScoreboardDaoImpl dao;
	private List<Score> allScores;
	
	public List<Score> shuffleNewRanking(String difficulty) {
		
		dao = new ScoreboardDaoImpl();
		
		if(difficulty == "easy") {
			
			allScores = dao.getAllScores(difficulty);
			
		}else if(difficulty == "intermediate") {
			
			allScores = dao.getAllScores(difficulty);
			
		}else if(difficulty == "hard") {
			
			allScores = dao.getAllScores(difficulty);
			
		}else if(difficulty == "endurance") {
			
			allScores = dao.getAllScores(difficulty);
		}
		
		allScores.sort(new ScoreSorter());
		
		for(int i = 0; i < allScores.size(); i++) {
			
			allScores.get(i).setRanking(i + 1);
		}
		
		return allScores;
	}

	public List<Score> formatLowToHigh() {
		
		return null;
	}
	
	public List<Score> formatHighToLow() {
		
		return null;
	}
}


