package com.ex.servlets;

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

import com.ex.pojos.User;
import com.ex.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	
	static UserService uService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		PrintWriter pw = resp.getWriter();
//		System.out.println("in doGet method");
		
		List<User> users = uService.findAllUsers();
		if(users.size()>0) {
			// return books
			
			// JACKSON API
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(users);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		} else {
			resp.setStatus(404);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("This is post data!");
        
        String json = "";
        ObjectMapper mapper = null;
        BufferedReader br = new BufferedReader(new InputStreamReader( req.getInputStream() ));
        
        if (br != null) {
            json = br.readLine();
        }
        
        System.out.println(json);
        
        mapper = new ObjectMapper();
        
        User userObj = mapper.readValue(json, User.class);	// json must be all on one line
        
        System.out.println(userObj.toString());
        
        uService.addUser(userObj);
		
	}
	
	
}
