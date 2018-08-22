package servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlets.pojo.User;
import servlets.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	static UserService us = new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		System.out.println("logging in" + name + pass);
		
		User u = us.getUsers(name);
		PrintWriter pw = resp.getWriter();
		if(u == null) {
			//pw.println("sorry not gonna happen");
			resp.sendRedirect("login");
		} else if (!u.getPassword().equals(pass)) {
			pw.println("sorry not gonna happen");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
//			pw.println("welcome" + name);
			resp.sendRedirect("home");
		}
		
	}
}
