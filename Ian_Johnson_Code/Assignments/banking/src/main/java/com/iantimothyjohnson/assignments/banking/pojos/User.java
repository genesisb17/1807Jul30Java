package com.iantimothyjohnson.assignments.banking.pojos;

import java.io.Serializable;

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
	private byte[] passwordHash;
	/**
	 * The user's first name.
	 */
	private String firstName;
	/**
	 * The user's last name.
	 */
	private String lastName;

	public User() {
	}

	public User(int id, String username, byte[] passwordSalt, byte[] passwordHash, String firstName, String lastName) {
		this.id = id;
		this.username = username;
		this.passwordSalt = passwordSalt;
		this.passwordHash = passwordHash;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public byte[] getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(byte[] passwordHash) {
		this.passwordHash = passwordHash;
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
}
