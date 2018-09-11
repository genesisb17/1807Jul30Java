package com.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.beans.User;
import com.ex.service.UserService;

@Controller
public class LoginController {

	static UserService service = new UserService();
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomePage(HttpSession s) {
		if(s.getAttribute("user")==null) { //never logged in
			return "home.html";
		} else {
			//redirect to home view
		}
		return "landing";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
		//consult service layer and log in
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User u = service.login(username, password);
		if(u == null) {
			return "redirect:home";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			return "redirect:home";
		}
	}
}

