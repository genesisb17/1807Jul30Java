package com.revature.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	/*
	 * Generates a connection for each process that needs one
	 * 	Implemented as a singleton...We don't need more than one connection factory!
	 */
	private static ConnectionFactory connectionFactory;
	private static boolean isInstantiated = false;

	private ConnectionFactory() {
		isInstantiated = true;
	}
	
	public synchronized static ConnectionFactory getInstance() {
		if(!isInstantiated) connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}
	
	public Connection getConnection() {
		Connection conn = null; //Used to hold the connection
		Properties prop = new Properties();
		String path = "src/main/resources/application.properties";
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"),
					prop.getProperty("pwd"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
