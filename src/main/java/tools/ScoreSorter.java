package tools;

import java.util.Comparator;

import model.Score;

public class ScoreSorter implements Comparator<Score> {

	@Override
	public int compare(Score o1, Score o2) {
		
		if(o1.getScore() < o2.getScore()) {
			
			return 1;
			
		}else if(o1.getScore() > o2.getScore()) {
			
			return -1;
			
		}else {
			
			return 0;
		}
	}
}
