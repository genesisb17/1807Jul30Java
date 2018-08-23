package com.iantimothyjohnson.notes.week4.bookstore.service;

import java.util.List;

import com.iantimothyjohnson.notes.week4.bookstore.dao.BookDAO;
import com.iantimothyjohnson.notes.week4.bookstore.dao.DAO;
import com.iantimothyjohnson.notes.week4.bookstore.pojos.Book;

public class BookService {
	static DAO<Book, Integer> bDao = new BookDAO();

	public List<Book> getAll() {
		return bDao.findAll();
	}
	
	public Book getById(int id) {
		return bDao.findOne(id);
	}
}
