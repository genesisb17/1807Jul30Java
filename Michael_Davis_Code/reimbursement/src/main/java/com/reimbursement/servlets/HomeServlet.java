package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.reimbursement.pojos.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		User u = (User) session.getAttribute("user");
		
		
		
		
		if(u == null) {
			//invalid session. take to login
			resp.sendRedirect("login");
		}
		
		else if(u.getUserrole()==2) {
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			
			
			String htmlx="<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Reimbursement Home</title>\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\"\r\n" + 
					"	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\"\r\n" + 
					"	integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\"\r\n" + 
					"	crossorigin=\"anonymous\">\r\n" + 
					"<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\r\n" + 
					"	integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n" + 
					"	crossorigin=\"anonymous\"></script>\r\n" + 
					"<script\r\n" + 
					"	src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"\r\n" + 
					"	integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"\r\n" + 
					"	crossorigin=\"anonymous\"></script>\r\n" + 
					"<script\r\n" + 
					"	src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"\r\n" + 
					"	integrity=\"sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T\"\r\n" + 
					"	crossorigin=\"anonymous\"></script>\r\n" + 
					"</head>\r\n" + 
				
					"<body style=\"background-color:coral\">\r\n" + 
			
					"<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\" id=\"xxxx\" visibility=\"visible\">" + 
					"  <a class=\"navbar-brand\" href=\"#\">Reimbursements</a>\r\n" + 
					"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
					"    <span class=\"navbar-toggler-icon\"></span>\r\n" + 
					"  </button>\r\n" + 
					"  <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\r\n" + 
					"    <div class=\"navbar-nav\">\r\n" + 
					"      <a class=\"nav-item nav-link active\" id=\"homeNav\">Home<span class=\"sr-only\">(current)</span></a>\r\n" + 
					"      <a class=\"nav-item nav-link\" id=\"createNav\">New Reimbursement</a>\r\n" + 
					"      <a class=\"nav-item nav-link\" id=\"viewmyNav\" >View my Reimbursements</a>\r\n" + 
					
					"      <a class=\"nav-item nav-link\" id=\"logoutNav\" >Logout</a>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"</nav>\r\n" + 
					"\r\n" + 
				
					"	<div class=\"jumbotron\" id=\"xxx\" style=\"visibility:visible\">\r\n" + 
					"		<h2><i>We're here to help you "+u.getUsername()+" :)</i> </h2>\r\n" + 
					"</div>\r\n" + 
					"<div class=\"jumbotron\" id=\"view\"></div>"+
					
					"<table class=\"table table-sm table-hover table-bordered thead-light\" id=\"hider1\" style=\"visibility:hidden\">"+ 
					"	<thead>\r\n" + 
					"		<tr>\r\n" + 
					"			<th scope=\"col\">UserName</th>\r\n" + 
					"			<th scope=\"col\">Email</th>\r\n" + 
					"			<th scope=\"col\">Role 1=Employee 2=Manager</th>\r\n" + 
					"		</tr>\r\n" + 
					"	</thead>\r\n" + 
					"	<tbody id=\"userTable\">\r\n" + 
					"	</tbody>\r\n" + 
					"</table>\r\n" + 
				
					
"<table class=\"table table-sm table-hover table-bordered thead-light\" id=\"hider\" style=\"visibility:hidden\">"+ 
					"	<thead>"+
					"		<tr>\r\n" + 
					"			<th scope=\"col\">Reimbursement ID</th>\r\n" + 
					"			<th scope=\"col\">Amount</th>\r\n" + 
					"			<th scope=\"col\">Submitted Date/Time</th>\r\n" + 
					"			<th scope=\"col\">Resolved Time</th>\r\n" + 
					"			<th scope=\"col\">Description</th>\r\n" + 
	
					"			<th scope=\"col\">Author</th>\r\n" + 
					"			<th scope=\"col\">Resolver</th>\r\n" + 
					"			<th scope=\"col\">StatusId</th>\r\n" + 
					"			<th scope=\"col\">Type</th>\r\n" + 
					"		</tr>\r\n" + 
					"	</thead>\r\n" + 
					"	<tbody id=\"reimbursementsTable\">\r\n" + 
					"	</tbody>\r\n" + 
					"</table>\r\n" + 
					
					"\r\n" + 
					"</body>\r\n" + 
					"<script src=\"js/Reimbursement.js\" type=\"text/javascript\"></script>\r\n" + 
					"</html>";
			
			
			//String html2 = "<table class=\"table table-sm table-hover table-bordered thead-light\" id=\"hider1\" style=\"visibility:hidden\">";
			out.write(htmlx);
			
		}
		else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			
			
			String html="<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Reimbursement Home</title>\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\"\r\n" + 
					"	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\"\r\n" + 
					"	integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\"\r\n" + 
					"	crossorigin=\"anonymous\">\r\n" + 
					"<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\r\n" + 
					"	integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n" + 
					"	crossorigin=\"anonymous\"></script>\r\n" + 
					"<script\r\n" + 
					"	src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"\r\n" + 
					"	integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"\r\n" + 
					"	crossorigin=\"anonymous\"></script>\r\n" + 
					"<script\r\n" + 
					"	src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"\r\n" + 
					"	integrity=\"sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T\"\r\n" + 
					"	crossorigin=\"anonymous\"></script>\r\n" + 
					"</head>\r\n" + 
				
					"<body>\r\n" + 
			
					"<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\" id=\"xxxx\" visibility=\"visible\">" + 
					"  <a class=\"navbar-brand\" href=\"#\">Reimbursements</a>\r\n" + 
					"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
					"    <span class=\"navbar-toggler-icon\"></span>\r\n" + 
					"  </button>\r\n" + 
					"  <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\r\n" + 
					"    <div class=\"navbar-nav\">\r\n" + 
					"      <a class=\"nav-item nav-link active\" id=\"homeNav\">Home<span class=\"sr-only\">(current)</span></a>\r\n" + 
					"      <a class=\"nav-item nav-link\" id=\"createNav\">New Reimbursement</a>\r\n" + 
					"      <a class=\"nav-item nav-link\" id=\"viewAllNav\" >View All Reimbursements</a>\r\n" + 
					"      <a class=\"nav-item nav-link\" id=\"viewusersNav\">View Users</a>\r\n" + 
					"      <a class=\"nav-item nav-link\" id=\"logoutNav\" >Logout</a>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"</nav>\r\n" + 
					"\r\n" + 
				
					"	<div class=\"jumbotron\" id=\"xxx\" style=\"visibility:visible\">\r\n" + 
					"		<h2><i>We're here to help you "+u.getUsername()+" :)</i> </h2>\r\n" + 
					"</div>\r\n" + 
					"<div class=\"jumbotron\" id=\"view\"></div>"+
					
					"<table class=\"table table-sm table-hover table-bordered thead-light\" id=\"hider1\" style=\"visibility:hidden\">"+ 
					"	<thead>\r\n" + 
					"		<tr>\r\n" + 
					"			<th scope=\"col\">UserName</th>\r\n" + 
					"			<th scope=\"col\">Email</th>\r\n" + 
					"			<th scope=\"col\">Role 1=Employee 2=Manager</th>\r\n" + 
					"		</tr>\r\n" + 
					"	</thead>\r\n" + 
					"	<tbody id=\"userTable\">\r\n" + 
					"	</tbody>\r\n" + 
					"</table>\r\n" + 
				
					
"<table class=\"table table-sm table-hover table-bordered thead-light\" id=\"hider\" style=\"visibility:hidden\">"+ 
					"	<thead>"+
					"		<tr>\r\n" + 
					"			<th scope=\"col\">Reimbursement ID</th>\r\n" + 
					"			<th scope=\"col\">Amount</th>\r\n" + 
					"			<th scope=\"col\">Submitted Date/Time</th>\r\n" + 
					"			<th scope=\"col\">Resolved Time</th>\r\n" + 
					"			<th scope=\"col\">Description</th>\r\n" + 
	
					"			<th scope=\"col\">Author</th>\r\n" + 
					"			<th scope=\"col\">Resolver</th>\r\n" + 
					"			<th scope=\"col\">StatusId</th>\r\n" + 
					"			<th scope=\"col\">Type</th>\r\n" + 
					"		</tr>\r\n" + 
					"	</thead>\r\n" + 
					"	<tbody id=\"reimbursementsTable\">\r\n" + 
					"	</tbody>\r\n" + 
					"</table>\r\n" + 
					
					"\r\n" + 
					"</body>\r\n" + 
					"<script src=\"js/Reimbursement.js\" type=\"text/javascript\"></script>\r\n" + 
					"</html>";
			
			
			String html2 = "<table class=\"table table-sm table-hover table-bordered thead-light\" id=\"hider1\" style=\"visibility:hidden\">";
			out.write(html);
		}
	}

}