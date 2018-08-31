package com.ex.util;

import org.hibernate.cfg.Configuration;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ConnectionUtil {
	
	private static SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public static Session getSession() {
		return sf.openSession();
	}

}
