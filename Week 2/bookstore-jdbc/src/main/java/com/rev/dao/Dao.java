package com.rev.dao;

import java.io.Serializable;
import java.util.List;

import com.rev.pojos.Book;

public interface Dao<T, I extends Serializable> {
	List<T> getAll();
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	boolean isUnique(T obj);
}
