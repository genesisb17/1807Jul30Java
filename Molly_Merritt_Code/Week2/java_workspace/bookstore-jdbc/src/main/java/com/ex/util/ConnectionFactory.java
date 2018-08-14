package com.ex.util;

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
	 * Uses *lazy* singleton design pattern as to return same single connection
	 * 	each time one is requested.
	 * In order to establish a connection, we need 4 things:
	 * 	Driver, URL (location of DB), username, password
	 */
	
	private static ConnectionFactory cf = null;	// lazy singleton instantiation
	private static Boolean build = true;	// do we need to build it? yes
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if (build) cf = new ConnectionFactory();
		return cf;
	}
	
	/*
	 * Connection
	 * 	- manages our connection to (session with) the database
	 * 	- allows us to execute SQL statements and return results
	 * 	- has information about DB tables, stored procedures, and
	 * 	  other details of the DB. use getMetaData() method
	 */
	
	public Connection getConnection() {
		Connection conn = null;	// will instantiate in a try block
		Properties prop = new Properties();
		String path = "/Users/mollymerritt/my_git_repos/1807Jul30Java/"
				+ "Molly_Merritt_Code/Week2/java_workspace/bookstore-jdbc/"
				+ "src/main/resources/application.properties";
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver"));
			/*The DriverManager provides a basic service for 
			 */
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"),
					prop.getProperty("pwd"));
					
		} catch (FileNotFoundException e) {
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
