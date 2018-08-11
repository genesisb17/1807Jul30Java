package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.ConnectionFactory;
import com.revature.pojos.Author;

public class AuthorDAO implements DAO<Author, Integer> {

	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author save(Author obj) {
		// TODO Auto-generated method stub
		return obj;
	}

	@Override
	public Author update(Author obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Author obj) {
		// TODO Auto-generated method stub
		
	}
	
}
