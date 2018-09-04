package com.revature.dao;

import com.revature.pojo.ErsReimbursement;

public class DaoTestDriver {
	public static void main(String[] args) {
		ErsReimbursementDao rDao = new ErsReimbursementDao();
		
		for (ErsReimbursement r : (rDao.findByUserId("jdoe"))) {
			System.out.println(r);
		}
	}
}
