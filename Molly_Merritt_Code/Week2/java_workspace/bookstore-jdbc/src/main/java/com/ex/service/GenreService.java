package com.ex.service;

import java.util.List;

import com.ex.dao.Dao;
import com.ex.dao.GenreDAO;
import com.ex.pojos.Genre;

public class GenreService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * Maybe need two dao methods at once or dao methods from different classes
	 * 	or some sort of manipulation of data either pre or post dao method call
	 * 	should go here
	 * 
	 * Service layer bridges gap between user interface (main method) and database
	 * 	interface (DAO)
	 */
	
	static Dao<Genre, Integer> gDao = new GenreDAO();	// example of covariant types & polymorphism
	
	public List<Genre> getAll() {
		return gDao.findAll();
	}

}
