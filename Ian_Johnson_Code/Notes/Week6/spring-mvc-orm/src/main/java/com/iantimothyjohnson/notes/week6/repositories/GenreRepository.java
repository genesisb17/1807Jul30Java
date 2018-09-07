package com.iantimothyjohnson.notes.week6.repositories;

import java.util.List;

import com.iantimothyjohnson.notes.week6.beans.Genre;

public interface GenreRepository {
	List<Genre> getAll();
	
	Genre getById(int id);
	
	Genre add(Genre g);
}
