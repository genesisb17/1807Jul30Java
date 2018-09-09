package com.reimb.service;

import java.util.List;

import com.reimb.dao.Dao;
import com.reimb.dao.ReimbursementDao;
import com.reimb.pojos.Reimbursement;
import com.reimb.pojos.Users;

public class TicketsService {
	static Dao<Reimbursement, Integer> redao = new ReimbursementDao();
	
	public Reimbursement addOne(Reimbursement o) {
		return redao.save(o);
	}
	
	public List<Reimbursement> getPast(Reimbursement o) {
		return redao.getPast(o);
	}
	
	public List<Reimbursement> getFnPend(Reimbursement o){
		System.out.println("--> " + o.toString());
		return redao.getFnPend(o);
	}
	
	public List<Reimbursement> getPend(Reimbursement o){
		return redao.getPend(o);
	}
	public List<Reimbursement> findAll(Reimbursement o){
		
		return redao.findAll(o);
	}
	
	public List<Reimbursement> findAll(){
		return redao.findAll();
	}
	public Reimbursement findOne(Reimbursement o) {
		return redao.findOne(o);
	}
	
	public Reimbursement addUser(Reimbursement u) {
		return redao.saveAnother(u);
	}
}

