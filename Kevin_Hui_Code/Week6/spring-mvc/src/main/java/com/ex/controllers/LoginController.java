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

	@Autowired
	private UserService service;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(HttpSession s) {
		if (s.getAttribute("user") == null) {
			return "home";
		} 
		return "landing";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		
		User u = service.login(username, password);
		if(u == null) {
			return "redirect:home";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			return "landing";
		}
		
	}
}
