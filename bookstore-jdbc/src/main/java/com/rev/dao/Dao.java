package com.rev.dao;

import java.io.Serializable;
import java.util.List;

<<<<<<< HEAD
import com.rev.pojos.Book;
=======
import com.rev.pojos.Author;
>>>>>>> 832b3e4fc4cf405de2df146fa3e42788f2589489
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
<<<<<<< HEAD
	List<Book> findAll();
=======
	List<Author> findAll();
>>>>>>> 832b3e4fc4cf405de2df146fa3e42788f2589489
}
