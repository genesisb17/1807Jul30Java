package com.ex.dao;

import java.sql.Connection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ex.pojos.Bear;
import com.ex.util.ConnectionUtil;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Bear;
import com.ex.util.ConnectionUtil;

public class BearDao {
	/*
	 * CRUD DAO using  methods. 
	 */

	
	
	/*
	 * SAVE
	 * - adds instance to db
	 * - persists transient instance, returns whatever Serializable
	 * identifier is used for the instance 
	 * - saving a persisted instance does nothing 
	 * - saving a detached instance creates a new persistant instance
	 * and assigns it a new identifier, which results in a duplicate
	 * record. do not do!
	 */
	public Bear saveBear(Bear b) {
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
	
	/*
	 * PERSIST
	 * - intended to add a new entity to the persistence context, ie
	 * transitioning an instance from the transient to persistent state
	 * - usually called to add a record to the db(persist an instance)
	 * - after persist(obj) is called, obj is in the persistence context
	 * but not added to the db until the tx is commited, flushed, or the 
	 * session is closed. 
	 * - has void return type. the object passed is what gets changed.
	 * - the ID is not guaranteed to be not null after this method 
	 * - if an instance is detached, calling this method will throw an 
	 * exception
	 * - persist may be called on an already persistent instance, nothing
	 * will happen 
	 */
	public Bear persistBear(Bear b) {
		return b;
	}
	
	/*GET
	 *
	 * 
	 */
	public Bear getById(int id) {
		Session session=ConnectionUtil.getSession();
		Bear b=session.get(Bear.class, id);
		session.close();
		return b;
	}
	//LOAD
	
	/*
	 * We msut actually acess the data in our entity or
	 * we are just loading a pronxy
	 * lazy initilizaitonException will be thrown if we try to acess our proxy with the ression closed
	 */
	public Bear loadById(int id) {
		Session session=ConnectionUtil.getSession();
		Bear b=session.load(Bear.class, id);
		System.out.println(b);
		session.close();
		return b;
	}
	
	/*
	 * Criteria
	 * api for querying data programaticallywe dontneed to
	 *  speak any langauge but java
	 * 
	 */
	public List<Bear> findAllCriteria(){
		//Session session=ConnectionUtil.getSession();
		List<Bear> bears=null;
		
		try(Session session=ConnectionUtil.getSession();){
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<Bear> criteria=builder.createQuery(Bear.class);
		Root<Bear> root=criteria.from(Bear.class);
		bears=session.createQuery(criteria).getResultList();
		}
		
		
		return bears;
		
	}
	
	
	/*
	 * Querying
	 * 
	 * Query database using HQL
	 */
	
	public List<Bear> findAllQuery(){
		//Session session=ConnectionUtil.getSession();
		List<Bear> bears=null;
		
		//selecting what table to pull from and then parsing it to a class
		try(Session session=ConnectionUtil.getSession();){
		Query<Bear> q=session.createQuery("from Bear",Bear.class);
		
		//Query<Bear> q=session.createQuery("from Bear where furColor=r",Bear.class);

		bears=q.getResultList();
		}
		
		
		return bears;
		
	}
	public List<Bear> findByColor(String color){
		//Session session=ConnectionUtil.getSession();
		List<Bear> bears=null;
		
		//selecting what table to pull from and then parsing it to a class
		try(Session session=ConnectionUtil.getSession();){
		Query<Bear> q=session.createQuery("from Bear where furColor like :param",Bear.class);
		q.setParameter("param",color);
		//Query<Bear> q=session.createQuery("from Bear where furColor=r",Bear.class);

		bears=q.getResultList();
		}
		
		
		return bears;
		
	}

}