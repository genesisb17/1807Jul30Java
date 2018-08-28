package com.ex.service;

import java.util.List;

import com.ex.dao.Dao;
import com.ex.dao.GenreDao;
import com.ex.pojos.Genre;

public class GenreService {
	static Dao<Genre, Integer> dao = new GenreDao();
	
	public List<Genre> getAllGenres(){
		return dao.findAll();
	}
	
	public Genre getOne(int id) {
		return dao.findOne(id);
	}	
	
	public Genre addGenre(Genre g) {
		return dao.save(g);
	}
	
	public Genre updateGenre(Genre g) {
		return dao.update(g);
	}
	
	public boolean isUnique(Genre g) {
		return dao.isUnique(g);
	}
}