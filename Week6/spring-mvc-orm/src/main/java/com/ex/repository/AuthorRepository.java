package com.ex.repository;

import java.util.List;

import com.ex.beans.Author;

public interface AuthorRepository {
	
	List<Author> getAll();
	Author getById(int id);
	Author add(Author a);
	void update(Author a);

}