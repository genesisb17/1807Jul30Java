package com.ex.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, I extends Serializable> {	// I = identifying object
	
	List<T> findAll();
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
	default boolean isUnique(T obj) {
		// want to quickly validate but don't need some special method (?)
		return true;
	}

}
