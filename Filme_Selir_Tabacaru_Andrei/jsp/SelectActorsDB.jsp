<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="db.utils.actor.web.SelectActorWeb" %>
<%@ page import="db.utils.actor.Actor" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/Select_page.css">
<script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>
<meta charset="ISO-8859-1">
<title>Selecting Actors</title>
</head>
<body>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		String actorSex;
		
		if( request.getParameter("sex") == null )
			actorSex = "";
		else
			actorSex = request.getParameter("sex");
		
		SelectActorWeb saw = new SelectActorWeb(request.getParameter("actorNume"), request.getParameter("actorPrenume"), actorSex);
		
		
	%>
  	
	<table class="sortable" id="tableActors">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Date of Birth</th>
			<th>Sex</th>
		</tr>
		
		<%
			for( Actor a : saw.getSelectedActors() ) {
				String name = a.getNume() + " " + a.getPrenume();
				String date = a.getDataNasteriiDate().getYear()+1900 + "/" + ((a.getDataNasteriiDate().getMonth()) + 01) + "/" + ((a.getDataNasteriiDate().getDay()));
		%>	
				<tr>
					<td><%= a.getIdActor() %></td>
					<td><%= name %></td>
					<td><%= date %></td>
					<td><%= a.getSex() %></td>
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