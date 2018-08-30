package com.iantimothyjohnson.notes.week5.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class SessionUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	private SessionUtil() {
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
