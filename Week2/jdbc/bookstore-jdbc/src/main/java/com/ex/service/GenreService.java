package com.ex.service;

import java.util.List;

import com.ex.dao.Dao;
import com.ex.dao.GenreDAO;
import com.ex.pojos.Genre;

public class GenreService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	
	static Dao<Genre, Integer> gDao = new GenreDAO();
	
	public List<Genre> getAll(){
		return gDao.findAll();
	}
	
}
