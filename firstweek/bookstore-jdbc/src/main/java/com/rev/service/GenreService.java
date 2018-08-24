package com.rev.service;

import java.util.List;


import com.rev.dao.Genredao;
import com.rev.pojo.Genre;

public class GenreService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	
	static Genredao gDao = new Genredao();
	
	public List<Genre> getAll(){
		return gDao.findAll();
	}
	
}