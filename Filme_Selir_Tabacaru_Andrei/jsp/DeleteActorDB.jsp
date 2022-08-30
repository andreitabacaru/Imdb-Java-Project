<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="db.utils.actor.ActorDbHelper" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deleting Actor</title>
</head>
<body>
	
	<%
		
		Class.forName("com.mysql.jdbc.Driver");
		ActorDbHelper adh = new ActorDbHelper();
	
		try {
			int idActor = Integer.parseInt(request.getParameter("actorId"));
			adh.deleteActor(idActor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	%>
	
	<form action="../html/Delete.html" method="post">
		<input type="submit" value="Back to delete">
	</form>
	
</body>
</html>