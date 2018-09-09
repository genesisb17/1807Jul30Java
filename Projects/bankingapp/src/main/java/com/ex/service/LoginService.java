package com.ex.service;

import com.ex.dao.DAO;
import com.ex.dao.LoginDao;
import com.ex.pojos.Login;

public class LoginService {

	static DAO<Login, Integer> lDao = new LoginDao();
	
	public Login findOne(Login check) {
		return lDao.findOne(check);
	}
	
	public Login findPw(Login find) {
		return lDao.findPw(find);
	}
	
}
