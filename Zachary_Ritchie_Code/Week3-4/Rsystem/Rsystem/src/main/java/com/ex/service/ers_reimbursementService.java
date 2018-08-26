package com.ex.service;

import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.ers_reimbursementDAO;
import com.ex.pojos.ers_reimbursement;

public class ers_reimbursementService 
{
	static DAO<ers_reimbursement, Integer> aDao = new ers_reimbursementDAO();

	public List<ers_reimbursement> getAll()
	{
		return aDao.getAll();
	}
	
	public ers_reimbursement save(ers_reimbursement obj)
	{
		return aDao.save(obj);
	}
	
	public ers_reimbursement update(ers_reimbursement obj)
	{
		return aDao.update(obj);
	}
}
