package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.User;

public class EmployeeWelcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user == null) {
			//invalid session. take to login
			response.sendRedirect("login");
		}
		else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			String html = "<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
					"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n" + 
					"    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" \r\n" + 
					"    integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" \r\n" + 
					"    crossorigin=\"anonymous\"></script>\r\n" + 
					"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" \r\n" + 
					"    integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" \r\n" + 
					"    crossorigin=\"anonymous\"></script>\r\n" + 
					"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" \r\n" + 
					"    integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" \r\n" + 
					"    crossorigin=\"anonymous\"></script>\r\n" + 
					"    <title>Employee Welcome</title>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"    <div class=\"jumbotron\">\r\n" + 
					"        <h1>Welcome, " + user.getFirstname() + ", to the Employee Reimbursement System!\"</h1>\r\n" + 
					"        <p>What would you like to do?</p>\r\n" + 
					"        <form method=\"post\" action=\"ViewHistory\">\r\n" + 
					"            <input type=\"submit\" name=\"viewHistory\" value=\"View History\">\r\n" + 
					"        </form>\r\n" + 
					"        <form method=\"post\" action=\"NewSubmission\">\r\n" + 
					"            <input type=\"submit\" name=\"newSubmission\" value=\"Submit new Reimbursement Form\">\r\n" + 
					"        </form>   \r\n" + 
					"    </div>\r\n" + 
					"</body>\r\n" + 
					"</html>";
			out.write(html);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
