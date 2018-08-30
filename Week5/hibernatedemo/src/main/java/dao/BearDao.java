package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Bear;
import util.ConnectionUtil;

public class BearDao {
	/*
	 * CRUD DAO using hibernate methods. 
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
	
	public Bear getById(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = session.get(Bear.class, id);
		session.close();
		return b;
	}
	
	public Bear loadById(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = session.load(Bear.class, id);
		session.close();
		return b;
	}

}