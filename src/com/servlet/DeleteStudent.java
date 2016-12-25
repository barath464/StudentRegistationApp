package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.bean.Student;
import com.student.service.StudentService;
import com.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;

	/**
	 * @return the studentService
	 */
	public StudentService getStudentService() {
		return studentService;
	}

	/**
	 * @param studentService
	 *            the studentService to set
	 */
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.html");
		} else {
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			int sage = Integer.parseInt(request.getParameter("sage"));
			int smarks = Integer.parseInt(request.getParameter("smarks"));
			Boolean b = null;
			try {
				Student student = new Student(sid, sname, sage, smarks);
				studentService = new StudentServiceImpl();
				b = studentService.delete(student);
				if (b==true) {
					response.sendRedirect("DeleteDisplay.jsp");
				} else {
					p.println("<h3><b><i>No such records exists <i><b><h3>");
					p.println("<hr><a href='firstpage.jsp'>Home</a>");
					p.println("<br><br><form action='Logout'><input type='submit' value='logout'></form>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			

		}

	}

}
