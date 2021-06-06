package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public enum ConnectionManager {

	INSTANCE;

	private Lock connectionLock = new ReentrantLock();
	private String url, username, password;

	ConnectionManager() {

		//jdbc:mysql://localhost:3306/scoreboarddb?autoReconnect=true&useSSL=false
		username = ""; //root
		password = ""; //password
	}

	/**
	 * 
	 * Creates a connection to desired database by passing the database name
	 * through the parameters and function locks threads to only allow one
	 * to create the connection
	 * 
	 * @param	database	String holding database name to be used for connection
	 * @return	conn		Return Connection to the database
	 * 
	 * */
	public Connection getConnection(String database) throws SQLException, ClassNotFoundException {
		
		Connection conn = null;
		connectionLock.lock();
		
		System.out.println("Looking for Connection...");
		
		try {
			
			url = "jdbc:mysql://ip****:3306/"+ database 
					+ "?autoReconnect=true&useJDBCCompliantTimezoneShift"
					+ "=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, username, password);
			
		} finally {
			
			connectionLock.unlock();
		}
		
		return conn;
	}
}
