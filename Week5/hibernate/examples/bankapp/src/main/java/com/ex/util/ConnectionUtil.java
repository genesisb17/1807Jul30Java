package com.ex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConnectionUtil {

	private static ConnectionUtil cu;
	private SessionFactory sessionFactory;

	public synchronized static ConnectionUtil getInstance() {
		if (cu == null) {
			cu = new ConnectionUtil();
		}
		return cu;
	}

	public synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration hibConfiguration = new Configuration().configure();

			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(hibConfiguration.getProperties()).buildServiceRegistry();

			sessionFactory = hibConfiguration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}

	public Session getSession() {
		return this.getSessionFactory().openSession();
	}

}
