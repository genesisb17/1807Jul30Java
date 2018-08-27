package com.revature.dao;

import java.util.List;

import com.revature.pojo.ErsReimbStatus;

public class DAOTestDriver {
	public static void main(String[] args) {
		ErsReimbStatusDAO statDao = new ErsReimbStatusDAO();
		List<ErsReimbStatus> list = statDao.findAll();
		for (ErsReimbStatus s: list) {
			System.out.println(s);
		}
		
//		ErsReimbStatus testUpdate = new ErsReimbStatus(1, "Pending");
//		statDao.update(testUpdate);
		
//		ErsReimbStatus testInsert = new ErsReimbStatus("BAD");
//		statDao.insert(testInsert);
		
		ErsReimbStatus testInsert = new ErsReimbStatus(4, "BAD");
		
		statDao.delete(testInsert);
	}
}
