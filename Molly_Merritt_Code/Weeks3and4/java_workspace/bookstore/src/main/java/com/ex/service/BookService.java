package com.ex.service;

import java.util.List;

import com.ex.dao.BookDao;
import com.ex.dao.Dao;
import com.ex.pojos.Book;

public class BookService {
	
	// CALL BOOK DAO METHODS HERE
	static Dao<Book, Integer> bDao = new BookDao();
	
	public List<Book> getAllBooks() {
		return bDao.findAll();
	}
	
	public Book findOne(int id) {
		return bDao.findOne(id);
	}
	
	public Book addBook(Book b) {
		/*ISBN VALIDATION
		make sure it is unique -biz logic- call some method to check 
		 * 	DB to ensure it is unique to avoid running into
		 *  sql constraint violation */
		return bDao.save(b);
	}
	
	public Book updateBook(Book b) {
		return bDao.update(b);
	}

}
