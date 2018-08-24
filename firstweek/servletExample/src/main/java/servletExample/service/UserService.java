package servletExample.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import servletExample.dao.UserDao;
import servletExample.dao.Userdoaimpl;
import servletExample.pojo.User;
import servletExample.pojo.UserInfo;

public class UserService {
	private static UserDao userDao = Userdoaimpl.getInstance();
	
	public static UserInfo login(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper mapper = new ObjectMapper();
		
		User user = null;
		try {
			
			user = mapper.readValue(req.getReader(), User.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User authorized = userDao.getUser(user.getUsername());
		if(userDao.getPasswordHash(user).equals(authorized.getPassword()))
			return userDao.getUserInfo(user.getUsername());
		return null;
	}
}
