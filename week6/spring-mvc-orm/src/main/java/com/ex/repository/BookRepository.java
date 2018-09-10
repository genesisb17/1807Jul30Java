package com.ex.repository;

import java.util.List;

import com.ex.beans.Book;

public interface BookRepository {
	List<Book> getAll();
	Book getById(int id);
	Book getAuthor(Book b);
	Book add(Book b);

}
