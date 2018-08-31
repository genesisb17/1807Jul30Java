package com.ex.data;

import java.util.List;

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
	User b;
Session session=ConnectionUtil.getSession();
	 b=(User) session.get(User.class, id);
	//session.close();
	
	return b;
	
}

public List<User> findAll(){
	
	List<User> users=null;
	
	//selecting what table to pull from and then parsing it to a class
	try(Session session=ConnectionUtil.getSession();){
	Query<User> q=session.createQuery("from User",User.class);
	
	//Query<Bear> q=session.createQuery("from Bear where furColor=r",Bear.class);

	users=q.getResultList();
	}
	return users;
	
}



public User save(User u) {
	
	Session session = ConnectionUtil.getSession();
	try {
		Transaction tx = session.beginTransaction(); //start of tx w db

		int id = (int) session.save(u);
		u.setId(id);

		tx.commit(); //assuming we have successfully added bear, commit tx
	}
	finally {
		session.close();
	}
	return u;
	
}


public void update(User u) {
	try(Session session=ConnectionUtil.getSession();){
		Transaction tx=session.beginTransaction();
		session.update(u);
		tx.commit();
	}
	
	
	}



public User findByUsername(String name) {
	User user=null;
	
	//selecting what table to pull from and then parsing it to a class
	try(Session session=ConnectionUtil.getSession();){
	Query<User> q=session.createQuery("from User where lower(username)=:param",User.class);
	q.setParameter("param",name.toLowerCase());
	//Query<Bear> q=session.createQuery("from Bear where furColor=r",Bear.class);

	user=q.getSingleResult();
	}
	
	
	return user;
}

public User findByUsernameCriteria(String name) {
	User user=null;
	
	try(Session session=ConnectionUtil.getSession();){
		Transaction tx=session.beginTransaction();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<User> query=builder.createQuery(User.class);
		Root<User> root=query.from(User.class);
		query.select(root).where(builder.equal(root.get("username"), name));
		user=session.createQuery(query).getSingleResult();
	}
	
	
	return user;
}


}
