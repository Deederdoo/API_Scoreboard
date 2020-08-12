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

		url = "jdbc:mysql://localhost:3306/scoreboarddb?autoReconnect=true&useSSL=false";
		username = "root";
		password = "password";
	}

	public Connection getConnection() throws SQLException {
		
		Connection conn = null;
		connectionLock.lock();
		
		System.out.println("Looking for Connection...");
		
		try {
			
			conn = DriverManager.getConnection(url, username, password);
			
		} finally {
			
			connectionLock.unlock();
		}

		System.out.println("Connected!");
		return conn;
	}
}
