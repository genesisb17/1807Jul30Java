package servletExample.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletExample.service.UserService;

public class MasterDispatcher {
	private MasterDispatcher() {
		
	}
	
	public static Object process(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getRequestURI()) {
			
		case "/servletExample/login.ng" :
			return UserService.login(req, resp);
		
			default:
				return "not yet implemented";
		}
	}
}
