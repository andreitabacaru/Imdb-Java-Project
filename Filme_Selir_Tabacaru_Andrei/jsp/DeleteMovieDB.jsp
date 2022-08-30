<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="db.utils.filme.DeleteMovieWeb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deleting movie</title>
</head>
<body>
	
	<%
		
		new DeleteMovieWeb(request.getParameter("titleMovie"));
	
	%>
	
	<form action="../html/Delete.html" method="post">
		<input type="submit" value="Back to delete">
	</form>
	
</body>
</html>