package com.iantimothyjohnson.assignments.banking.exceptions;

public class AccountAlreadyOwnedByUserException extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountAlreadyOwnedByUserException(int accountId, int userId) {
		super("Account ID " + accountId + " is already owned by user with ID " + userId + ".");
	}
}
