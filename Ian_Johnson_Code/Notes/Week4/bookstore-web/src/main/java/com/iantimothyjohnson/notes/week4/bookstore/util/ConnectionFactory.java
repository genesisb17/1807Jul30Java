package com.iantimothyjohnson.notes.week4.bookstore.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class used to establish a connection with DB. It uses the singleton design
 * pattern to return the same single connection each time one is requested. In
 * order to establish a connection, we need 4 things:
 * 
 * <ol>
 * <li>Driver</li>
 * <li>URL (location of DB)</li>
 * <li>Username</li>
 * <li>Password</li>
 * </ol>
 * 
 * @author Ian Johnson
 */
public class ConnectionFactory {
	// We're making a lazy singleton.
	private static ConnectionFactory cf;

	private ConnectionFactory() {
	}

	public static synchronized ConnectionFactory getInstance() {
		if (cf == null) {
			cf = new ConnectionFactory();
		}
		return cf;
	}

	public Connection getConnection() {
		Connection conn = null; // We will instantiate in a try block.
		Properties prop = new Properties();
		try {
			prop.load(getClass().getResourceAsStream("/application.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"),
					prop.getProperty("pwd"));
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
