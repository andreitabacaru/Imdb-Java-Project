<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="db.utils.filme.InsertMovieWeb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserting Movie</title>
</head>
<body>
<%
	
	new InsertMovieWeb(request.getParameter("titleMovie"), request.getParameter("runTimeMovie"), request.getParameter("releaseYearMovie"), request.getParameter("productionMovie"));

%>

	<form action="../html/Insert.html" method="post">
		<input type="submit" value="Back to insert">
	</form>
</body>
</html>