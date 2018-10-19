package com.rev.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

    public CorsFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		System.out.println("Incoming " + httpRequest.getMethod() + " request at " + httpRequest.getRequestURI());
		
		httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET,POST,READ");
		httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");
		
		if(httpRequest.getMethod().equals("OPTION")) httpResponse.setStatus(202);
		
		chain.doFilter(httpRequest, httpResponse);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
