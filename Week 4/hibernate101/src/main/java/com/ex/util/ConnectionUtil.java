package com.ex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	
	//gets our one sessionfactory instance
	private static SessionFactory sf = 
			new Configuration().configure().buildSessionFactory();
	
	//opens the session from this session factory
	public static Session getSession() {
		return sf.openSession();
	}

}
