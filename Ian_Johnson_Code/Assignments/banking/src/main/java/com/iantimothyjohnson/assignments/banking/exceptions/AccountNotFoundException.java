package com.iantimothyjohnson.assignments.banking.exceptions;

public class AccountNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(int id) {
		super("Account with ID " + id + "could not be found.");
	}
}
