package com.ex.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Author;
@Repository
@Transactional
public class AuthorRepoImpl implements AuthorRepository {
	@Autowired
	SessionFactory sf;
	public List<Author> getAll() {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createCriteria(Author.class).list();
	}

	
	public Author getById(int id) {
		
		return null;
	}

	
	public Author getBooks(Author a) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Author add(Author a) {
		// TODO Auto-generated method stub
		return null;
	}

}
