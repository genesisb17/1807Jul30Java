package com.iantimothyjohnson.assignments.banking.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A lazy singleton class that manages connections to the bank database.
 * 
 * @author Ian Johnson
 */
public class ConnectionFactory {
	/**
	 * The path to the application.properties file where the database connection
	 * info is stored.
	 */
	private static final String PROPERTIES_PATH = "src/main/resources/application.properties";
	/**
	 * The single instance of this class, lazily instantiated.
	 */
	private static ConnectionFactory instance;

	private String url;
	private String user;
	private String password;

	private ConnectionFactory() {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream(PROPERTIES_PATH));
			// We need to load the driver class so it can be used.
			Class.forName(props.getProperty("driver"));
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
		} catch (IOException e) {
			System.err.println("Could not access properties file:");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Could not load Oracle database driver:");
			e.printStackTrace();
		}
	}

	public static synchronized ConnectionFactory getInstance() {
		if (instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("Could not connect to database:");
			e.printStackTrace();
		}
		return conn;
	}
}
