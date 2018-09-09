package com.ex.exceptions;

import java.sql.SQLException;

public class BankExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public BankExceptions(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BankExceptions(String message) {
		super(message);
		
	}

	public BankExceptions(SQLException message) {
		super(message);
		
	}
	
}