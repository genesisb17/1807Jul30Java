/**
 * 
 */
package com.servlex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author virathc
 *
 */
public class HelloServlets extends GenericServlet{
	public void service(ServletRequest req, 
			ServletResponse res) throws ServletException, IOException {
		System.out.println("--- IN HELLOSERVLET service()");
		
		PrintWriter writer = res.getWriter();
		writer.println("HELLO WORLD! WELCOME TO JAVA SERVLETS!");

	}

}
