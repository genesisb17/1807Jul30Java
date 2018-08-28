package com.ex.services;

import com.ex.dao.UserDao;
import com.ex.pojos.User;

public class UserServices {
	
	public static User validation(String username, String password) {
		return UserDao.validate(username, password);
	}

}
