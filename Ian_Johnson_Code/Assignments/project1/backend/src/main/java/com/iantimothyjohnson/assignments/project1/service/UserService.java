package com.iantimothyjohnson.assignments.project1.service;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.iantimothyjohnson.assignments.project1.dao.UserDAO;
import com.iantimothyjohnson.assignments.project1.exceptions.AuthenticationFailureException;
import com.iantimothyjohnson.assignments.project1.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.project1.exceptions.UsernameNotAvailableException;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.util.Passwords;

/**
 * A service class for working with users. This class abstracts over the DAO,
 * allowing different DAO backends to be used interchangeably (such as a mock
 * DAO for testing) with a higher level of abstraction.
 * 
 * @author Ian Johnson
 */
public class UserService {
    private static final Logger logger = LogManager.getLogger();

    private UserDAO userDao;

    /**
     * Constructs a new UserService with the given DAO backend.
     * 
     * @param userDao the DAO backend to use. This DAO will be used for all
     *                interactions between the UserService and the database.
     */
    public UserService(UserDAO userDao) {
        this.userDao = userDao;
    }

    /**
     * Attempts to create a new user from the given User object, using the given
     * password.
     * 
     * @param user     the User object corresponding to the new user. The ID and
     *                 password data of the object will be ignored and
     *                 overwritten with new values.
     * @param password the new user's password. Whether or not the user creation
     *                 is successful, this array will be cleared (every element
     *                 set to zero) before the method returns.
     * @throws UsernameNotAvailableException if the user's desired username is
     *                                       already in use by another user
     */
    public void create(User user, char[] password)
        throws UsernameNotAvailableException {
        if (userDao.selectByUsername(user.getUsername()) != null) {
            Arrays.fill(password, '\0');
            throw new UsernameNotAvailableException(user.getUsername());
        }
        byte[] passwordSalt = Passwords.generateSalt();
        user.setPasswordSalt(passwordSalt);
        byte[] passwordHash = Passwords.hashPassword(password, passwordSalt);
        user.setPasswordHash(passwordHash);
        Arrays.fill(password, '\0');
        if (!userDao.insert(user)) {
            logger.error("Could not insert new user into database.");
        }
    }

    /**
     * Gets a user by username. For getting a user object in the context of
     * logging that user in, use the login method in preference to this one.
     * 
     * @param username the username of the user to get
     * @return the user that was found
     * @throws UserNotFoundException if no user with the given username exists
     */
    public User get(String username) throws UserNotFoundException {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }
        return user;
    }

    /**
     * Attempts to log in the user with the given username and password. This
     * method does the same thing as the get method, but it also checks that the
     * correct password is supplied before returning the User.
     * 
     * @param username the username of the user to log in
     * @param password the (unhashed) password to be used for authentication.
     *                 Whether or not the login was successful, this array will
     *                 be cleared (every element set to zero) before the method
     *                 returns.
     * @return the User object corresponding to the logged-in user
     * @throws UserNotFoundException          if no user with the given username
     *                                        was found
     * @throws AuthenticationFailureException if the given password was
     *                                        incorrect for the user
     */
    public User login(String username, char[] password)
        throws UserNotFoundException, AuthenticationFailureException {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            Arrays.fill(password, '\0');
            throw new UserNotFoundException(username);
        }
        byte[] hashedPassword = Passwords.hashPassword(password,
            user.getPasswordSalt());
        Arrays.fill(password, '\0');
        if (!Arrays.equals(hashedPassword, user.getPasswordHash())) {
            throw new AuthenticationFailureException();
        }
        return user;
    }

    /**
     * Updates the information in the database for the given user.
     * 
     * @param user the user whose information to update
     */
    public void update(User user) {
        if (!userDao.update(user)) {
            logger.error("User was not updated properly.");
        }
    }
}
