package com.servlet.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.ex.pojos.User;

@WebServlet("/home")

public class HomeServlet extends HttpServlet{
	//get username and make a home page for them
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		
		User u = (User) session.getAttribute("user");
		
		if(u == null) {
			resp.sendRedirect("login");
		} else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			String html = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Exploring Servlets</title>\r\n" + 
					" 	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" \r\n" + 
					" 	integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" \r\n" + 
					" 	crossorigin=\"anonymous\">\r\n" + 
					"    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" \r\n" + 
					"    integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" \r\n" + 
					"    crossorigin=\"anonymous\"></script>\r\n" + 
					"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" \r\n" + 
					"    integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" \r\n" + 
					"    crossorigin=\"anonymous\"></script>\r\n" + 
					"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" \r\n" + 
					"    integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" \r\n" + 
					"    crossorigin=\"anonymous\"></script>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"<div class =\"jumbotron\">\r\n" + 
					"	<h1><i>Welcome " + u.getUsername() + "</i></h1>\r\n" + 
					"</div>\r\n" + 
					"</body>\r\n" + 
					"</html>";
			out.println(html);
		}
	}
}
