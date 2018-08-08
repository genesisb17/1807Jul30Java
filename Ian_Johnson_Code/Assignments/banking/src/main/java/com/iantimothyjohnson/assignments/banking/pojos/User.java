package com.iantimothyjohnson.assignments.banking.pojos;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * A class representing a user of the bank. Note that this is not the same as an
 * Account; a User may have any number of Accounts.
 * 
 * @author Ian Johnson
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The user id number.
	 */
	private int id;
	/**
	 * The user's username. Unlike the user's name, the username must be unique
	 * among all other usernames.
	 */
	private String username;
	/**
	 * The salt for the user's password.
	 */
	private byte[] passwordSalt;
	/**
	 * The user's hashed password.
	 */
	private byte[] hashedPassword;
	/**
	 * The user's first name.
	 */
	private String firstName;
	/**
	 * The user's last name.
	 */
	private String lastName;
	/**
	 * The user's accounts.
	 */
	private List<Account> accounts;

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public byte[] getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public byte[] getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(byte[] hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the user's accounts. This returns an unmodifiable view of the account
	 * list, so that changes to the list do not affect the list stored in the user
	 * data, but changes to individual accounts *will* be reflected in the
	 * corresponding accounts of this user.
	 * 
	 * @return The user's accounts.
	 */
	public List<Account> getAccounts() {
		return Collections.unmodifiableList(accounts);
	}
}
