package com.revature.dao;

import com.revature.pojo.ErsReimbType;

public class DaoTestDriver {
	public static void main(String[] args) {
//		ErsReimbursementDao rDao = new ErsReimbursementDao();
//		
//		ErsReimbursement obj = new ErsReimbursement(76, "test dao insert", 5, 2);
//		
//		rDao.insert(obj);
		
		ErsReimbTypeDao rsDao = new ErsReimbTypeDao();
		for (ErsReimbType t: (rsDao.findAll()) ) {
			System.out.println(t);
		}
	}
}
