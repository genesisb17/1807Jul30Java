package com.p1.service;

import java.util.List;

import com.p1.DAO.DAO;
import com.p1.DAO.customerDAO;
import com.p1.pojo.customer;

public class customerService 
{
	static DAO<customer, Integer> aDao = new customerDAO();
	static customerDAO cus = new customerDAO();
	
	public customer save(customer obj)
	{
		return aDao.save(obj);
	}
	
	public List<customer> getAll() 
	{
		return aDao.getAll();
	}
	
	public customer findOne(String obj)
	{
		return cus.findOne(obj);
	}
}
