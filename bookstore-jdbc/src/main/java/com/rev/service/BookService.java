package com.rev.service;

import java.util.List;

import com.rev.dao.BookDAO;
import com.rev.dao.Dao;
import com.rev.dao.GenreDAO;
import com.rev.pojos.Book;
import com.rev.pojos.Genre;

public class BookService {
	
static Dao<Book, Integer> bDao = new BookDAO();
	
	public List<Book> getAll(){
		return bDao.findAll();
	}

}
