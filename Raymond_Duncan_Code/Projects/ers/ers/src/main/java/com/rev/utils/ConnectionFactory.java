package com.rev.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory connectionFactory;

	private ConnectionFactory() {
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null)
			connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}

	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
//		String path = "src/main/resources/application.properties";
		String path = "resources\\application.properties";
		
		
		try {
//			prop.load(new FileReader(path));
//			Class.forName(prop.getProperty("driver"));
//			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"),
//					prop.getProperty("pwd"));
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", 
					"ers_database", 
					"admin");

//		} catch (IOException e) {
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
