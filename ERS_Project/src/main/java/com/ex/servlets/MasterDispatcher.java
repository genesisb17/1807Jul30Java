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
		case "/ERS_Project/alltable.ng":
			return UserServices.allTable(request, response);
		case "/ERS_Project/pendingtable.ng":
			return UserServices.pendingTable(request, response);
		case "/ERS_Project/approvedtable.ng":
			return UserServices.approvedTable(request, response);
		case "/ERS_Project/deniedtable.ng":
			return UserServices.deniedTable(request, response);
		case "/ERS_Project/submitrequest.ng":
			return UserServices.submitRequest(request, response);
		case "/ERS_Project/sessioncheck.ng":
			return UserServices.sessionCheck(request, response);
		case "/ERS_Project/logout.ng":
			return UserServices.logout(request, response);
		case "/ERS_Project/updaterequest.ng":
			return UserServices.updateTable(request, response);
		default:
			return "not yet implemented";
		}    	
    }
}
