package com.iantimothyjohnson.assignments.project1.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A singleton factory class for database connections.
 * 
 * @author Ian Johnson
 */
public class ConnectionFactory {
    private static final Logger logger = LogManager.getLogger();
    private static ConnectionFactory instance;

    /**
     * The database URL.
     */
    private String url;
    /**
     * The user for connecting to the database.
     */
    private String user;
    /**
     * The password for connecting to the database.
     */
    private String password;

    private ConnectionFactory() {
        Properties props = new Properties();
        try (Reader r = new InputStreamReader(
            getClass().getResourceAsStream("/application.properties"),
            "UTF-8")) {
            props.load(r);
            url = props.getProperty("url");
            if (url == null) {
                logger.fatal(
                    "Database URL not provided in application.properties.");
                System.exit(1);
            }
            user = props.getProperty("user");
            if (user == null) {
                logger.fatal(
                    "Database user not provided in application.properties.");
                System.exit(1);
            }
            password = props.getProperty("password");
            if (password == null) {
                logger.fatal(
                    "Database password not provided in application.properties.");
                System.exit(1);
            }
            // Load driver class.
            Class.forName(props.getProperty("driver"));
        } catch (IOException e) {
            logger.fatal("Could not read from application.properties file.", e);
            System.exit(1);
        } catch (ClassNotFoundException e) {
            logger.fatal("Could not load JDBC driver class.", e);
            System.exit(1);
        }
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    /**
     * Gets a connection to the database.
     * 
     * @return a connection to the database
     * @throws SQLException if a connection cannot be established
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
