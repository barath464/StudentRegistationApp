package com.student.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		HttpSession session = httpServletRequest.getSession();
		if (httpServletRequest.getRequestURI().contains("index") || httpServletRequest.getRequestURI().contains("login")
				|| session.getAttribute("username")!=null) {
			chain.doFilter(request, response);			
		}else if(session.getAttribute("username") == null){
			httpResponse.sendRedirect("index.jsp");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
