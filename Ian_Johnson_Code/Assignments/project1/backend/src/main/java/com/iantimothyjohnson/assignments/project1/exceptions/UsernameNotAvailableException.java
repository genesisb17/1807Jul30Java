package com.iantimothyjohnson.assignments.project1.exceptions;

/**
 * An exception thrown when a new user attempts to use a username that is
 * already in use by another user.
 * 
 * @author Ian Johnson
 */
public class UsernameNotAvailableException extends Exception {
    private static final long serialVersionUID = 1L;

    public UsernameNotAvailableException(String username) {
        super("Username " + username + " is already used by another user.");
    }
}
