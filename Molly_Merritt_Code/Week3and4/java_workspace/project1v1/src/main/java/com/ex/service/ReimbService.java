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
	
//	public static void main(String[] args) {
//		ReimbService rService = new ReimbService();
//		List<Reimbursement> reimbs = rService.findAllReimbursements();
//		System.out.println(reimbs.size());
//		for (int i=0; i<reimbs.size(); i++) {
//			System.out.println(reimbs.get(i));
//		}
//	}

}
