package com.revature.utils;

public class ConnectionFactory {
	/*
	 * Generates a connection for each process that needs one
	 * 	Implemented as a singleton...We don't need more than one connection factory!
	 */
	private static ConnectionFactory connectionFactory;
	private static boolean isInstantiated = false;

	private ConnectionFactory() {
		isInstantiated = true;
	}
	
	public ConnectionFactory getInstance() {
		if(!isInstantiated) connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}
}
