package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.User;
import com.revature.model.UserInformation;

public class UserService {

	private static UserDao userDao = UserDaoImpl.getInstance();
	
	public static UserInformation login(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper map = new ObjectMapper();
		String json = null;
		User user = null;
		try {
			json = req.getReader().readLine();
			user = map.readValue(json, User.class);
		} catch( IOException e) {
			e.printStackTrace();
		}
		
//		User authorized = userDao.getUser(user.getUsername());
//		if(userDao.getPasswordHash(user).equals(authorized.getPassword())) {
//			return userDao.getUserInformation(user.getUsername());
//
//		}
		return null;
	}
}
