package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.ConnectionManager;
import model.SpaceGameScore;

public class SpaceGameScore_DaoImpl {
	
	private Connection con = null;
	
	public SpaceGameScore_DaoImpl() {
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = ConnectionManager.INSTANCE.getConnection("deedoodl_gamescoreboard");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public List<SpaceGameScore> findAll(){
		
		String sql = "SELECT * FROM scores;";

		List<SpaceGameScore> scores = new ArrayList<>();

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				SpaceGameScore dbScore = new SpaceGameScore();

				dbScore.setId(rs.getInt(1));
				dbScore.setUsername(rs.getString(2));
				dbScore.setScore(rs.getInt(3));
				dbScore.setDate(rs.getString(4));

				scores.add(dbScore);
			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return scores;
	}
	
	public List<SpaceGameScore> findAllASC(){
		
		String sql = "SELECT * FROM scores ORDER BY score desc;";
		
		List<SpaceGameScore> scores = new ArrayList<>();

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				SpaceGameScore dbScore = new SpaceGameScore();

				dbScore.setId(rs.getInt(1));
				dbScore.setUsername(rs.getString(2));
				dbScore.setScore(rs.getInt(3));
				dbScore.setDate(rs.getString(4));

				scores.add(dbScore);
			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return scores;
	}
	
	public void createScore(SpaceGameScore score) {
		
		String sql = "INSERT INTO scores (username, score, date) VALUES (?, ?, ?);";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, score.getUsername());
			stmt.setInt(2, score.getScore());
			stmt.setString(3, score.getDate());
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
	}
}






