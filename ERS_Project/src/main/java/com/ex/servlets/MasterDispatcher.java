package com.ex.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.services.UserServices;

public class MasterDispatcher {

    private MasterDispatcher() {}

    public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ERS_Project/login.ng":
			return UserServices.login(request, response);
		case "/ERS_Project/emptable.ng":
			return UserServices.employeeTable(request, response);
		case "/ERS_Project/submitrequest.ng":
			return UserServices.submitRequest(request, response);
		default:
			return "not yet implemented";
		}    	
    }
}
