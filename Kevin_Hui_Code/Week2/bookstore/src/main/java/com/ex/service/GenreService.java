package com.ex.service;

import java.util.List;

import com.ex.dao.Dao;
import com.ex.dao.GenreDAO;
import com.ex.pojos.Genre;

public class GenreService {
	
	static Dao<Genre, Integer> gDao = new GenreDAO();
	
	public List<Genre> getAll() {
		return gDao.findAll();
	}
}
