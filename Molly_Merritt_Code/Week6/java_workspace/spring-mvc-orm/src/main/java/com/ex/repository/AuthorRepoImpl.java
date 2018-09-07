package com.ex.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.beans.Author;

@Transactional
@Repository
public class AuthorRepoImpl implements AuthorRepository {
	
	@Autowired
	SessionFactory sf;

	@Override
	public List<Author> getAll() {
		return sf.getCurrentSession().createCriteria(Author.class).list();
	}

	@Override
	public Author getById(int id) {
		return (Author) sf.getCurrentSession().get(Author.class, id);
	}

	@Override
	public Author add(Author a) {
		int id = (Integer) sf.getCurrentSession().save(a);
		a.setId(id);
		return a;
	}

	@Override
	public void update(Author a) {
		// TODO Auto-generated method stub
		
	}

}
