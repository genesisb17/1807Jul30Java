package com.rev.services;

import java.util.List;

import com.rev.dao.DAO;
import com.rev.dao.GenreDAO;
import com.rev.pojos.Genre;

public class GenreService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * Because we may need two DAO methods at once 
	 * or DAO methods from different classes 
	 * or some sort of manipulation of data either pre or post DAO 
	 */
	
	static DAO<Genre, Integer> genreDAO = new GenreDAO();
	
	public List<Genre> getAll() {
		return genreDAO.findAll();
	}

}
