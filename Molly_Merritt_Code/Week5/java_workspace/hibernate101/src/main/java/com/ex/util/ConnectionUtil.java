package com.ex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	
	private static SessionFactory sf =
			new Configuration().configure().buildSessionFactory();

			/*
				SESSION - represents your session with your database

				METHODS:
				- save
				- get
				- update
				- delete
				- beginTransaction
				- createQuery
				- createCriteria
			*/
	
	public static Session getSession() {
		System.out.println("opening session");
		return sf.openSession();
	}

}
