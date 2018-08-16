package com.rev.service;

import java.util.List;

import com.rev.dao.Dao;
import com.rev.dao.GenreDAO;
import com.rev.pojos.Genre;

public class GenreService {
	
	/*
	 * We have servers and daos separately
	 */
	 				
	static Dao<Genre, Integer> gDao = new GenreDAO();
	
	public List<Genre> getAll(){
		return gDao.findAll();
	}
	
}
