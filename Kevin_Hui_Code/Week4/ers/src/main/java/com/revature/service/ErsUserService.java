package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ErsUsersDao;
import com.revature.pojo.ErsUser;

public class ErsUserService {
	static ErsUsersDao uDao = new ErsUsersDao();

	public static ErsUser login(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		ErsUser user = null;
		try {
			user = mapper.readValue(request.getReader(), ErsUser.class);
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}

		ErsUser authorized = uDao.findUser(user.getUsername());
		try {
			if (user.getPassword().equals(authorized.getPassword())) {

				HttpSession session = request.getSession();
				session.setAttribute("user", authorized);
				System.out.println(session.getAttribute("user"));
				return authorized;
			}
		} catch (NullPointerException e) {
			System.out.println("No user");
		}
		return null;
	}
	
	public static boolean logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return true;
	}
	
	public static List<ErsUser> getAll() {
		return uDao.findAll();
	}

}
