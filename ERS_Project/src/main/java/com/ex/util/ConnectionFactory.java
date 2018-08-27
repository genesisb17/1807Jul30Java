package com.ex.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(build) cf = new ConnectionFactory();
		
		return cf;
	}
	
	// need a cf to make connection:
	public Connection getConnection() {
		Connection conn = null;
		
		Properties prop = new Properties();
		
		String path = "C:\\Users\\Benjamin Martin\\Documents\\1807Jul30Java\\ERS_Project\\src\\main\\resources\\application.properties";

		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver")); //prop.getproperty("Driver") is returning oracle.jdbc.driver.OracleDriver
		
			/* The DriverManager provides a basic service for managing a 
			 * set of JDBC drivers. As part of its initialization, the 
			 * DriverManager class will attempt to load the driver classes
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
