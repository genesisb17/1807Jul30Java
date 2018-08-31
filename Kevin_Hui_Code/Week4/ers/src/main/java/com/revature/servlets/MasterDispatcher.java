package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.ErsReimbursementService;
import com.revature.service.ErsUserService;

public class MasterDispatcher {
	private MasterDispatcher() {
	}

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		
		switch (request.getRequestURI()) {
		case "/ers/login.ng":
			return ErsUserService.login(request, response);
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
