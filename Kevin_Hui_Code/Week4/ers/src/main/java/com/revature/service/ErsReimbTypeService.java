package com.revature.service;

import java.util.List;

import com.revature.dao.ErsReimbTypeDao;
import com.revature.pojo.ErsReimbType;

public class ErsReimbTypeService {
	
	static ErsReimbTypeDao rtDao = new ErsReimbTypeDao();
	
	public static List<ErsReimbType> getAll() {
		return rtDao.findAll();
	}
}
