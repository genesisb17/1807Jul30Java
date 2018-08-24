package com.iantimothyjohnson.notes.week4.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("*.ng")
public class CorsFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println("Incoming " + req.getMethod() + " request at " + req.getRequestURI());
		
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4300");
		resp.addHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, OPTIONS");
		resp.addHeader("Access-Control-Allow-Headers", "Content-Type");
		if (req.getMethod().equals("OPTIONS")) {
			resp.setStatus(202);
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
