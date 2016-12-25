package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.bean.Student;
import com.student.bean.StudentSearchCriteria;
import com.student.service.StudentService;
import com.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentSearch
 */
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
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

	private StudentService studentService;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchStudent() {
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
		HttpSession session = request.getSession();
		PrintWriter p = response.getWriter();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.html");
		} else {
			String sname = request.getParameter("sname");
			int sage = Integer.parseInt(request.getParameter("sage"));

			ArrayList<Student> studentDetails = new ArrayList<Student>();
			try {
				
				StudentSearchCriteria criteria = new StudentSearchCriteria();
				criteria.setName(sname);
				criteria.setAge(sage);
				studentService = new StudentServiceImpl();
				studentDetails = (ArrayList<Student>) studentService.search(criteria);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (studentDetails != null && studentDetails.size() > 0) {
				session.setAttribute("StudentList", studentDetails);
				response.sendRedirect("SearchDisplay.jsp");
				System.out.println("search successful ");
			} else {
				p.println("<h3><b><i>There is no search result for the given criteria<i><b><h3>");
			}
		}

	}

}
