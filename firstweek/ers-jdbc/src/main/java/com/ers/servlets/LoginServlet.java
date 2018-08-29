//package com.ers.servlets;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.ers.pojo.User;
//import com.ers.service.Service;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class LoginServlet extends HttpServlet {
//	
//	static Service s = new Service();
//	@Override
//	public void init() throws ServletException {
//		// TODO Auto-generated method stub
//		super.init();
//	}
//	
//	@Override 	
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String resource = "partials/" + process(req, resp) + ".html";	
//		resp.addHeader("Access-Control-Allow-Origin", "*");
//	
//		req.getRequestDispatcher(resource).forward(req, resp);
//	}
//	
//	
//	
//	
//	
//	
//	
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
//		String json = "";
//		if(br != null) {
//			json = br.readLine();
//			
//		}
//		
//		ObjectMapper mapper = new ObjectMapper();
//		User u = mapper.readValue(json, User.class);
////		System.out.println(u.toString());
//		
////		u = s.findUser(u);
//		
//		String ret = mapper.writeValueAsString(u);
//		PrintWriter pw = resp.getWriter();
//		resp.setContentType("application/json");
//		pw.write(ret);
//	
//	
//	}
//
//	static String process(HttpServletRequest req, HttpServletResponse resp) {
//		
//		switch(req.getRequestURI()) {
//		case "/ers-jdbc/login.view":
//			return "loginView";
//		case "/ers-jdbc/account.view":
//			return "accountView";
//		case "/ers-jdbc/menu.view":
//			return "menuView";
//		case "/ers-jdbc/create.view":
//			return "createView";
//		default:
//			return "errorView";
//		}
//		
//	}
//	
//	
//	
//}
