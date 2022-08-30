
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="db.utils.actor.web.InsertActorWeb" %>

<!DOCTYPE html>
<html>
<body>
	
	<%
		Class.forName("com.mysql.jdbc.Driver");
		
		new InsertActorWeb(request.getParameter("nume"), request.getParameter("prenume"), request.getParameter("dataNasterii"), request.getParameter("sex"));
		
	%>
	
	<form action="../html/Insert.html" method="post">
		<input type="submit" value="Back to insert">
	</form>
	
</body>
</html>