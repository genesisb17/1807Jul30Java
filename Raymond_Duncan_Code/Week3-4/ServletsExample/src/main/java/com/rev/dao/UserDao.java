package com.rev.dao;

import com.rev.model.User;
import com.rev.model.UserInformation;

public interface UserDao {

	User getUser(String username);
	String getPasswordHash(User user);
	UserInformation getUserInformation(String username);
	
}
