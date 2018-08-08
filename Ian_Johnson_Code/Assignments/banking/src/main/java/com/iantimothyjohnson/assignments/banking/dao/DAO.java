package com.iantimothyjohnson.assignments.banking.dao;

import java.util.List;
import java.util.Optional;

/**
 * The basic DAO interface. A DAO is meant to read data from and write data to a
 * database; the design of this interface is meant to apply to any particular
 * type of object.
 * 
 * @author Ian Johnson
 * @param <T> The type of object that this DAO works with.
 */
public interface DAO<T> {
	List<T> findAll();

	Optional<T> findById(int id);
}
