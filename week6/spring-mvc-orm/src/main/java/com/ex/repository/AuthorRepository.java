package com.ex.repository;

import java.util.List;

import com.ex.beans.Author;

public interface AuthorRepository {
	List<Author> getAll();
	Author getById(int id);
	Author getBooks(Author a);
	Author add(Author a);

}
