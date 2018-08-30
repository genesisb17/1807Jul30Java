package com.ex.dao;

import java.io.Serializable;
import java.util.List;

import com.ex.pojos.User;
import com.ex.pojos.UserInformation;

public interface Dao<T, I extends Serializable> {
	
	List<T> findAll();
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	boolean isUnique(T obj);
	
}