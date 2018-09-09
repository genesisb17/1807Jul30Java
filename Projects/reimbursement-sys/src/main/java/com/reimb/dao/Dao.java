package com.reimb.dao;

import java.io.Serializable;
import java.util.List;

import com.reimb.pojos.Reimbursement;

public interface Dao<T, I extends Serializable> {
	List<T> findAll();
	List<T> getPast(T obj);
	List<T> getAll(T obj);
	List<T> findAll(T obj);
	List<T> getPend(T obj);
	List<T> getFnPend(T obj);
	T saveAnother(T obj);
	T findPw(T obj);
	T findOne(I id);
	T findOne(T obj);
	T insert(T obj);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
	default boolean isUnique(T obj) {
		return true;
	}
	
	
}