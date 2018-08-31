package com.revature.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if (user.getPassword().equals(authorized.getPassword()))
			return authorized;
		return null;
	}

}
