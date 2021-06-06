package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.ConnectionManager;
import model_parts.GPU;

public class GPU_DaoImpl {

	private Connection con = null;

	/**
	 * 
	 * Constructor creates a connection with given database string
	 * 
	 * */
	public GPU_DaoImpl() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = ConnectionManager.INSTANCE.getConnection("deedoodl_parts");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Finds all GPU's from the database and puts them into GPU object list
	 * 
	 * @return	List<GPU>	Returns list of GPU's pulled from database
	 * 
	 * */
	public List<GPU> findAll() {

		String sql = "SELECT * FROM gpu;";

		List<GPU> myGPUs = new ArrayList<>();

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				GPU dbGPU = new GPU();

				dbGPU.setId(rs.getLong(1));
				dbGPU.setBrand(rs.getString(2));
				dbGPU.setType(rs.getString(3));
				dbGPU.setTier(rs.getString(4));
				dbGPU.setPrice(rs.getString(5));
				dbGPU.setDate_start(rs.getString(6));
				dbGPU.setTime_start((rs.getString(7)));
				dbGPU.setDate_end(rs.getString(8));
				dbGPU.setTime_end((rs.getString(9)));

				myGPUs.add(dbGPU);
			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return myGPUs;
	}
	
	/**
	 * 
	 * Finds all GPU's from database that are within the given tier specification
	 * 
	 * @param	tier		String of GPU tier (3080, 3090...)
	 * 
	 * @return	List<GPU>	Returns list of GPU's which match given tier
	 * 
	 * */
	public List<GPU> findAllGPUByTier(String tier) {

		String sql = "SELECT * FROM gpu WHERE tier = '" + tier + "';";

		List<GPU> myGPUs = new ArrayList<>();

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				GPU dbGPU = new GPU();

				dbGPU.setId(rs.getLong(1));
				dbGPU.setBrand(rs.getString(2));
				dbGPU.setType(rs.getString(3));
				dbGPU.setTier(rs.getString(4));
				dbGPU.setPrice(rs.getString(5));
				dbGPU.setDate_start(rs.getString(6));
				dbGPU.setTime_start((rs.getString(7)));
				dbGPU.setDate_end(rs.getString(8));
				dbGPU.setTime_end((rs.getString(9)));

				myGPUs.add(dbGPU);
			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return myGPUs;
	}
	
	/**
	 * 
	 * Find all GPU's which match the given id Integer then returns
	 * the specific found GPU
	 * 
	 * @param	id	Integer used to find specific GPU in database
	 * 
	 * @return	GPU	Returns GPU object with specific id
	 * 
	 * */
	public GPU findGPUByID(int id) {
		
		String sql = "SELECT * FROM gpu WHERE id = " + id;
		
		GPU dbGPU = new GPU();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				dbGPU.setId(rs.getLong(1));
				dbGPU.setBrand(rs.getString(2));
				dbGPU.setType(rs.getString(3));
				dbGPU.setTier(rs.getString(4));
				dbGPU.setPrice(rs.getString(5));
				dbGPU.setDate_start(rs.getString(6));
				dbGPU.setTime_start((rs.getString(7)));
				dbGPU.setDate_end(rs.getString(8));
				dbGPU.setTime_end((rs.getString(9)));
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return dbGPU;
	}
	
	/**
	 * 
	 * Find all GPU's that match the given date parameter then returns
	 * them into a list of GPU's
	 * 
	 * @param	date		String used to find a GPU by it's date
	 * 
	 * @return	List<GPU>	Returns list of GPU's which match given date
	 * 
	 * */
	public List<GPU> findAllGPUByDate(String date){
		
		String sql = "SELECT * FROM gpu WHERE date_start = '" + date + "';";
		
		List<GPU> myGPUs = new ArrayList<>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				GPU dbGPU = new GPU();
				
				dbGPU.setId(rs.getLong(1));
				dbGPU.setBrand(rs.getString(2));
				dbGPU.setType(rs.getString(3));
				dbGPU.setTier(rs.getString(4));
				dbGPU.setPrice(rs.getString(5));
				dbGPU.setDate_start(rs.getString(6));
				dbGPU.setTime_start((rs.getString(7)));
				dbGPU.setDate_end(rs.getString(8));
				dbGPU.setTime_end((rs.getString(9)));
				
				myGPUs.add(dbGPU);
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return myGPUs;
	}
	
	/**
	 * 
	 * Find all GPU's that contain given date and tier parameters then returns a list
	 * of GPU's that contain all the found results
	 * 
	 * @param	date, tier	String date and String tier are used to find GPU's which match
	 * 						these parameters
	 * 
	 * @return	List<GPU>	Returns list of GPU's which match given parameters date, string
	 * 
	 * */
	public List<GPU> findAllGPUByDateAndTier(String date, String tier){
		
		String sql = "SELECT * FROM gpu WHERE date_start = '" 
		+ date + "' AND tier = '" + tier + "';";
		
		List<GPU> myGPUs = new ArrayList<>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				GPU dbGPU = new GPU();
				
				dbGPU.setId(rs.getLong(1));
				dbGPU.setBrand(rs.getString(2));
				dbGPU.setType(rs.getString(3));
				dbGPU.setTier(rs.getString(4));
				dbGPU.setPrice(rs.getString(5));
				dbGPU.setDate_start(rs.getString(6));
				dbGPU.setTime_start((rs.getString(7)));
				dbGPU.setDate_end(rs.getString(8));
				dbGPU.setTime_end((rs.getString(9)));
				
				myGPUs.add(dbGPU);
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return myGPUs;
	}
	
	/**
	 * 
	 * Searches database from all dates in between now and the given date
	 * 
	 * @param	toDate		The date the user wishes to find from today
	 * 
	 * @return	List<GPU>	Returns list of GPU's matching parameters
	 * 
	 * */
	public List<GPU> findAllGPUFromDateRange(String today, String toDate){
		
		String sql = "SELECT * FROM gpu WHERE date_start <= '" 
		+ today + "' AND date_start >= '" + toDate + "';";
		
		List<GPU> myGPUs = new ArrayList<>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				GPU dbGPU = new GPU();
				
				dbGPU.setId(rs.getLong(1));
				dbGPU.setBrand(rs.getString(2));
				dbGPU.setType(rs.getString(3));
				dbGPU.setTier(rs.getString(4));
				dbGPU.setPrice(rs.getString(5));
				dbGPU.setDate_start(rs.getString(6));
				dbGPU.setTime_start((rs.getString(7)));
				dbGPU.setDate_end(rs.getString(8));
				dbGPU.setTime_end((rs.getString(9)));
				
				myGPUs.add(dbGPU);
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return myGPUs;
	}
	
	/**
	 * 
	 * Searches database from all dates in between now and the given date
	 * 
	 * @param	toDate		The date the user wishes to find from today
	 * 
	 * @return	List<GPU>	Returns list of GPU's matching parameters
	 * 
	 * */
	public List<GPU> findAllGPUFromDateRangeAndTier(String today, String toDate, String tier){
		
		String sql = "SELECT * FROM gpu WHERE date_start <= '" 
				+ today + "' AND date_start >= '" 
				+ toDate + "' AND tier = '" 
				+ tier + "';";
		
		List<GPU> myGPUs = new ArrayList<>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				GPU dbGPU = new GPU();
				
				dbGPU.setId(rs.getLong(1));
				dbGPU.setBrand(rs.getString(2));
				dbGPU.setType(rs.getString(3));
				dbGPU.setTier(rs.getString(4));
				dbGPU.setPrice(rs.getString(5));
				dbGPU.setDate_start(rs.getString(6));
				dbGPU.setTime_start((rs.getString(7)));
				dbGPU.setDate_end(rs.getString(8));
				dbGPU.setTime_end((rs.getString(9)));
				
				myGPUs.add(dbGPU);
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return myGPUs;
	}
	
	/**
	 * 
	 * Inserts parameter GPU into database then returns the id key that is 
	 * automatically generated by the database
	 * 
	 * @param	GPU		GPU to be inserted into the database
	 * 
	 * @return	Long	id of the newly added GPU object
	 * 
	 * */
	public Long createNewGPU(GPU newGPU) {
		
		String sql = "INSERT INTO gpu (brand, type, tier, price, date_start"
				+ ", time_start, date_end, time_end) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newGPU.getBrand());
			stmt.setString(2, newGPU.getType());
			stmt.setString(3, newGPU.getTier());
			stmt.setString(4, newGPU.getPrice());
			stmt.setString(5, newGPU.getDate_start());
			stmt.setString(6, newGPU.getTime_start());
			stmt.setString(7, newGPU.getDate_end());
			stmt.setString(8, newGPU.getTime_end());
			
			stmt.executeUpdate();
			
			ResultSet generatedIdKey = stmt.getGeneratedKeys();
			generatedIdKey.next();
			
			return generatedIdKey.getLong(1);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 
	 * Updates a GPU in the database with new specifications with given parameter values
	 * then returns whether the update was successful with a boolean return (true = success)
	 * 
	 * @param	gpuID, updateGPU	The id and GPU variables to be updated
	 * 
	 * @return	boolean				Returns either true or false depending if the Update
	 * 								was successful
	 * 
	 * */
	public boolean updateGPUByID(String gpuID, GPU updateGPU) {
		
		String sql = "UPDATE gpu SET date_end = ?, time_end = ? WHERE id = " + gpuID;
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, updateGPU.getDate_end());
			stmt.setString(2, updateGPU.getTime_end());
			
			stmt.executeUpdate();
			stmt.close();
			
			return true;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
}







