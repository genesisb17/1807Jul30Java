package com.ex.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController
{
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomePage(HttpSession s) 
	{
		if(s.getAttribute("user")==null) //never logged in
		{
			return "home";
		}
		else {
			// redirect to user home view
		}
		return "home";
	}
}
