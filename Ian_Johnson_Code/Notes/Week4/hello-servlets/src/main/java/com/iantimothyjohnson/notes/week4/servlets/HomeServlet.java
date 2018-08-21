package com.iantimothyjohnson.notes.week4.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iantimothyjohnson.notes.week4.pojos.User;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			// Invalid session; take to login.
			resp.sendRedirect("login");
			return;
		}
		PrintWriter pw = resp.getWriter();
		String html = "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>Exploring Servlets</title>\n" + 
				"<link rel=\"stylesheet\"\n" + 
				"	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\n" + 
				"	integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\"\n" + 
				"	crossorigin=\"anonymous\">\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"	<h1>Hello, " + user.getUsername() + "!</h1>\n" + 
				"   <a href=\"logout\">Log out</a>" +
				"	<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n" + 
				"		integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n" + 
				"		crossorigin=\"anonymous\"></script>\n" + 
				"	<script\n" + 
				"		src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"\n" + 
				"		integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"\n" + 
				"		crossorigin=\"anonymous\"></script>\n" + 
				"	<script\n" + 
				"		src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"\n" + 
				"		integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\"\n" + 
				"		crossorigin=\"anonymous\"></script>\n" + 
				"</body>\n" + 
				"</html>\n";
		resp.setContentType("text/html");
		pw.print(html);
	}
}
