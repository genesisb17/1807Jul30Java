package com.ex.service;

import java.util.List;

import com.ex.dao.BookDao;
import com.ex.dao.Dao;
import com.ex.pojos.Book;

public class BookService {
	static Dao<Book, Integer> bookdao = new BookDao();
	
	public List<Book> getAllBooks(){
		return bookdao.getAll();
	}
	
	public Book addBook(Book b){
		return bookdao.save(b);
	}
	

}
