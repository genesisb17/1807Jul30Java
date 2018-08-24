package com.rev.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
		
	private ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties props = new Properties();
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(
					"application.properties"));	// different way to do this
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty(
					"usr"), props.getProperty("pwd"));
			return conn;
		} catch(SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Connection conn = ConnectionUtil.getConnection();
		System.out.println(conn);
	}

}
