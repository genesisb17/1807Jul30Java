package com.rev.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T,I extends Serializable> {
	
	public List<T> getAll();
	public T getOne(I i);
	public T save(T t);

}
