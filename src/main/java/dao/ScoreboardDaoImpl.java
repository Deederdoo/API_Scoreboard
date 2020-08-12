package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import controller.ConnectionManager;
import model.Score;

public class ScoreboardDaoImpl {

	private Connection con = null;
	
	public ScoreboardDaoImpl() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = ConnectionManager.INSTANCE.getConnection();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * */
	public Score getScoreByID(int id) {
		
		String sql = "SELECT * FROM scores WHERE ID = " + id;
		
		Score score = new Score();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				score.setId(rs.getInt(1));
				score.setRanking(rs.getInt(2));
				score.setScore(rs.getDouble(3));
				score.setUserid(rs.getString(4));
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return score;
	}
	
	/**
	 * 
	 * 
	 * 
	 * */
	public List<Score> getAllScores() {
		
		String sql = "SELECT * FROM scores;";
		
		List<Score> myScores = new ArrayList<>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Score dbScore = new Score();
				
				dbScore.setId(rs.getInt(1));
				dbScore.setRanking(rs.getInt(2));
				dbScore.setScore(rs.getDouble(3));
				dbScore.setUserid(rs.getString(4));
				
				myScores.add(dbScore);
			}
			
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return myScores;
	}
	
}
