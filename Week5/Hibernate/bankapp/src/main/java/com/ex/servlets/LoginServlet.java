package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.beans.User;
import com.ex.data.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	static UserRepository repo = new UserRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		while(br!=null) {
			json += br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String[] info = mapper.readValue(req.getReader(),  String[].class);
		
		User u = repo.findByUsername(info[0]);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		if(u==null) {
			out.write("null");
		} else {
			if(u.getPassword().equals(info[1])) {
				out.write(mapper.writeValueAsString(u));
			} else {
				out.write("null");
			}
		}
	}
}
