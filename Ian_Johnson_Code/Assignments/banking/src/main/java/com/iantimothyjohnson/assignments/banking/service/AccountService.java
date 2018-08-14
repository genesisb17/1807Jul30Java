package com.iantimothyjohnson.assignments.banking.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.iantimothyjohnson.assignments.banking.dao.AccountDAO;
import com.iantimothyjohnson.assignments.banking.dao.UserAccountDAO;
import com.iantimothyjohnson.assignments.banking.dao.UserDAO;
import com.iantimothyjohnson.assignments.banking.exceptions.AccountAlreadyOwnedByUserException;
import com.iantimothyjohnson.assignments.banking.exceptions.AccountNotFoundException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.banking.pojos.Account;
import com.iantimothyjohnson.assignments.banking.pojos.User;

/**
 * A singleton service for accessing account information, abstracting over the
 * DAO.
 * 
 * @author Ian Johnson
 */
public final class AccountService {
	private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

	private static AccountService instance;

	private UserAccountDAO userAccountDao;
	private UserDAO userDao;
	private AccountDAO accountDao;

	private AccountService() {
		userAccountDao = new UserAccountDAO();
		userDao = new UserDAO();
		accountDao = new AccountDAO();
	}

	public static AccountService getInstance() {
		if (instance == null) {
			instance = new AccountService();
		}
		return instance;
	}

	/**
	 * Adds a new owner to the given account. This will not affect any of the
	 * previous owners of the account; they will remain owners.
	 * 
	 * @param account The account to which to add the new owner.
	 * @param owner   The new owner of the account.
	 */
	public void addOwnerToAccount(Account account, User owner)
			throws UserNotFoundException, AccountNotFoundException, AccountAlreadyOwnedByUserException {
		userAccountDao.associate(owner.getId(), account.getId());
	}

	/**
	 * Adds a new owner to the given account. This will not affect any of the
	 * previous owners of the account; they will remain owners.
	 * 
	 * @param account       The account to which to add the new owner.
	 * @param ownerUsername The username of the new owner of the account.
	 */
	public void addOwnerToAccount(Account account, String ownerUsername)
			throws UserNotFoundException, AccountNotFoundException, AccountAlreadyOwnedByUserException {
		User owner = userDao.findByUsername(ownerUsername);
		if (owner != null) {
			addOwnerToAccount(account, owner);
		} else {
			throw new UserNotFoundException(ownerUsername);
		}
	}

	/**
	 * Finds all accounts belonging to the given user.
	 * 
	 * @param user The user whose accounts to find.
	 * @return A list of all the user's accounts, as Account objects.
	 */
	public List<Account> findAllForUser(User user) {
		return userAccountDao.findAccountsForUser(user.getId()).stream()
				.map(accountId -> accountDao.findById(accountId)).collect(Collectors.toList());
	}

	/**
	 * Deletes an account from the database.
	 * 
	 * @param account The account to delete.
	 * @throws AccountNotFoundException If the given account was not already present
	 *                                  in the database.
	 */
	public void delete(Account account) throws AccountNotFoundException {
		userAccountDao.disassociateAllForAccount(account.getId());
		if (!accountDao.delete(account.getId())) {
			throw new AccountNotFoundException(account.getId());
		}
	}

	/**
	 * Inserts a new account into the database, initially belonging to the given
	 * user.
	 * 
	 * @param account The account to insert into the database. The ID property of
	 *                the account will be overwritten by the ID given to the new
	 *                account row in the database.
	 * @param owner   The user who is the initial owner of the account.
	 */
	public void insert(Account account, User owner) throws UserNotFoundException {
		accountDao.insert(account);
		try {
			addOwnerToAccount(account, owner);
		} catch (AccountNotFoundException | AccountAlreadyOwnedByUserException e) {
			LOGGER.log(Level.SEVERE, "Could not add owner to new account.", e);
		}
	}

	/**
	 * Updates an account already present in the database.
	 * 
	 * @param account The account to update.
	 * @throws AccountNotFoundException If the given account's ID did not match that
	 *                                  of any account already in the database.
	 */
	public void update(Account account) throws AccountNotFoundException {
		if (!accountDao.update(account)) {
			throw new AccountNotFoundException(account.getId());
		}
	}
}
