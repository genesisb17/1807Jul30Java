package com.ex.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.models.Account;
import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class AccountRepository {

	public Account findById(int id) {
		try(Session session = ConnectionUtil.getSession();){
			User b = session.get(User.class, id);
			session.close();
			return b;
		}
	}
	
	
	public List<Account> findAllCriteria(){
		List<Account> users = null;
		try(Session session = ConnectionUtil.getSession();){
		
		//TO get a criteria, we need a criteriabuilder
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> root = criteria.from(User.class);
			users = session.createQuery(criteria).getResultList();
		} 
			return users;
	}
	
	public User save(User u) {
		try(Session s = ConnectionUtil.getSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();
		}
		return u;
	}
	
	public void update(User u) {
		try(Session s = ConnectionUtil.getSession();){
			Transaction tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		}
	}
	
//	public User findByUsername(String name) {
//		List<User> users = null;
//		try(Session session = ConnectionUtil.getSession();){
//			Query<User> q = session.createQuery("from Bears where lower(furColor) like :param", User.class);
//			q.setParameter("uname", name.toLowerCase());
//			users = (User) q.getSingleResult();
//		} 
//			return users;
//		}
	
	public User findByUsernameCriteria(String name) {
		User u = null;
		try(Session s = ConnectionUtil.getSession()){
			Transaction tx = s.beginTransaction();
			CriteriaBuilder builder = s.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("username"), name));
			u = s.createQuery(query).getSingleResult();
		}
		
		return u;
	}

}
