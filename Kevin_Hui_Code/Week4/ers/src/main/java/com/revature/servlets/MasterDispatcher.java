package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojo.ErsUser;
import com.revature.service.ErsReimbursementService;
import com.revature.service.ErsUserService;

public class MasterDispatcher {
	private MasterDispatcher() {
	}

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		switch (request.getRequestURI()) {
		case "/ers/login.ng":
			ErsUser user = ErsUserService.login(request, response);
			session.setAttribute("user", user);
			return user;
		case "/ers/logout.ng":
			return ErsUserService.logout(request, response);
		case "/ers/getReimbursementsByUser.ng":
			return  ErsReimbursementService.getReimbursementsByUser(request,response);
		case "/ers/getAllEmployee.ng":
			return  ErsUserService.getAll();
		default:
			return "bad";
		}
	}
}
