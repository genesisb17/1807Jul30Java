package com.iantimothyjohnson.notes.week6.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iantimothyjohnson.notes.week6.beans.User;
import com.iantimothyjohnson.notes.week6.services.UserService;

// This controller won't work unless we comment out the @RestController
// attribute on UserController.
@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	// See how we can use an HttpSession in a Spring controller. We can also
	// specify the full path here and not in the @Controller annotation.
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(HttpSession s) {
		if (s.getAttribute("user") == null) {
			// Not logged in. Redirect the user to the home page.
			return "home";
		} else {
			// Redirect to user home view.
			return "landing";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, HttpSession s) {
		// Consult service layer and log in.
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User u = userService.login(username, password);
		if (u == null) {
			return "redirect:home";
		}
		// Successful login.
		s.setAttribute("user", u);
		return "redirect:home";
	}
}
