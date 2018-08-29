package com.ex.dao;

import com.ex.pojos.User;
import com.ex.pojos.UserInformation;

public interface UserDao {
	
	User getUser(String username);
	String getPasswordHash(User user);
	UserInformation getUserInformation(String username);
	
}
