package com.iantimothyjohnson.assignments.banking.exceptions;

/**
 * An exception thrown when trying to create a user with a username that is
 * already in use.
 * 
 * @author Ian Johnson
 */
public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String username) {
		super("User " + username + " already exists.");
	}
}
