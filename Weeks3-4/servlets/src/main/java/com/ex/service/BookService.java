package com.ex.service;

import java.util.List;

import com.ex.DAO.BookDAO;
import com.ex.DAO.DAO;
import com.ex.pojo.Books;

public class BookService 
{
	static DAO<Books, Integer> gDAO	 = new BookDAO();
	
	public List<Books> getAll()
	{
		return gDAO.getAll();		
	}
}
