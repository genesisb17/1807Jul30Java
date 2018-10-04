package com.ex.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Genre;

@Transactional
@Repository
public class GenreRepoImpl implements GenreRepository
{
	@Autowired
	SessionFactory sf;

	public List<Genre> getAll() {
		return sf.getCurrentSession().createCriteria(Genre.class).list();
	}

	public Genre getById(int id) {
		return (Genre) sf.getCurrentSession().get(Genre.class, id);
	}

	public Genre add(Genre a) {
		int id = (Integer) sf.getCurrentSession().save(a);
		a.setId(id);
		return a;
	}

	public void update(Genre a) {
		// TODO Auto-generated method stub
		
	}
}
