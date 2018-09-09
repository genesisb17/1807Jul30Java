package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.beans.Book;
import com.ex.repository.BookRepository;

@Service("bookService")
public class BookService {
	@Autowired
	private BookRepository bookRepo;// = new AuthorRepoImpl();

	public Book addBook(Book a) {
		//do some validation to make sure author isnt in db
		//or whatver "business logic" youd require
		return bookRepo.add(a);
	}
	
	public List<Book> getAll(){
		return bookRepo.getAll();
	}
	
	public Book getById(int id) {
		return bookRepo.getById(id);
	}
}
