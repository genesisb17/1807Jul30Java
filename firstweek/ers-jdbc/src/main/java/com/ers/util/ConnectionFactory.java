//package com.ers.util;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class ConnectionFactory {
//	private static ConnectionFactory cf = null;
//	private static Boolean build = true;
//	private ConnectionFactory() {
//		build = false;
//	}
//	public static synchronized ConnectionFactory getInstance() {
//		if(build) cf = new ConnectionFactory();
//		return cf;
//	}
//	
//	public Connection getConnection() {
//		Connection conn = null;
//		Properties prop = new Properties();
//		String path = "C://Users/Dylan/my_git_repo/1807Jul30Java/firstweek/ers-jdbc/src/main/resources/application.properties";
//		try {
//			prop.load(new FileReader(path));
//			Class.forName(prop.getProperty("driver"));
//			conn = DriverManager.getConnection( 
//					prop.getProperty("url"),
//					prop.getProperty("usr"),
//					prop.getProperty("pwd"));
//		
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return conn;
//					
//					
//					
//	}
//}
