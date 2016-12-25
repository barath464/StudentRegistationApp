<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<h3>Select any following task</h3>
	<a href="Save.html">Save</a>
	<br>
	<br>
	<a href="Search.html">Search</a>
	<br>
	<br>
	<a href="Remove.html">Remove</a>
	<br>
	<hr>
	<form action="Logout">
		<input type="submit" value="logout">
	</form>
</body>
</html>