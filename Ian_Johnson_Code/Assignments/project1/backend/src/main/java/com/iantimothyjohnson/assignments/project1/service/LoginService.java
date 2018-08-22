package com.iantimothyjohnson.assignments.project1.service;

import java.util.Arrays;

import com.iantimothyjohnson.assignments.project1.dao.UserDAO;
import com.iantimothyjohnson.assignments.project1.exceptions.AuthenticationFailureException;
import com.iantimothyjohnson.assignments.project1.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.util.Passwords;

/**
 * A service class for logging users in and out.
 * 
 * @author Ian Johnson
 */
public class LoginService {
    private UserDAO userDao;
    
    public LoginService(UserDAO userDao) {
        if (userDao == null) {
            throw new IllegalArgumentException("userDao must not be null.");
        }
        this.userDao = userDao;
    }

    /**
     * Attempts to log in the user with the given username and password.
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
}
