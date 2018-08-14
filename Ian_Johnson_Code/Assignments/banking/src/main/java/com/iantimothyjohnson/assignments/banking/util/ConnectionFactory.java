package com.iantimothyjohnson.assignments.banking.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A lazy singleton class that manages connections to the bank database.
 * 
 * @author Ian Johnson
 */
public class ConnectionFactory {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

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
			props.load(this.getClass().getResourceAsStream("/application.properties"));
			// We need to load the driver class so it can be used.
			Class.forName(props.getProperty("driver"));
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Could not access application.properties file.", e);
		} catch (ClassNotFoundException e) {
			LOGGER.log(Level.SEVERE, "Could not load Oracle JDBC driver.", e);
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
			LOGGER.log(Level.SEVERE, "Could not connect to database.", e);
		}
		return conn;
	}
}
