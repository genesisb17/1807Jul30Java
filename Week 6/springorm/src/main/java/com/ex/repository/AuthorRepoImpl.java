package com.ex.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Author;

//goes on top of class and methods
@Transactional
@Repository
public class AuthorRepoImpl implements AuthorRepository{

	@Autowired
	SessionFactory sf;
	
	@Override
	public List<Author> getAll() {
		
		return sf.getCurrentSession().createCriteria(Author.class).list();
	}

	@Override
	public Author getById(int id) {
		// TODO Auto-generated method stub
		return (Author) sf.getCurrentSession().get(Author.class, id);
	}

	@Override
	public Author add(Author a) {
		int id = (Integer) //cast because it returns something serializable
				sf.getCurrentSession().save(a);
		a.setId(id);
		return a;
	}

	@Override
	public void update(Author a) {
		// TODO Auto-generated method stub
		
	}
	
}
