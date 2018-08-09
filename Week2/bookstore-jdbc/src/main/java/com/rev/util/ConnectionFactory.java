package com.rev.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	/*
	 * class used to establish a conn with DB. Uses singleton design patter as to 
	 * return same single conn each time one is requested
	 * in order to establish, we need 4 things: Driver, URL (location of DB),
	 * username, and password.
	 * 
	 * application.properties- has configuration details outside of code to prevent
	 * publishing to the web
	 */
	
	private static ConnectionFactory cf = null; //lazy singleton
	private static Boolean build = true;
	
	//constructor
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() { //replacement for constructor
		//returning instance of a class itself. you only have 1 instance of connectionFactory
		if(build) cf = new ConnectionFactory();
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null; //we will instantiate in a try block making it block scope so we have to declare
		//it outside of the scope
		Properties prop = new Properties();
		String path = "C:/Users/tmacd/Documents/_repos/"+
				"1807Jul30Java/Week2/bookstore-jdbc/src/main/resources/application.properties";
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver"));
			/*
			 * The DriverManager provides a basic service for managing a set of JDBC
			 * drivers. As a part of its initialization
			 * DriverManager class will attempt to load the driver
			 * referenced in the jdbc.drivers system property
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
