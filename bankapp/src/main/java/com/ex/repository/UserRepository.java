package com.ex.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class UserRepository {
	
	public User findById(int id) {
		User u = null;
		try(Session session = ConnectionUtil.getSession()){
			u = session.get(User.class, id);
		}
		return u;
	}
	
	public List<User> findAll() {
		List<User> users = null;
		try(Session session = ConnectionUtil.getSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			users = session.createQuery(criteria).getResultList();
		}
		return users;
	}
	
	public User save(User u) {
		try(Session s = ConnectionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();
		}
		return u;
	}
	/*
	 * Back in simpler times a.k.a hibernate 4
	 * 
	 * Criteria c = session.createCriteria(User.class)
	 * c.addRetriction
	 * c.list
	 */
	
	
	public User findByUsernameCriteria(String name) {
		User u = null;
		try(Session s = ConnectionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			CriteriaBuilder builder = s.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("username"), name));
			u = s.createQuery(query).getSingleResult();
		} catch(NoResultException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public void update(User u) {
		try(Session s = ConnectionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		}
	}
	
	public User findByUsername(String name) {
		 User u = null;
		 try (Session session = ConnectionUtil.getSession();) {
			 Query<User> q = session.createQuery("from User where lower(username) = :param", User.class);
			 q.setParameter("param", name.toLowerCase());
			 u = (User) q.getResultList();
		 }
		 return u;
		
	}

}
