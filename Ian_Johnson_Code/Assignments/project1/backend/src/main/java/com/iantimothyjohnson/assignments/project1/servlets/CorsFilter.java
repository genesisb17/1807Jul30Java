package com.iantimothyjohnson.assignments.project1.servlets;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A filter that deals with adding the appropriate CORS headers to responses.
 * 
 * @author Ian Johnson
 */
@WebFilter("*")
public class CorsFilter implements Filter {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.trace("Initializing CorsFilter.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.addHeader("Access-Control-Allow-Origin",
            "http://localhost:4200");
        httpResponse.addHeader("Access-Control-Allow-Methods",
            "GET, POST, HEAD, OPTIONS");
        httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");
        httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
        
        if (httpRequest.getMethod().equals("OPTIONS")) {
            httpResponse.setStatus(HttpServletResponse.SC_ACCEPTED);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.trace("Destroying CorsFilter.");
    }
}
