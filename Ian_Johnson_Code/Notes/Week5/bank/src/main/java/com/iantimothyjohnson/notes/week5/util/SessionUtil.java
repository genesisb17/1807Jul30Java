package com.iantimothyjohnson.notes.week5.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class SessionUtil {
	private static SessionFactory sessionFactory;

	private SessionUtil() {
	}

	public static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration hibConfiguration = new Configuration().configure();

			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(hibConfiguration.getProperties()).buildServiceRegistry();

			sessionFactory = hibConfiguration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
