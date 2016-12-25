package com.servlet;

import java.io.IOException;

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
 * Servlet implementation class Insert
 */
@WebServlet("/InsertStudent")
public class InsertStudent extends HttpServlet {
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
	public InsertStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
		} else {
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			int sage = Integer.parseInt(request.getParameter("sage"));
			int smarks = Integer.parseInt(request.getParameter("smarks"));
			Student s = null;
			try {
				Student student = new Student(sid, sname, sage, smarks);
				studentService = new StudentServiceImpl();
				s = studentService.save(student);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (s != null) {
				response.sendRedirect("InsertDisplay.jsp");
			}
		}

	}

}