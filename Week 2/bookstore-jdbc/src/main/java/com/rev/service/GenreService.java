package com.rev.service;

import java.util.List;

import com.rev.dao.Dao;
import com.rev.dao.GenreDAO;
import com.rev.pojos.Genre;

public class GenreService {
	
	static Dao<Genre, Integer> dao = new GenreDAO();
	
	public Genre findById(int id) {
		return dao.findOne(id);
	}

	public List<Genre> getAll(){
		return dao.getAll();
	}
	
}
