package com.ex.dao;

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
			Transaction tx = session.beginTransaction();	// start of tx with db
			
			int id = (int) session.save(b);	// insert
			b.setBearId(id);
			
			tx.commit();	// assuming we have successfully added bear, commit
		} finally {
			session.close();
		}
		return b;
	}

}
