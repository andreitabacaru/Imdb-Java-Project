<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="db.utils.others.LoginWeb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creating admin</title>
</head>
<body>
	
	<%
	
		LoginWeb lw = new LoginWeb(request.getParameter("username"), request.getParameter("password"));
		lw.createAdmin();
	
	%>
	
	<form action="../html/CreateAdmin.html">
		<input type="submit" value="Back to create admin">
	</form>
	
</body>
</html>