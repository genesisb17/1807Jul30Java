package com.ers.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoresFilter implements Filter {

    
    public CoresFilter() {
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		System.out.println("incoming" + httprequest.getMethod() + " request at " + httprequest.getRequestURI());
		httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, OPTIONS");
		httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");
		if(httprequest.getMethod().equals("OPTIONS"))
			httpResponse.setStatus(202);
	

		chain.doFilter(httprequest, httpResponse);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

