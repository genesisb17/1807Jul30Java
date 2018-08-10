package com.rev.dao;

import java.io.Serializable;
import java.util.List;

import com.rev.pojos.Author;
import com.rev.pojos.Genre;

public interface Dao<T, I extends Serializable> {
	List<T> getAll();
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
	default boolean isUnique(T obj) {
		return true;
	}
	List<Author> findAll();
}
