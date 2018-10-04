package com.ex.repository;

import java.util.List;

import com.ex.beans.Genre;


public interface GenreRepository 
{
	List<Genre> getAll();
	Genre getById(int id);
	Genre add(Genre a);
	void update(Genre a);
}
