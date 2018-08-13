package com.iantimothyjohnson.assignments.banking.service;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.iantimothyjohnson.assignments.banking.exceptions.AuthenticationFailureException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserAlreadyExistsException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.banking.pojos.User;
import com.iantimothyjohnson.assignments.banking.util.Passwords;

public final class SessionManager {
	private static final Logger LOGGER = Logger.getLogger(SessionManager.class.getName());

	private static SessionManager instance;

	private SessionManager() {
	}

	public static SessionManager getInstance() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
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
	public User login(String username, char[] password) throws UserNotFoundException, AuthenticationFailureException {
		User user = UserService.getInstance().findByUsername(username);

		// Compare hashed passwords.
		byte[] hashedPassword = Passwords.hashPassword(password, user.getPasswordSalt());
		if (!Arrays.equals(hashedPassword, user.getPasswordHash())) {
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
		try {
			UserService.getInstance().update(user);
		} catch (UserNotFoundException e) {
			LOGGER.log(Level.SEVERE, "Attempted to log out a non-existent user.", e);
		}
	}

	/**
	 * Creates a new user with the given initial data and password. This also logs
	 * in the new user, returning the updated user object.
	 * 
	 * @param user     The initial user data to associate with the user. The object
	 *                 will be updated with new data generated during the creation
	 *                 process (password salt, hash and user ID).
	 * @param password The password to use for the new user. A salt will be
	 *                 generated and the password hashed, and the given user object
	 *                 will be updated to contain the salt and hash.
	 * @return The updated user object. Note that this will be the same object that
	 *         was passed into the method; the return is only for convenience and
	 *         consistency with the login method.
	 */
	public User createUser(User user, char[] password) throws UserAlreadyExistsException {
		// We need to generate a salt and then use that to hash the password.
		byte[] salt = Passwords.generateSalt();
		byte[] passwordHash = Passwords.hashPassword(password, salt);
		// Now, we can create the user.
		user.setPasswordSalt(salt);
		user.setPasswordHash(passwordHash);
		UserService.getInstance().insert(user);

		// The user object has been updated with all the relevant data at this
		// point.
		return user;
	}
}
