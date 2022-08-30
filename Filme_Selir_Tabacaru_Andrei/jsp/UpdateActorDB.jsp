<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="db.utils.actor.web.UpdateActorWeb" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating Actor</title>
</head>
<body>

	<%
		
		Class.forName("com.mysql.jdbc.Driver");
		String actorSex;
		
		if( request.getParameter("sex") == null )
			actorSex = "";
		else
			actorSex = request.getParameter("sex");
		
		UpdateActorWeb uaw = new UpdateActorWeb(request.getParameter("actorId"), request.getParameter("actorNume"), request.getParameter("actorPrenume"), request.getParameter("actorDataNasterii"), actorSex);
	
	%>
	
	<form action="../html/Update.html" method="post">
		<input type="submit" value="Back to update">
	</form>

</body>
</html>