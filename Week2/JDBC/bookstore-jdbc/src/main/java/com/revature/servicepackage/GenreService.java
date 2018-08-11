package com.revature.servicepackage;

import java.util.List;

import com.revature.dao.DAO;
import com.revature.dao.GenreDAO;
import com.revature.pojos.Genre;

public class GenreService {
	/*
	 * Service Layer is business logic.
	 * Maybe need two DAO methods at once
	 * or DAO methods from different classes
	 * or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	static DAO<Genre, Integer> gDao = new GenreDAO();
	
	public List<Genre> getAll() {
		return gDao.findAll();
	}
	
}
