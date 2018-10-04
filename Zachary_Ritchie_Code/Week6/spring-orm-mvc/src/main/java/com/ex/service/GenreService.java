package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.beans.Genre;
import com.ex.repository.GenreRepository;


@Service("genreService")
public class GenreService 
{
	@Autowired
	private GenreRepository genreRepo;// = new AuthorRepoImpl();

	public Genre addGenre(Genre a) {
		//do some validation to make sure author isnt in db
		//or whatver "business logic" youd require
		return genreRepo.add(a);
	}
	
	public List<Genre> getAll(){
		return genreRepo.getAll();
	}
	
	public Genre getById(int id) {
		return genreRepo.getById(id);
	}
}
