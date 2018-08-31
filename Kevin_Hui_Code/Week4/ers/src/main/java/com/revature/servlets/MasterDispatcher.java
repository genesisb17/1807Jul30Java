package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.ErsReimbursementService;
import com.revature.service.ErsUserService;

public class MasterDispatcher {
	private MasterDispatcher() {
	}

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("TEST: " + request.getRequestURI());
		switch (request.getRequestURI()) {
		case "/ers/login.ng":
			return ErsUserService.login(request, response);

		case "/ers/getReimbursement.ng":
			return  ErsReimbursementService.getReimbursement(request,response);
		default:
			return "bad";
		}
	}
}
