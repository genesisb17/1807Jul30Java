package com.revature.servicepackage;

import java.util.List;

import com.revature.dao.BookDAO;
import com.revature.pojos.Book;

public class BookService {

	BookDAO bdao = new BookDAO();
	
	public List<Book> getAll() {
		return bdao.findAll();
	}
}
