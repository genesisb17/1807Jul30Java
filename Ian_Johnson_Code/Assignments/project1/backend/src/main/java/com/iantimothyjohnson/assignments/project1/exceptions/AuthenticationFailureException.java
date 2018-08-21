package com.iantimothyjohnson.assignments.project1.exceptions;

public class AuthenticationFailureException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public AuthenticationFailureException() {
        super("Given password is incorrect.");
    }
}
