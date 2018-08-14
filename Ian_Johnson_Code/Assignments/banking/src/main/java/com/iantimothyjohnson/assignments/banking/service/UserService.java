package com.iantimothyjohnson.assignments.banking.service;

import java.util.List;
import java.util.stream.Collectors;

import com.iantimothyjohnson.assignments.banking.dao.UserAccountDAO;
import com.iantimothyjohnson.assignments.banking.dao.UserDAO;
import com.iantimothyjohnson.assignments.banking.exceptions.UserAlreadyExistsException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.banking.pojos.Account;
import com.iantimothyjohnson.assignments.banking.pojos.User;

/**
 * A singleton service for accessing User data from the database, abstracting
 * over the low-level details of the DAO.
 * 
 * @author Ian Johnson
 */
public final class UserService {
	private static UserService instance;

	private UserAccountDAO userAccountDao;
	private UserDAO userDao;

	private UserService() {
		userAccountDao = new UserAccountDAO();
		userDao = new UserDAO();
	}

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	/**
	 * Looks up a user by username.
	 * 
	 * @param username The username of the user to find.
	 * @return The User object corresponding to the found user.
	 * @throws UserNotFoundException If no user with the given username was found.
	 */
	public User findByUsername(String username) throws UserNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UserNotFoundException(username);
		}
		return user;
	}

	/**
	 * Finds all the owners of the given account.
	 * 
	 * @param account The account whose owners to find.
	 * @return A list of all the owners of the account, as User objects.
	 */
	public List<User> findAllForAccount(Account account) {
		// Here we use the functional "map" operation on the user ID list to
		// turn it into a list of actual user objects.
		return userAccountDao.findUsersForAccount(account.getId()).stream().map(userId -> userDao.findById(userId))
				.collect(Collectors.toList());
	}

	/**
	 * Deletes a user from the database.
	 * 
	 * @param user The user to delete.
	 * @throws UserNotFoundException If the given user was not already present in
	 *                               the database.
	 */
	public void delete(User user) throws UserNotFoundException {
		userAccountDao.disassociateAllForUser(user.getId());
		if (!userDao.delete(user.getId())) {
			throw new UserNotFoundException(user.getId());
		}
	}

	/**
	 * Inserts a new user into the database.
	 * 
	 * @param user The user to insert.
	 * @throws UserAlreadyExistsException If a user with the same username already
	 *                                    existed in the database.
	 */
	public void insert(User user) throws UserAlreadyExistsException {
		if (!userDao.insert(user)) {
			throw new UserAlreadyExistsException(user.getUsername());
		}
	}

	/**
	 * Checks whether the given username is available.
	 * 
	 * @param username The username to check.
	 * @return Whether the username is available for a new user to use.
	 */
	public boolean isUsernameAvailable(String username) {
		return userDao.findByUsername(username) == null;
	}

	/**
	 * Updates a user's information in the database.
	 * 
	 * @param user The user to update.
	 * @throws UserNotFoundException If no user with the given ID already exists.
	 */
	public void update(User user) throws UserNotFoundException {
		if (!userDao.update(user)) {
			throw new UserNotFoundException(user.getId());
		}
	}
}
