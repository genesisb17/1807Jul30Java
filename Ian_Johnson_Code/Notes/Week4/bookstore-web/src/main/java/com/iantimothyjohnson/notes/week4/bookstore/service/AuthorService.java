package com.iantimothyjohnson.notes.week4.bookstore.service;

import java.util.List;

import com.iantimothyjohnson.notes.week4.bookstore.dao.AuthorDAO;
import com.iantimothyjohnson.notes.week4.bookstore.dao.DAO;
import com.iantimothyjohnson.notes.week4.bookstore.pojos.Author;

public class AuthorService {
	static DAO<Author, Integer> aDao = new AuthorDAO();

	public List<Author> getAll() {
		return aDao.findAll();
	}
}
