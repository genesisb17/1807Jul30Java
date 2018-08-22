package com.iantimothyjohnson.assignments.project1.service;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.iantimothyjohnson.assignments.project1.dao.UserDAO;
import com.iantimothyjohnson.assignments.project1.exceptions.PermissionDeniedException;
import com.iantimothyjohnson.assignments.project1.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.project1.exceptions.UsernameNotAvailableException;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.pojos.UserRole;
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

    /**
     * The user "performing" the calls to these methods (so that permissions can
     * be checked accordingly).
     */
    private User actor;
    private UserDAO userDao;

    /**
     * Constructs a new UserService with the given DAO backend.
     * 
     * @param actor   a User object corresponding to the user who can be thought
     *                of as "calling" the methods in this instance. This will be
     *                used to evaluate the user's permission to perform certain
     *                operations.
     * @param userDao the DAO backend to use. This DAO will be used for all
     *                interactions between the UserService and the database.
     * @throws IllegalArgumentException if either actor or userDao is null
     */
    public UserService(User actor, UserDAO userDao) {
        if (actor == null) {
            throw new IllegalArgumentException("actor must not be null.");
        }
        if (userDao == null) {
            throw new IllegalArgumentException("userDao must not be null.");
        }
        this.actor = actor;
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
     * @throws PermissionDeniedException     if the actor is not a manager (only
     *                                       managers can create accounts)
     * @throws UsernameNotAvailableException if the user's desired username is
     *                                       already in use by another user
     */
    public void create(User user, char[] password)
        throws PermissionDeniedException, UsernameNotAvailableException {
        if (actor.getRole() != UserRole.MANAGER) {
            throw new PermissionDeniedException(
                "Only managers can create users.");
        }

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
     * @throws PermissionDeniedException if the user is not a manager (who can
     *                                   retrieve all user information) or the
     *                                   same as the desired user
     * @throws UserNotFoundException     if no user with the given username
     *                                   exists
     */
    public User get(String username)
        throws PermissionDeniedException, UserNotFoundException {
        if (actor.getRole() != UserRole.MANAGER
            && !actor.getUsername().equals(username)) {
            throw new PermissionDeniedException(
                "Only managers are allowed to retrieve arbitrary user data.");
        }

        User user = userDao.selectByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }
        return user;
    }

    /**
     * Updates the information in the database for the given user.
     * 
     * @param user the user whose information to update
     * @throws PermissionDeniedException if the actor is not a manager and is
     *                                   not trying to update their own
     *                                   information
     */
    public void update(User user) throws PermissionDeniedException {
        if (actor.getRole() != UserRole.MANAGER
            && actor.getId() != user.getId()) {
            throw new PermissionDeniedException(
                "Only managers can update arbitrary user data.");
        }

        if (!userDao.update(user)) {
            logger.error("User was not updated properly.");
        }
    }
}
