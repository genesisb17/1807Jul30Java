package com.ex.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Bear;
import com.ex.util.ConnectionUtil;

public class BearDao {
	/*
	 * CRUD DAO using hibernate methods
	 */
	
	public Bear addBear(Bear b) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction(); //start of tx w db

			int id = (int) session.save(b);
			b.setBearId(id);

			tx.commit(); //assuming we have successfully added bear, commit tx
		}
		finally {
			session.close();
		}
		return b;
	}
	
	public Bear persistBear(Bear b) {
		return b;
	}
	
	//have an instance in java and use that instance to refer to the row in the database
	public Bear getById(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = session.get(Bear.class, id);
		session.close();
		return b;
	}
	
	public Bear loadById(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = session.load(Bear.class, id);
		//System.out.println(b);
		session.close();
		return b;
	}
	
	/*
	 * Criteria 
	 * API for querying data programatically
	 * We don't need to speak any language but Java
	 */
	
	public List<Bear> findAllCriteria(){
		List<Bear> bears = null;
		try(Session session = ConnectionUtil.getSession()){
		
		//TO get a criteria, we need a criteriabuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Bear> criteria = builder.createQuery(Bear.class);
		Root<Bear> root = criteria.from(Bear.class);
		bears = session.createQuery(criteria).getResultList();
		} 
			return bears;
	}
	

	/*
	 * Query
	 * Query Database using HQL 
	 */
	
public List<Bear> findByColor(String color){
	List<Bear> bears = null;
	try(Session session = ConnectionUtil.getSession();){
		Query<Bear> q = session.createQuery("from Bears where lower(furColor) like :param", Bear.class);
		q.setParameter("param", color.toLowerCase());
		bears = q.getResultList();
	} 
		return bears;
	}
}
