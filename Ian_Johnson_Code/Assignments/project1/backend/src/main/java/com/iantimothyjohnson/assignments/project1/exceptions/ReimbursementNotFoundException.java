package com.iantimothyjohnson.assignments.project1.exceptions;

/**
 * An exception thrown when a requested reimbursement could not be found.
 * 
 * @author Ian Johnson
 */
public class ReimbursementNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public ReimbursementNotFoundException(int id) {
        super("Reimbursement with ID " + id + " does not exist.");
    }
}
