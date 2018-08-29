package servletExample.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CoresFilterr implements Filter {
	
    public CoresFilterr() {
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
	}
    
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		System.out.println("Incoming " + httprequest.getMethod() + " request at " + httprequest.getRequestURI());
		
		httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, OPTIONS");
		httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");
		httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
		if(httprequest.getMethod().equals("OPTIONS"))
			httpResponse.setStatus(202);
	

		chain.doFilter(httprequest, httpResponse);
	}

}
