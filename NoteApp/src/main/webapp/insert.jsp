<%@page import="NoteApp.Note"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<% 
			String uname=request.getParameter("uname");
		%>
		<center>
		<h1> insert page</h1>
			<form action="insert">
				<input type="text" name="title" placeholder="enter title "> <br>
				<input type="text" name="note" placeholder=" enter yor note"> <br>
				 user name <input type="text" name="uname" readonly="readonly" value=<%=uname %> >
				 <input type="submit">
			</form>
		</center>
</body>
</html>