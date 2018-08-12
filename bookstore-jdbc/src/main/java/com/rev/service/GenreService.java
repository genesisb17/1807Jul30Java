package com.rev.service;

<<<<<<< HEAD
import java.util.List;

import com.rev.dao.Dao;
import com.rev.dao.GenreDAO;
import com.rev.pojos.Genre;

=======
import com.rev.dao.GenreDAO;

import java.util.List;

import com.rev.dao.Dao;
import com.rev.pojos.Genre;

>>>>>>> 832b3e4fc4cf405de2df146fa3e42788f2589489
public class GenreService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	
	static Dao<Genre, Integer> gDao = new GenreDAO();
	
	public List<Genre> getAll(){
		return gDao.findAll();
<<<<<<< HEAD
	}
}
=======
	}	
}
>>>>>>> 832b3e4fc4cf405de2df146fa3e42788f2589489
