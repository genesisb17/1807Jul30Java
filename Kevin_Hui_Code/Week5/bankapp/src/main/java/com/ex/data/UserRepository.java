package com.ex.data;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class UserRepository {

	public User findUserById(int id) {
		User u = null;

		try (Session session = ConnectionUtil.getSession()) {
			CriteriaQuery c = null;
			c.from(User.class);
		}
		return u;
	}

//	public List<User> findAll() {
//		
//	}
}
