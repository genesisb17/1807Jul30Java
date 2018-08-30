package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.models.User;
import com.ex.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static UserRepository repo = new UserRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
//		
//		String json = "";
//		while(br != null) {
//			json += br.readLine();
//		} // [username, password]
		
		
		PrintWriter out = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String[] info = mapper.readValue(req.getReader(), String[].class);
		
		resp.setContentType("application/json");
		
		User u = repo.findByUsername(info[0]);
		if (u==null) {
			out.write("null");
		}
		else {
			if(u.getPassword().equals(info[1])) {
				out.write(mapper.writeValueAsString(u));
			}
			else {
				out.write("null");
			}
		}
	}
}
