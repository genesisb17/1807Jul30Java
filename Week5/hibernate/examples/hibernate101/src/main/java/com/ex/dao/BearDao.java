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
	 * CRUD DAO using hibernate methods. 
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
		//TODO
		return b;
	}

	//GET
	public Bear getById(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = session.get(Bear.class, id);
		session.close();
		return b;
	}

	//LOAD
	public Bear loadById(int id) {
		/*
		 * We must actually access the data in our entity or 
		 * we are just loading a proxy.
		 * LazyInitializationException will be thrown if we try
		 * to access our proxy with the session closed
		 */
		Session session = ConnectionUtil.getSession();
		Bear b = session.load(Bear.class, id);
		System.out.println("Just loaded Bear");
		System.out.println(b);
		session.close();
		return b;
	}


	//UPDATE
	//MERGE


	/*
	 * Criteria 
	 * API for querying data programatically 
	 * We dont need to speak any language but Java 
	 */
	public List<Bear> findAllCriteria(){
		List<Bear> bears = null;
		try(Session session = ConnectionUtil.getSession();){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Bear> criteria = builder.createQuery(Bear.class);
			Root<Bear> root = criteria.from(Bear.class);
			bears = session.createQuery(criteria).getResultList();
		}
		return bears;
	}

	/*
	 * Query
	 * Query database using HQL
	 */
	public List<Bear> findByColor(String color){
		List<Bear> bears = null;
		try(Session session = ConnectionUtil.getSession();){
			Query<Bear> q = session
					.createQuery("from Bear where lower(furColor) like :param", Bear.class);
			q.setParameter("param", color.toLowerCase());
			bears = q.getResultList();
		}
		return bears;
	}
}
