<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="db.utils.filme.UpdateMovieWeb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating movie</title>
</head>
<body>
	
	<%
		
		new UpdateMovieWeb(request.getParameter("titleMovieToBeUpdated"), request.getParameter("titleMovie"), request.getParameter("releaseYearMovie"), request.getParameter("productionMovie"), request.getParameter("runTimeMovie"));
	
	%>
	
	<form action="../html/Update.html" method="post">
		<input type="submit" value="Back to update">
	</form>
	
</body>
</html>