package com.rev.services;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.rev.dao.BookDAO;
import com.rev.pojos.Book;

public class BookService {
	
	static BookDAO bdao = new BookDAO();

	public List<Book> getAllBooks() {
		return bdao.findAll();
	}



}
