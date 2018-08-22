package com.iantimothyjohnson.assignments.project1.exceptions;

/**
 * An exception thrown when a user attempts to perform an operation that they
 * are unable to perform due to a lack of permissions.
 * 
 * @author Ian Johnson
 */
public class PermissionDeniedException extends Exception {
    private static final long serialVersionUID = 1L;

    public PermissionDeniedException(String message) {
        super(message);
    }
}
