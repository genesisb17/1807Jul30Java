package servletExample.dao;

import servletExample.pojo.User;
import servletExample.pojo.UserInfo;

public interface UserDao {
	
	User getUser(String username);
	String getPasswordHash(User user);
	UserInfo getUserInfo(String username);
}
