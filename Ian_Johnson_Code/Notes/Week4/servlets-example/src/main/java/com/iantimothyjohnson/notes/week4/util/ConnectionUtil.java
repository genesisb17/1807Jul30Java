package com.iantimothyjohnson.notes.week4.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.iantimothyjohnson.notes.week4.dao.UserDao;
import com.iantimothyjohnson.notes.week4.dao.UserDaoImpl;
import com.iantimothyjohnson.notes.week4.pojos.User;

public class ConnectionUtil {
	private ConnectionUtil() {
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties props = new Properties();
			props.load(ConnectionUtil.class.getResourceAsStream("/application.properties"));
			Class.forName(props.getProperty("driver"));
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		UserDao dao = new UserDaoImpl();
		System.out.println(dao.getPasswordHash(new User("ianprime0509", "password")));
	}
}
