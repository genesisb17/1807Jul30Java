 package com.reimbursement.servlets;
 import com.reimbursement.pojos.User;
import com.reimbursement.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.dao.UserDao;
import com.reimbursement.pojos.*;
import com.reimbursement.service.*;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
	static UserService us=new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = us.getAll();
		
		if(users.size()>0) {
			//return books .
			
			//JACKSON API
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(users);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
			
		}else {
			System.out.println("not getting any users in array");
			resp.setStatus(404);
		}
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//get login info from form
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json= "";
		
		
		if(br != null){
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		User b = mapper.readValue(json, User.class);
		System.out.println(b.toString());
		
		
		
		b =us.addUser(b);
		System.out.println(b.toString());
		
		String ret = mapper.writeValueAsString(b);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(ret);
	}
		
	

}
