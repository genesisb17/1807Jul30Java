package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static String process(HttpServletRequest req,HttpServletResponse resp) {
		
		switch(req.getRequestURI()) {
		case "/angulardemo/login.ng":
			return null;
		
		
		default:
			return "not yet implemented";
		
		}
	}

}
