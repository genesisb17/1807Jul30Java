package com.iantimothyjohnson.notes.week2.bookstore.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, I extends Serializable> {
	List<T> findAll();

	T findOne(I id);

	T save(T obj);

	T update(T obj);

	void delete(T obj);

	default boolean isUnique(T obj) {
		return true;
	}
}
