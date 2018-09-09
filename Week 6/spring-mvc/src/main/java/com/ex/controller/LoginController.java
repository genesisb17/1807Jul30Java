package com.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.beans.User;
import com.ex.service.UserService;

//controllers abstract servlets so any functions in a servlet 
//is still apart of controllers
@Controller
public class LoginController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomePage(HttpSession s) {
		
		if(s.getAttribute("user") == null) {
			return "home";	
		}
		else {
			//redirect to user home view
			return "landing";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
			System.out.println("IN LOGIN POST METHOD");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			User u = service.login(username, password);
			
			if(u == null) {
				return "redirect:home";
			}
			else {
				HttpSession session = req.getSession();
				session.setAttribute("user", u);
				return "redirect:home";
			}
	}
}
