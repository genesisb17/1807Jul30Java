package com.reimbursement.service;

import java.sql.Blob;
import java.util.List;

import com.reimbursement.dao.ReimbursementDao;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;


public class ReimbursementService extends ReimbursementDao {

	@Override
	public List<Reimbursement> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@Override
	public Reimbursement findOne(Integer id) {
		// TODO Auto-generated method stub
		return super.findOne(id);
	}

	@Override
	public Reimbursement addReceipt(Reimbursement a, Blob b) {
		// TODO Auto-generated method stub
		return super.addReceipt(a, b);
	}

	@Override
	public void setResolver(int a, User b) {
		// TODO Auto-generated method stub
		super.setResolver(a, b);
	}

	@Override
	public void setStatus(int a, int b) {
		// TODO Auto-generated method stub
		super.setStatus(a, b);
	}

	@Override
	public Reimbursement save(Reimbursement obj) {
		// TODO Auto-generated method stub
		return super.save(obj);
	}
	

	@Override
	public Reimbursement update(Reimbursement obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}

	@Override
	public boolean isUnique(Reimbursement obj) {
		// TODO Auto-generated method stub
		return super.isUnique(obj);
	}


}
