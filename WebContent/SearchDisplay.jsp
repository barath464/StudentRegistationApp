<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="com.student.bean.Student"%>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.List"%>
	<%
		ArrayList<Student> al = null;
		al = (ArrayList<Student>) session.getAttribute("StudentList");
		for (Student s : al) {
			out.println(s);
		}
	%>
	<hr>
	<a href="firstpage.jsp"> Home </a>
	<br>
	<br>
</body>
<form action="Logout">
	<input type="submit" value="logout">
</form>
</body>
</html>