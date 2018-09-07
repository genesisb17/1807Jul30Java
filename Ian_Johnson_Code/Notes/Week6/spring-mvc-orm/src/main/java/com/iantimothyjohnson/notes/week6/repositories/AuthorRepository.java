package com.iantimothyjohnson.notes.week6.repositories;

import java.util.List;

import com.iantimothyjohnson.notes.week6.beans.Author;

public interface AuthorRepository {
	List<Author> getAll();

	Author getById(int id);

	Author add(Author a);

	void update(Author a);
}
