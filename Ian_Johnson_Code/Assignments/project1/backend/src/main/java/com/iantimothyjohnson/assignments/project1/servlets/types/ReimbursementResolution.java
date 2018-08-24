package com.iantimothyjohnson.assignments.project1.servlets.types;

/**
 * A class containing the information needed to resolve a reimbursement. It is
 * indended to be deserialized from JSON input.
 * 
 * @author Ian Johnson
 */
public class ReimbursementResolution {
    private int id;
    private boolean approved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
