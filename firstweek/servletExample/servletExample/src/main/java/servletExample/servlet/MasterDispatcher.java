package servletExample.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servletExample.pojo.UserInfo;
import servletExample.service.ReimbursementService;
import servletExample.service.UserService;

public class MasterDispatcher {
	private MasterDispatcher() {
		
	}
	
	public static Object process(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		
		//takes in all incoming requests and handles appropriately
		switch(req.getRequestURI()) {
		
		case "/servletExample/login.ng" :
			UserInfo u = UserService.login(req, resp);
			session.setAttribute("user", u);
			return u;
		case "/servletExample/allusers.ng":
			return UserService.allUsers(req, resp);
		case "/servletExample/reimbursements.ng" :
			return ReimbursementService.reimHistory(req, resp);
		case "/servletExample/allreimbursements.ng" :
			return ReimbursementService.allHistory(req, resp);
		case "/servletExample/create.ng" :
			return UserService.createUser(req, resp);
		case "/servletExample/newReimbursement.ng" :
			return ReimbursementService.createReim(req, resp);
		case "/servletExample/updateReimbursement.ng":
			return ReimbursementService.updateReim(req, resp);
		case "/servletExample/logout.ng":
			System.out.println("hello");
			session.invalidate();
			break;
		default:
				return "not yet implemented";
		}
		return null;
	}
}
