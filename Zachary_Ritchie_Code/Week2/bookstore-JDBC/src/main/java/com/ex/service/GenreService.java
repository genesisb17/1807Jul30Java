package com.ex.service;

import java.util.List;

import com.ex.DAO.DAO;
import com.ex.DAO.GenreDAO;
import com.ex.pojo.Genre;

public class GenreService
{
	static DAO<Genre, Integer> gDAO	 = new GenreDAO();
	
	public List<Genre> getAll()
	{
		return gDAO.getAll();		
	}	
}
