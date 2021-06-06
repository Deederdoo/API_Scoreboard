package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import controller.ConnectionManager;
import model.Score;

public class Scoreboard_DaoImpl {

	private Connection con = null;
	
	public Scoreboard_DaoImpl() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = ConnectionManager.INSTANCE.getConnection("deedoodl_scoreboarddb");
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * */
	public Score getScoreByUXID(int id, String diff) {
		
		String sql = "SELECT * FROM scores_" + diff + " WHERE ux_id = " + id;
		
		Score score = new Score();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				score.setId(rs.getInt(1));
				score.setUx_id(rs.getString(2));
				score.setUserid(rs.getString(3));
				score.setRanking(rs.getInt(4));
				score.setScore(rs.getDouble(5));
				score.setUserid(rs.getString(6));
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
	public List<Score> getAllScores(String diff) {
		
		String sql = "SELECT * FROM scores_" + diff + " ORDER BY ranking ASC;";
		
		List<Score> myScores = new ArrayList<>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Score dbScore = new Score();
				
				dbScore.setId(rs.getInt(1));
				dbScore.setUx_id(rs.getString(2));
				dbScore.setRanking(rs.getInt(3));
				dbScore.setScore(rs.getDouble(4));
				dbScore.setUserid(rs.getString(5));
				
				myScores.add(dbScore);
			}
			
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return myScores;
	}
	
	/**
	 * 
	 * 
	 * 
	 * */
	public void createScore(Score score, String diff) {
		
		String sql = "INSERT INTO scores_" + diff + " (ux_id,ranking,score,userid) VALUES (?,?,?,?);";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, score.getUx_id());
			stmt.setInt(2, 0);
			stmt.setDouble(3, score.getScore());
			stmt.setString(4, score.getUserid());
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * */
	public void updateRankingByID(int id, int newRank, String diff) {
		
		String sql = "UPDATE scores_" + diff + " SET ranking = ? WHERE id = ?;";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, newRank);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}









