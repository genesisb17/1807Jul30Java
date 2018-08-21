package com.iantimothyjohnson.assignments.project1.exceptions;

public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(int id) {
        super("User with ID " + id + " does not exist.");
    }
    
    public UserNotFoundException(String username) {
        super("User " + username + " does not exist.");
    }
}
