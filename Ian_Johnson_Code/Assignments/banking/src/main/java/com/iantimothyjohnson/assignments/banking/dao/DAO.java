package com.iantimothyjohnson.assignments.banking.dao;

import java.util.List;
import java.util.Optional;

/**
 * The basic DAO interface. A DAO is meant to read data from and write data to a
 * database; the design of this interface is meant to apply to any particular
 * type of object that has a unique numeric ID.
 * 
 * @author Ian Johnson
 * @param <T> The type of object that this DAO works with.
 */
public interface DAO<T> {
	/**
	 * Represents a transaction in progress on a particular element. While a
	 * transaction is taking place, no other transactions can be started on the
	 * same element.
	 * 
	 * @author Ian Johnson
	 *
	 * @param <T> The type of the element.
	 */
	abstract class Transaction<T> {
		private int id;

		protected Transaction(int id) {
			this.id = id;
		}
		
		public int getId() {
			return id;
		}
	}

	List<T> findAll();

	Optional<T> findById(int id);
}
