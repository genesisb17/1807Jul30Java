package com.iantimothyjohnson.notes.week6.repositories;

import java.util.List;

import com.iantimothyjohnson.notes.week6.beans.Book;

public interface BookRepository {
	List<Book> getAll();
	
	Book getById(int id);
	
	Book add(Book b);
	
	void update(Book b);
}
