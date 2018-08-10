package com.iantimothyjohnson.notes.week2.bookstore.service;

import java.util.List;

import com.iantimothyjohnson.notes.week2.bookstore.dao.DAO;
import com.iantimothyjohnson.notes.week2.bookstore.dao.GenreDAO;
import com.iantimothyjohnson.notes.week2.bookstore.pojos.Genre;

public class GenreService {
	// The service layer is business logic. Maybe we need two DAO methods at
	// once, DAO methods from different classes or some sort of manipulation of
	// data either pre- or post-DAO method call.

	static DAO<Genre, Integer> gDao = new GenreDAO();
	
	public List<Genre> getAll() {
		return gDao.findAll();
	}
}
