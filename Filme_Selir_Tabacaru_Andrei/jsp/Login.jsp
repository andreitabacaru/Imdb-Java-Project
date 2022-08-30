<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="db.utils.others.LoginWeb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checking account..</title>
</head>
<body>
	
	<%
		Class.forName("com.mysql.jdbc.Driver");
	
		LoginWeb lw = new LoginWeb(request.getParameter("username"), request.getParameter("password"));
		
		if( lw.isCorrect() ) {
			response.setStatus(307);
			response.sendRedirect("MainAdmin.jsp");
		} else {
			response.setStatus(307);
			response.sendRedirect("Main.jsp");
		}
	%>
	
</body>
</html>