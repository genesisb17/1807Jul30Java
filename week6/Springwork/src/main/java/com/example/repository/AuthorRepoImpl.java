package com.example.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.beans.Author;
@Repository
@Transactional
public class AuthorRepoImpl implements AuthorRepositorys {
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

}
