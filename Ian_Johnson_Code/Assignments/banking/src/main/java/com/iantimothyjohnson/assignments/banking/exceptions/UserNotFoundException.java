package com.iantimothyjohnson.assignments.banking.exceptions;

/**
 * An exception thrown when the user specified by an operation could not be
 * found.
 * 
 * @author Ian Johnson
 */
public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(int id) {
		super("User with ID " + id + " could not be found.");
	}

	public UserNotFoundException(String username) {
		super("User " + username + " could not be found.");
	}
}
