package com.rev.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojo.Book;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if (u == null) {
			resp.sendRedirect("login");
		} else {
			PrintWriter pw = resp.getWriter();
			resp.setContentType("text/html");
			String html = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Insert title here</title>\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic-bootstrap.min.css\" />\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css\" integrity=\"sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B\" crossorigin=\"anonymous\">\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<div class=\"jumbotron\">\r\n" + 
					"		<h1>Welcome" + u.getUser() + "</h1>\r\n" + 
					"		<form method=\"post\" action=\"logout\">\r\n" + 
					  
					"			<input type=\"submit\" value=\"logout\">\r\n" + 
					"		</form>\r\n" + 
					"	</div>\r\n" + 
					"</body>\r\n" + 
					"</html>";
			pw.write(html);
		}
	}

}

