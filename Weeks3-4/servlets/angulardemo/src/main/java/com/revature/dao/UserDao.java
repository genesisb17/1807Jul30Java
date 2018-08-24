package com.revature.dao;

import com.revature.model.User;
import com.revature.model.UserInformation;

public interface UserDao {

	String getPasswordHash(User user);
	UserInformation getUserInformation(String username);
}
