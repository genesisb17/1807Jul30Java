package servletExample.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import servletExample.dao.ReimbursementDao;
import servletExample.dao.UserDao;
import servletExample.dao.Userdoaimpl;
import servletExample.pojo.Reimbursement;
import servletExample.pojo.User;
import servletExample.pojo.UserInfo;

public class UserService {
	private static UserDao userDao = Userdoaimpl.getInstance();
	private static Userdoaimpl udi = Userdoaimpl.getInstance();
	
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
	
	//new user
	public static Object createUser(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper mapper = new ObjectMapper();
		
		UserInfo newUser = null;
		try {
			
			newUser = mapper.readValue(req.getReader(), UserInfo.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		udi.addUser(newUser);
		return null;
	}
	public static List<UserInfo> allUsers(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ObjectMapper mapper = new ObjectMapper();
		
		UserInfo user = null;
		List<UserInfo> users = new ArrayList<UserInfo>();
		
		users.addAll(udi.getAllUsers());
//		System.out.println(r.size());
		return users;
	
	
	}
}