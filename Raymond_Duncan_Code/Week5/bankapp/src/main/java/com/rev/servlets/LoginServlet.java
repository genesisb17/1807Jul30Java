package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.data.UserRepository;
import com.rev.models.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserRepository repo = new UserRepository();

	LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
//		String json = "";
//		while(br!=null) {
//			/*
//			 * This loop is because on occasion users will send json using newline characters. e.g.
//			 * 
//			 * {
//			 * 	username: username,
//			 * 	password: password,
//			 * 	etc.
//			 * }
//			 */
//			
//			json += br.readLine();
//		}
//		
//		ObjectMapper mapper = new ObjectMapper();
//		String[] info = mapper.readValue(json, String[].class);

		ObjectMapper mapper = new ObjectMapper();
		String[] info = mapper.readValue(request.getReader(), String[].class);

		User u = repo.findByUsername(info[0]);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if (u == null) {
			// Write null!
			out.write("null");
		} else if (u.getPassword().equals(info[1])) {
			// Write object
			out.write(mapper.writeValueAsString(u));
		} else {
			// Write null
			out.write("null");
		}
	}

}
