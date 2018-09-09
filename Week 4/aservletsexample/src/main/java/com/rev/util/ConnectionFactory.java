package com.rev.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	//creating a singleton
	
	private static ConnectionFactory connectionFact;
	
	private ConnectionFactory() {
		super();
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties props = new Properties();
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("usr"),
					props.getProperty("pwd"));
			return conn;
		}catch(SQLException sql){
			System.out.println("SQL State: " + sql.getSQLState());
			System.out.println("Error Code: " + sql.getErrorCode());
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
		System.out.println(conn);
	}
}
