package com.ex.service;

import java.util.List;

import com.ex.dao.Dao;
import com.ex.dao.GenreDao;
import com.ex.pojos.Genre;

public class GenreService {
	static Dao<Genre, Integer> dao = new GenreDao();
	
	public Genre findById(int id) {
		return dao.findOne(id);
	}

	public List<Genre> getAll(){
		return dao.getAll();
	}
}