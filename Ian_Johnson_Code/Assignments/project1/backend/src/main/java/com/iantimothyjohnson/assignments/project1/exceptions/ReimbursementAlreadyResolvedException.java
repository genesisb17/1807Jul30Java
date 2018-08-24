package com.iantimothyjohnson.assignments.project1.exceptions;

/**
 * An exception thrown when a user attempts to resolve a reimbursement that is
 * already resolved.
 * 
 * @author Ian Johnson
 */
public class ReimbursementAlreadyResolvedException extends Exception {
    private static final long serialVersionUID = 1L;

    public ReimbursementAlreadyResolvedException(int id) {
        super("Reimbursement with ID " + id + " is already resolved.");
    }
}
