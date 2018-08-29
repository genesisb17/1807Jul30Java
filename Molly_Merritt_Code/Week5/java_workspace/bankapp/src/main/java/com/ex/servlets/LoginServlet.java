package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.data.UserRepository;
import com.ex.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	static UserRepository repo = new UserRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
//		String json = "";
//		while(br!=null) {
//			json += br.readLine();	// json strings has newlines
//		}	// [username, password]
		
		ObjectMapper mapper = new ObjectMapper();
		String[] info = mapper.readValue(req.getReader(), String[].class);
		
		User u = repo.findByUsername(info[0]);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		if(u==null) {
			// write null
			out.write("null");	// in json, "null" is still null
		} else {
			if(u.getPassword().equals(info[1])) {
				// write object
				out.write(mapper.writeValueAsString(u));
			} else {
				// write null
				out.write("null");
			}
		}
		
	}

}
