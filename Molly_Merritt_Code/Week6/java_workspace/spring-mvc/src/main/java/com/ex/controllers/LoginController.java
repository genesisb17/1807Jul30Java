package com.ex.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.beans.User;
import com.ex.service.UserService;

@Controller
public class LoginController {
	
	static {
		System.out.println("IN LOGIN CONTROLLER");
	}
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomePage(HttpSession s) {
		System.out.println("IN HOMEPAGE GETTING USER");
		if(s.getAttribute("user") == null) {	// have never logged in
			return "home";	// give us that html home page
		} else {
			// redirect to user home view
		} return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
		// consult service layer and log in
		System.out.println("--- IN LOGIN POST METHOD");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User u = service.login(username, password);
		
		if(u==null) {
			return "redirect:home";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			return "redirect:home";
		}
	}

}
