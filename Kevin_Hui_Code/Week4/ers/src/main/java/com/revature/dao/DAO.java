package com.revature.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, I extends Serializable> {
	List<T> findAll();
	T findOne(I id);
	T insert(T obj);
	T update(T obj);
	void delete(T obj);
}
