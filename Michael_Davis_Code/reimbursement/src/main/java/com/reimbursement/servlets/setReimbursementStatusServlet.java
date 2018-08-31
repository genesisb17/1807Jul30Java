package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.dao.ReimbursementDao;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;
import com.reimbursement.service.ReimbursementService;

@WebServlet("/setStatus")
public class setReimbursementStatusServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//REQUEST DISPATCHER! Used for forwarding
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		
		if (u.getUserrole()==2) {
			resp.sendRedirect("home");
		}
		else {
		req.getRequestDispatcher("partials/updateReimbursement.html").forward(req, resp);
		
		}
		
		
	}
	

	static ReimbursementService reimbService=new ReimbursementService();
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		
	
		if(u.getUserrole()!=2) {
		String stat=req.getParameter("status");
	
		
		String st = req.getParameter("selected");
		System.out.println(stat);
		System.out.println(st);
		
		int selected;
		int status;
		
		status=Integer.parseInt(stat);
		selected=Integer.parseInt(st);
		
		
		
	
		
		ReimbursementDao d=new ReimbursementDao();
		d.setResolver(selected,u);
		if(status==2) {
		d.setStatus(2, selected);
		}
		if(status==3) {
			d.setStatus(3, selected);
		}
		
		if (status==1){d.setStatus(1, selected);}
		
		else {System.out.println("wut?");}
		}
		resp.sendRedirect("home");
		
	}
	

}