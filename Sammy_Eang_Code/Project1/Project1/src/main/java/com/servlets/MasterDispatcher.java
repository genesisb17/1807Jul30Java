package com.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servicepackage.EmployeeService;
import com.servicepackage.ReimbursementService;

public class MasterDispatcher {

private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		
		case "/Project1/login.ng":
			return EmployeeService.login(request, response);
		case "/Project1/loginJwtHeader.ng":
			return EmployeeService.loginJwtHeader(request, response);
		case "/Project1/loginJwtPayload.ng":
			return EmployeeService.loginJwtPayload(request, response);
		case "/Project1/findBySome.ng":
			return ReimbursementService.findBySome(request, response);
		case "/Project1/submitNew.ng":
			return ReimbursementService.submitNew(request, response);
		case "/Project1/getAllReimb.ng":
			return ReimbursementService.getAllReimb(request, response);
		case "/Project1/updateReimb.ng":
			return ReimbursementService.updateReimb(request, response);
		case "/Project1/getReimbSort.ng":
			return ReimbursementService.getReimbSort(request, response);
		case "/Project1/findReimbByIdSort.ng":
			return ReimbursementService.findReimbByIdSort(request, response);
		case "/Project1/getAllEmp.ng":
			return EmployeeService.getAllEmp(request, response);
		default:
			return "not yet implemented";
		}
		
	}
	
}
