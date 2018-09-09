package com.rev.dao;

import com.rev.models.User;
import com.rev.models.UserInformation;

public interface UserDao {
	User getUser(String user);
	String getPasswordHash(User user, User pass);
	UserInformation getUserInformation(String username);
	String getPasswordHash(User user);
}
