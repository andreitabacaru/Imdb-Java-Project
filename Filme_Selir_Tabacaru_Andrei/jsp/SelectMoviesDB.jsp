<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="db.utils.filme.SelectMovieWeb" %>
<%@ page import="db.utils.filme.Movie" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/Select_page.css">
<script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>
<meta charset="ISO-8859-1">
<title>Selecting Movies</title>
</head>
<body>
	<%
		
		Class.forName("com.mysql.jdbc.Driver");
		
		SelectMovieWeb smw = new SelectMovieWeb(request.getParameter("titleMovie"), request.getParameter("releaseYearMovie"), request.getParameter("productionMovie"));
	
	%>
	
	<table class="sortable" id="tableMovies">
		<tr>
			<th>Title</th>
			<th>Runtime</th>
			<th>Release year</th>
			<th>Production</th>
		</tr>
		
		<%
			for( Movie m : smw.getSelectedMovies() ) {
		%>
				<tr>
					<td><%= m.getTitle() %></td>
					<td><%= m.getRunTime() %></td>
					<td><%= m.getReleaseYear() %></td>
					<td><%= m.getProductionName() %></td>
				</tr>
		<%
			}
		%>
	</table>
	
	<form action="../html/Select.html" method="post">
		<input type="submit" value="Back to select" id="backButton">
	</form>
	
	<div></div>
</body>
</html>