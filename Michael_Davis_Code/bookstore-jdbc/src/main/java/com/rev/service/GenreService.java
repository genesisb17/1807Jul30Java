package com.rev.service;

import java.util.List;

import com.rev.dao.Dao;
import com.rev.dao.GenreDao;
import com.rev.pojos.Genre;

public class GenreService {
	static Dao<Genre, Integer> dao = new GenreDao();
	
	public Genre findById(int id) {
		return dao.findOne(id);
	}

	public List<Genre> getAll(){
		return dao.getAll();
	}
}