package com.example.repository;

import java.util.List;

import com.example.beans.Author;

public interface AuthorRepository {
	List<Author> getAll();
	Author getById(int id);
	Author getBooks(Author a);

}
