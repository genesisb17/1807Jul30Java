package com.iantimothyjohnson.assignments.project1.pojos;

/**
 * An interface representing something that can be identified by an int-valued
 * ID, and whose ID can be set.
 * 
 * @author Ian Johnson
 */
public interface Identifiable {
    /**
     * Gets the ID of this object.
     * 
     * @return the object's ID
     */
    int getId();
    
    /**
     * Sets the ID of this object.
     * 
     * @param id the object's new ID
     */
    void setId(int id);
}
