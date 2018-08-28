package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Bear;
import com.ex.util.ConnectionUtil;

public class BearDao 
{
	/*
	 * CRUD DAO using hibernate methods
	 */
	
	public Bear addBear(Bear b)
	{
		Session session = ConnectionUtil.getSession();
		try
		{
			Transaction tx = session.beginTransaction();
		
			int id = (int) session.save(b);
			b.setBearId(id);
			
			tx.commit();
		}
		finally
		{
			session.close();
		}
		
		return b;
	}
}
