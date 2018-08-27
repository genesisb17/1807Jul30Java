package com.ex.services;

import com.ex.dao.UsersDAO;
import com.ex.pojos.Users;

public class UsersServices {

	public static Users validation(String username, String password) {
		Users u = UsersDAO.validate(username, password);
		
		return u;
	}
	
}
