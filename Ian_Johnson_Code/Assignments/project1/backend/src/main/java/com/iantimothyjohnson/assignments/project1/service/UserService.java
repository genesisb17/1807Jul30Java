package com.iantimothyjohnson.assignments.project1.service;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.iantimothyjohnson.assignments.project1.dao.SQLUserDAO;
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
     * Constructs a new UserService with the default SQLUserDAO backend.
     * 
     * @param actor a User object corresponding to the user who can be thought
     *              of as "calling" the methods in this instance. This will be
     *              used to evaluate the user's permission to perform certain
     *              operations.
     * @throws IllegalArgumentException if the actor is null
     */
    public UserService(User actor) {
        this(actor, new SQLUserDAO());
    }

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
     * Gets a user by id. For getting a user object in the context of logging
     * that user in, use the login method in preference to this one.
     * 
     * @param id the id of the user to get
     * @return the user that was found
     * @throws PermissionDeniedException if the user is not a manager (who can
     *                                   retrieve all user information) or the
     *                                   same as the desired user
     * @throws UserNotFoundException     if no user with the given id exists
     */
    public User get(int id)
        throws PermissionDeniedException, UserNotFoundException {
        if (actor.getRole() != UserRole.MANAGER && actor.getId() != id) {
            throw new PermissionDeniedException(
                "Only managers are allowed to retrieve arbitrary user data.");
        }

        User user = userDao.selectById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return user;
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
     * Gets a list of all users in the database.
     * 
     * @return a list of all users in the database
     * @throws PermissionDeniedException if the actor is not a manager (who is
     *                                   allowed to see all user data)
     */
    public List<User> getAll() throws PermissionDeniedException {
        if (actor.getRole() != UserRole.MANAGER) {
            throw new PermissionDeniedException(
                "Only managers are allowed to retrieve arbitrary user data.");
        }
        return userDao.selectAll();
    }

    /**
     * Updates the information in the database for the given user. Note that
     * this method will not update the user's password; the password hash and
     * salt fields of the given user object will be ignored. To update a user's
     * password, use the updatePassword method.
     * 
     * @param user the user whose information to update
     * @throws PermissionDeniedException if the actor is not a manager and is
     *                                   not trying to update their own
     *                                   information or if an employee attempts
     *                                   to change their own role
     * @throws UserNotFoundException     if the given user object's ID does not
     *                                   correspond to any user in the database
     */
    public void update(User user)
        throws PermissionDeniedException, UserNotFoundException {
        if (actor.getRole() != UserRole.MANAGER
            && actor.getId() != user.getId()) {
            throw new PermissionDeniedException(
                "Only managers can update arbitrary user data.");
        }
        // Check to make sure employees don't elevate themselves to managers.
        if (actor.getRole() == UserRole.EMPLOYEE
            && user.getRole() != UserRole.EMPLOYEE) {
            throw new PermissionDeniedException(
                "Employees cannot elevate their own permissions.");
        }

        // We need to store the password fields from the original user object so
        // that we can replace them once we're done updating everything else
        // (the DAO would not ignore them, which is why we have to temporarily
        // set them to known values).
        User found = get(user.getId());
        byte[] oldHash = user.getPasswordHash();
        byte[] oldSalt = user.getPasswordSalt();
        user.setPasswordHash(found.getPasswordHash());
        user.setPasswordSalt(found.getPasswordSalt());

        if (!userDao.update(user)) {
            logger.error("User was not updated properly.");
        }

        // Restore the original hash and salt.
        user.setPasswordHash(oldHash);
        user.setPasswordSalt(oldSalt);
    }
    
    /**
     * Updates the given user's password, generating a new salt and computing the hash from it.
     * @param user the user whose password to update. The object will be updated to contain the new hash and salt upon success.
     * @param password the new (unhashed) password to use
     * @throws PermissionDeniedException if the given user is not the actor and the actor is not a manager
     * @throws UserNotFoundException if the given user does not correspond to a user in the database
     */
    public void updatePassword(User user, char[] password) throws PermissionDeniedException, UserNotFoundException {
        if (actor.getRole() != UserRole.MANAGER
            && actor.getId() != user.getId()) {
            throw new PermissionDeniedException(
                "Only managers can change an arbitrary user's password.");
        }
        
        byte[] salt = Passwords.generateSalt();
        byte[] hashed = Passwords.hashPassword(password, salt);
        // We should only update the user object upon success, so we need to
        // make a temporary object here for the update.
        User updated = new User(user);
        updated.setPasswordSalt(salt);
        updated.setPasswordHash(hashed);
        if (!userDao.update(updated)) {
            throw new UserNotFoundException(user.getId());
        }
        // Now we can update the original object.
        user.setPasswordSalt(salt);
        user.setPasswordHash(hashed);
    }
}
