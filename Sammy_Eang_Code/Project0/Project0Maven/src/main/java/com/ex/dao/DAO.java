package com.ex.dao;

import java.io.Serializable;
import java.util.List;

//interface saying what all dao's should do
public interface DAO<T, I extends Serializable> {

	//there should be a function to retrieve all
	List<T> findAll();
	//as well as a function to insert a new row
	T save(T obj);
	
}
