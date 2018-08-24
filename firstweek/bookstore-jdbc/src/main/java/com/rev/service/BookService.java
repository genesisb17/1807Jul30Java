package com.rev.service;


import com.rev.dao.BookDao;

import com.rev.pojo.Book;

public class BookService {
	// CALL BOOK DAO METHODS HERE
	static BookDao bDao = new BookDao();
	
	public Book addBook(Book b) {
		/*ISBN VALIDATION
		make sure it is unique -biz logic- call some method to check 
		 * 	DB to ensure it is unique to avoid running into
		 *  sql constraint violation */
		return (Book) bDao.save(b);
	}
	


}