package com.ex.service;

import com.ex.dao.DAO;
import com.ex.dao.ers_usersDAO;
import com.ex.pojos.ers_users;

public class ers_usersService
{
	static DAO<ers_users, Integer> aDao = new ers_usersDAO();
	static ers_usersDAO ers = new ers_usersDAO();
	
	public ers_users save(ers_users obj)
	{
		return aDao.save(obj);
	}
	
	public ers_users findOne(String obj)
	{
		System.out.println("IN SEVICE LAYER");
		ers_users user = ers.findOne(obj);
		return user;
	}
	

	/*public static ers_users login(HttpServletRequest req, HttpServletResponse resp)
	{
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ers_users user = null;
		try {
			//user = mapper.readValue(req.getReader(), ers_users.class);
			String[] userInfo = mapper.readValue(json, String[].class);
			String username = userInfo[0];
			String password = userInfo[1];
		} catch (IOException e) {
			e.printStackTrace();
		}
		ers_users authorized = findOne(username);
		if (userDao.getPasswordHash(user).equals(authorized.getPassword())) {
			return userDao.getUserInformation(user.getUsername());
		}
		return null;
	}*/
}
