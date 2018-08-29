package com.ers.dao;

import com.ers.pojo.User;
import com.ers.pojo.UserInfo;

public interface UserDao {
	
	User getUser(String username);
	String getPasswordHash(User user);
	UserInfo getUserInfo(String username);
}
