package servletExample.util;

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
		try {Properties prop = new Properties();
		prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"), prop.getProperty("password"));
		return conn;
	} catch (SQLException sql) {
		System.err.println("SQL STATE:" + sql.getSQLState() + sql.getErrorCode());
	} catch (IOException e) {
		e.printStackTrace();
	}
		return null;
	}
	
	public static void main(String[] args) {
		Connection conn =  ConnectionUtil.getConnection();
		System.out.println(conn);
	}
}


