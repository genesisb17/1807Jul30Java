package com.iantimothyjohnson.assignments.project1.pojos;

/**
 * An interface that represents a type that can be (deeply) copied. Implementors
 * must ensure that the copy operation is a deep copy, although this constraint
 * cannot be enforced programmatically.
 * 
 * This interface is a work-around that fixes two problems:
 * 
 * <ol>
 * <li>Java's built-in clone method and Cloneable interface are broken.</li>
 * <li>Abstraction and constructors don't mix (you can't make an interface
 * specifying that a class has a copy constructor).</li>
 * </ol>
 * 
 * @author Ian Johnson
 * @param <T> the type of the implementing class (it is another limitation of
 *        Java generics that this can't be enforced programmatically)
 */
public interface Copiable<T> {
    /**
     * Performs a deep copy of the object.
     * 
     * @return a deep copy of the object
     */
    T copy();
    
    /**
     * Deeply copies the given object's state into the caller.
     * 
     * @param obj the object from which to copy
     */
    void copyFrom(T obj);
}
