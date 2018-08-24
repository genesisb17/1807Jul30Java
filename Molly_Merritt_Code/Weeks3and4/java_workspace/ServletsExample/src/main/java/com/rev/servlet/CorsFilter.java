package com.rev.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CorsFilter
 */
public class CorsFilter implements Filter {

    public CorsFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		System.out.println("Incoming " + httpRequest.getMethod() + " request at " + httpRequest.getRequestURI());
		
		// Don't do this; readLine() is an iterator
//		String json = request.getReader().readLine();
//		System.out.println("Request Body: " + json);
		
		// What filters on the request to the Servlet
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
