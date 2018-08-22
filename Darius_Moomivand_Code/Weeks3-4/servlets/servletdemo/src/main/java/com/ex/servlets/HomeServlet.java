package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ex.pojos.User;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= req.getSession();
		
		User u = (User) session.getAttribute("ser");
		if(u == null) {
			resp.sendRedirect("login");
		}
		else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			String html ="<!DOCTYPE html>\n" + 
					"<html>\n" + 
					"<head>\n" + 
					"<meta charset=\"UTF-8\">\n" + 
					"<title>Insert title here</title>\n" + 
					"\n" + 
					"\n" + 
					"<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" + 
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n" + 
					"<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n" + 
					"\n" + 
					"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" + 
					"\n" + 
					"\n" + 
					"</head>\n" + 
					"<body>\n" + 
					"\n" + 
					"<div class=\"jumbotron\">\n" + 
					"	<h1><i>Welcome, " + u.getUsername() + "</i></h1>\n" + 
					"	<br>\n" + 
					"	<form method=\"post\" \"login\">\n" + 
					"		<input type=\"text\" name=\"username\" class=\"form-control\">\n" + 
					"		<input type=\"password\" name=\"password\" class=\"form-control\">\n" + 
					"		<input type=\"submit\" value=\"Go!\">\n" + 
					"	\n" + 
					"	</form>\n" + 
					"	\n" + 
					"</div>\n" + 
					"\n" + 
					"\n" + 
					"</body>\n" + 
					"</html>";
			}
	}

}
