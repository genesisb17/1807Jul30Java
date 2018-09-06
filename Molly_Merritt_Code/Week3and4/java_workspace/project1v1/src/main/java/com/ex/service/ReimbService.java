package com.ex.service;

import java.util.List;

import com.ex.dao.ReimbDao;
import com.ex.pojos.Reimbursement;

public class ReimbService {
	
	static ReimbDao rDao = new ReimbDao();
	
	public List<Reimbursement> findAllReimbursements() {
		return rDao.findAll();
	}
	
	public Reimbursement addReimbursement(Reimbursement r) {
		return rDao.save(r);
	}
	
	public List<Reimbursement> findReimbursementsById(int id) {
		return rDao.findAll(id);
	}
	
	public static void main(String[] args) {
		ReimbService rService = new ReimbService();
//		List<Reimbursement> reimbs = rService.findAllReimbursements();
//		System.out.println(reimbs.size());
//		for (int i=0; i<reimbs.size(); i++) {
//			System.out.println(reimbs.get(i));
//		}
		
//		Reimbursement r = new Reimbursement();
//		r.setAmount(1000);;
//		r.setDescription("Atlantis Lodge");
//		r.setTypeId(1);
//		r.setAuthor(41);
//		rService.addReimbursement(r);
		
	}

}
