package com.iantimothyjohnson.assignments.banking.exceptions;

/**
 * An exception thrown when the user cannot login due to an incorrect password.
 * 
 * @author Ian Johnson
 */
public class AuthenticationFailureException extends Exception {
	private static final long serialVersionUID = 1L;

	public AuthenticationFailureException() {
		super("Incorrect password provided.");
	}
}
