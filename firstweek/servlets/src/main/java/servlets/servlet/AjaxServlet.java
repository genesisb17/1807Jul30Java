package servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/dostuff")
public class AjaxServlet extends HttpServlet{
	static int counter = 0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String info = req.getContextPath();
		String info2 = req.getProtocol();
		String headers = "";
		
		Enumeration<String> info3 = req.getHeaderNames();
		do  {
			headers+=", ";
			headers+=info3.nextElement();
		} while(info3.hasMoreElements());
		pw.write("REQUEST #" + ++counter +
				"\nContext Path" + info + "\n Protocol" + info2 + "\nHeader Names;" + headers);
	}
	

}
