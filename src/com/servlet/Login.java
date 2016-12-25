package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstPage
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		if (uname.equals("admin") && upassword.equals("system")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("password", upassword);
			response.sendRedirect("firstpage.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
