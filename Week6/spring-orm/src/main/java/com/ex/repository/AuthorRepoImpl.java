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
	
	public List<Author> getAll() {
		
								//programmatic query
		return sf.getCurrentSession().createCriteria(Author.class).list();
	}

	@Override
	public Author getById(int id) {
		// TODO Auto-generated method stub
		return null;
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
