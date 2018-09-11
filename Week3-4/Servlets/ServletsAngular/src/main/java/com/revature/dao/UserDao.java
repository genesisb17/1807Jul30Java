package com.revature.dao;

import com.revature.model.User;
import com.revature.model.UserInformation;

public interface UserDao {
	
	User getUser(String username);
	String getPasswordHash(User user);
	UserInformation getUserInformation(String username);
	
}
