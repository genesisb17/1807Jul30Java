/**
 * 
 */
package com.servlet.ex;

/**
 * @author virathc
 *
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HTTP SERVLET EXAMPLE

public class HelloHttpServlet extends HttpServlet{
    
    
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
        System.out.println("IN  HTTP SERVLET INIT");
    }
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
        System.out.println("Http destroy()");
    }
    
    //get method
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            String info = getServletConfig().getInitParameter("info");
            out.write("<h1> Hello <b> Kenneth</b> ! </h1>"
            		+ "<br> Random init params: <i>" + info +"<i>");
    }
    
    //post method
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        PrintWriter out = resp.getWriter();
        out.write("IN HTTPSERVLET POST METHOD");
    }

} 