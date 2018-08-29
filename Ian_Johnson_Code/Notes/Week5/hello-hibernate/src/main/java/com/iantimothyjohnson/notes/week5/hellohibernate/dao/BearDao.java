package com.iantimothyjohnson.notes.week5.hellohibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iantimothyjohnson.notes.week5.hellohibernate.pojos.Bear;
import com.iantimothyjohnson.notes.week5.hellohibernate.util.ConnectionUtil;

public class BearDao {
	// This is a CRUD DAO using Hibernate methods.

	public Bear addBear(Bear b) {
		Session s = ConnectionUtil.getSession();

		try {
			Transaction tx = s.beginTransaction(); // Start of TX with DB.
			int id = (int) s.save(b);
			System.out.println(b.getBearId());
			b.setBearId(id);
			tx.commit(); // Assuming we have successfully added bear, commit TX.
		} finally {
			s.close();
		}
		return b;
	}
}
