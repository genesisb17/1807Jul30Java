package com.revature;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	/*
	 * Class used to establish a connection with DB
	 * Uses singleton design pattern as to return
	 * 	same single connection each time one is requested.
	 * In order to establish a connection, we need 4
	 * things: Driver, URL (location of DB), username, pw
	 */
	
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(build) cf = new ConnectionFactory();
		return cf;
	}
	/*
	 * Connections
	 * - manages our connection to (session with) the database
	 * - allows us to execute SQL statements and return results
	 * - has information about DB tables, stored procedures, and other
	 * 	details of the DB. use getMetaData() method
	 */
	public Connection getConnection() {
		Connection conn = null; //Will instantiate in a try block
		Properties prop = new Properties();
		String path = "C:/Users/Sammy/my_git_repos/1807Jul30Java/Week2/JDBC/bookstore-jdbc/src/main/resources/application.properties";
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver")); //prop.get
			/* The DriverManager provides a basic service for
			 * set of JDC drivers. As part of its initialization
			 * DriverManager class will attempt to load the driver
			 * referenced in the jdbc.drivers system properly
			 */
			conn = DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("usr"),
					prop.getProperty("pwd"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
