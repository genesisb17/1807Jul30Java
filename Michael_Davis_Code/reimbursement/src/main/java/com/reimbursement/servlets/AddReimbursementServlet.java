package com.reimbursement.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;
import com.reimbursement.service.*;

@WebServlet("/addReimbursement")
public class AddReimbursementServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//REQUEST DISPATCHER! Used for forwarding
		//req.getRequestDispatcher("partials/addReimbursementView.html").forward(req, resp);
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		
		PrintWriter out = resp.getWriter();
		//System.out.println(u.getUserid());
		resp.setContentType("text/html");
		
		//String html2="<input type=\"number\" name=\"amount\" class=\"form-control\" step=\".01\" placeholder=\"Reimbursement Amount\">"
		String html="<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>New Reimbursement</title>\r\n" + 
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
				"	<div class=\"jumbotron\">\r\n" + 
				"		<h1>Hello "+u.getUsername() + " ,please fill out the fields below for your Reimbursement</h1>\r\n" + 
				"		<br>\r\n" + 
				"		<form method=\"post\" action=\"addReimbursement\">\r\n" + 
				"		<!-- amount,submitted,resolved,description,receipt,author,resolver,statusid,typeid -->\r\n" + 
				"<input type=\"number\" name=\"amount\" class=\"form-control\" step=\".01\" placeholder=\"Reimbursement Amount\">\r\n" + 
				"			<input type=\"text\" name=\"description\" class=\"form-control\" placeholder=\"Description\">\r\n" + 
				"	\r\n" + 
				" <fieldset>\r\n" + 
				"        <legend>Select a Reimbursement Type</legend>\r\n" + 
				"\r\n" + 
				"        <div>\r\n" + 
				"            <input type=\"radio\" id=\"food\" name=\"type\" value='3' />\r\n" + 
				"            <label for=\"food\">Food</label>\r\n" + 
				"        </div>\r\n" + 
				"\r\n" + 
				"        <div>\r\n" + 
				"            <input type=\"radio\" id=\"lodging\" name=\"type\" value='1' />\r\n" + 
				"            <label for=\"lodging\">Lodging</label>\r\n" + 
				"        </div>\r\n" + 
				"\r\n" + 
				"        <div>\r\n" + 
				"            <input type=\"radio\" id=\"travel\" name=\"type\" value='2' />\r\n" + 
				"            <label for=\"travel\">Travel</label>\r\n" + 
				"        </div>\r\n" + 
				"        <div>\r\n" + 
				"            <input type=\"radio\" id=\"other\" name=\"type\" value=4 />\r\n" + 
				"            <label for=\"other\">Other</label>\r\n" + 
				"        </div>\r\n" + 
				"\r\n" + 
				"    </fieldset>\r\n" + 
				"				<input type=\"submit\" value=\"addReimbursement\">\r\n" + 
				"		</form>\r\n" + 
				"	</div>\r\n" + 
				"</body>\r\n" + 
				"<script src=\"js/Reimbursement.js\" type=\"text/javascript\"></script>\r\n" + 
				"</html>";
		out.write(html);
		
	}
	

	static ReimbursementService reimbService=new ReimbursementService();
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		//functionality to get info from login form 
		Double amount;
		Integer type;
		String amt = req.getParameter("amount");
		String description = req.getParameter("description");
		
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		
		amount=Double.parseDouble(amt);
		String tp=req.getParameter("type");
		type=Integer.parseInt(tp);
		//System.out.println(type);
		
		Reimbursement a=new Reimbursement(amount,description,type);
		a.setAuthor(u.getUserid());
		a.setStatusid(1);
		a.setResolver(2);
		
		reimbService.save(a);
		resp.sendRedirect("home");
		
		//System.out.println("LOGGING IN USER " + name  + ":" + pass);
		
		//System.out.println(uService.getByUsername(name));
		//User u = uService.getByUsername(name);
		/*
		PrintWriter out = resp.getWriter();
		System.out.println("Printing out user returned :"+u);
		if(u == null) {
			//System.out.println("inside null uname block");
			out.write("This user does not Exist");
			resp.sendRedirect("login");
			
			
		}
		else if(!u.getUserpassword().equals(pass)) {
			out.println("Sorry, invalid passsword");
		
		}
		else {
			//valid login getSession() - returns 
			//current session or creates new one if none exists
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			System.out.println(session.getAttribute("user"));
			
			//System.out.println(session.getAttribute("user").getClass().getName().toString());
			//out.println("Welcome, " + name + "!");
			resp.sendRedirect("home");
		}
	
	*/
	}
	

}