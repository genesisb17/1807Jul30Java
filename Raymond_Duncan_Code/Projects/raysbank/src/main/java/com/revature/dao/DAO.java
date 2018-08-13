package com.revature.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T,I extends Serializable> {
	List<T> getAll();
	T getOne(I id);
	T save(I id);
	T update(T obj);
	T delete(T obj);
	default boolean isUnique(T obj) {
		return true;
	}
	
	
}
