package com.iantimothyjohnson.assignments.banking.service;

import java.util.Arrays;
import java.util.Optional;

import com.iantimothyjohnson.assignments.banking.dao.UserDAO;
import com.iantimothyjohnson.assignments.banking.exceptions.AuthenticationFailureException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserAlreadyExistsException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.banking.pojos.User;

public class SessionManager {
	/**
	 * The underlying DAO to use for data storage and retrieval.
	 */
	private UserDAO userDao;

	/**
	 * Constructs a SessionManager using the given underlying DAO.
	 * 
	 * @param dao The underlying DAO to be used for the low-level data operations.
	 */
	public SessionManager(UserDAO dao) {
		this.userDao = dao;
	}

	/**
	 * Logs in the user with the given username and password, returning the user's
	 * data.
	 * 
	 * @param username The username of the user to log in.
	 * @param password The password of the user to log in.
	 * @return The user's data.
	 * @throws UserNotFoundException          If no user with the specified username
	 *                                        exists.
	 * @throws AuthenticationFailureException If the given password was incorrect.
	 * @throws AlreadyLoggedInException       If the user was already logged in.
	 */
	public User login(String username, char[] password)
			throws UserNotFoundException, AuthenticationFailureException {
		Optional<User> potentialUser = userDao.findByUsername(username);
		if (!potentialUser.isPresent()) {
			throw new UserNotFoundException(username);
		}
		User user = potentialUser.get();

		// Compare hashed passwords.
		byte[] hashedPassword = Passwords.hashPassword(password, user.getPasswordSalt());
		if (!Arrays.equals(hashedPassword, user.getHashedPassword())) {
			throw new AuthenticationFailureException();
		}

		return user;
	}
	
	/**
	 * Logs the given user out, saving all changes to the database.
	 * 
	 * @param user The user to log out.
	 */
	public void logout(User user) {
	}

	/**
	 * Creates a user with the given initial data and password. This also logs
	 * in the new user.
	 * 
	 * @param user     The initial user data to associate with the user.
	 * @param password The password to use for the new user.
	 */
	public void createUser(User user, char[] password) throws UserAlreadyExistsException {
		// We need to generate a salt and then use that to hash the password.
		byte[] salt = Passwords.generateSalt();
		byte[] hashedPassword = Passwords.hashPassword(password, salt);
		// Now, we can create the user.
		// dao.createUser(user, hashedPassword, salt);
	}
}
