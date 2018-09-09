package com.reimb.servlets;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimb.pojos.Users;
import com.reimb.service.UserService;

@WebServlet("/user")
public class UserServlet extends HttpServlet{
	static UserService us = new UserService();
	
		@Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
	        List<Users> userInfo = us.getAll();

	        if(userInfo.size() > 0) {
	        System.out.println("This is being requested.");
	        //JACKSON API
	        ObjectMapper mapper = new ObjectMapper();
	        String json = mapper.writeValueAsString(userInfo);
	        PrintWriter out = resp.getWriter();
	        resp.setContentType("application/json");
	        out.write(json);
	        } else
	        {
	            resp.setStatus(404);
	        }

	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        //TAKE BOOK JSON STRING AND TURN TO JAVA OBJ

	        BufferedReader br = 
	                new BufferedReader(new InputStreamReader(
	                        req.getInputStream()));
	        String json = "";
	        if(br != null){
	            json = br.readLine();
	        }

	        ObjectMapper mapper = new ObjectMapper();
	        Users b = mapper.readValue(json, Users.class);
	        System.out.println(b.toString());

	        b = us.addUser(b);
	        System.out.println(b.toString());

	        String ret = mapper.writeValueAsString(b);
	        PrintWriter out = resp.getWriter();
	        resp.setContentType("application/json");
	        out.write(ret);

	    }
	
	
}
