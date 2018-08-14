package com.iantimothyjohnson.assignments.banking.dao;

import java.util.List;

/**
 * An interface providing the basic structure of a DAO. Concrete DAO classes
 * that implement this interface may provide their own methods tailored for
 * accessing objects of their own type. Users should generally use those
 * concrete classes in preference to this interface unless they are sure that
 * they will only need the methods of this interface. In other words, this
 * interface exists primarily for ensuring structure and consistency, and not to
 * take advantage of polymorphism.
 * 
 * @author Ian Johnson
 *
 * @param <T> The type of object this DAO is specialized to access.
 */
public interface DAO<T> {
	/**
	 * Finds all objects in the database with which this DAO is specialized to work.
	 * 
	 * @return A list of all objects found.
	 */
	List<T> findAll();

	/**
	 * Finds a single object in the database by ID.
	 * 
	 * @param id The ID of the object to find.
	 * @return The object found, or null if no object exists with the given ID.
	 */
	T findById(int id);
	
	/**
	 * Deletes a single object from the database.
	 * 
	 * @param id The ID of the object to delete.
	 * @return Whether the object was actually deleted (false if e.g. there was
	 * no object with that ID or if constraints would have been violated).
	 */
	boolean delete(int id);

	/**
	 * Inserts a single new object in the database. Implementors of this interface
	 * should update the object so that its ID member is set to whatever ID is
	 * generated for it in the database.
	 * 
	 * @param obj The object to insert.
	 * @return Whether the insertion was successful.
	 */
	boolean insert(T obj);

	/**
	 * Updates the object in the database corresponding to the given object.
	 * 
	 * @param obj The object to update. The object must have some way of identifying
	 *            itself with a unique element in the database (e.g. an ID member).
	 * @return Whether the update was successful.
	 */
	boolean update(T obj);
}
