package com.rev.service;

import java.util.List;

import com.rev.dao.BookDao;
import com.rev.dao.Dao;
import com.rev.pojos.Book;

public class BookService {
	// CALL BOOK DAO METHODS HERE
	static Dao<Book, Integer> bookdao = new BookDao();
	
	public List<Book> getAllBooks(){
		return bookdao.getAll();
	}
	


}