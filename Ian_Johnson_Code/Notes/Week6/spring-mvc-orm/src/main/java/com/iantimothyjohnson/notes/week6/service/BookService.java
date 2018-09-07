package com.iantimothyjohnson.notes.week6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iantimothyjohnson.notes.week6.beans.Book;
import com.iantimothyjohnson.notes.week6.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAll() {
		return bookRepository.getAll();
	}
	
	public Book add(Book b) {
		return bookRepository.add(b);
	}
}
