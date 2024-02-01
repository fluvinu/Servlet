<%@page import="java.util.List"%>
<%@page import="NoteApp.Note"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% int nid = Integer.parseInt(request.getParameter("id"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		String title="defalt";
		String note="defalt";
		String uname="defalt";
		
		List<Note> nr = (List<Note>) request.getAttribute("upnote");
		
		for(Note n:nr){
			title=n.getN_title();
			note=n.getNote();
			uname=n.getUser();
		}
		
		
	%>
	<center><h1> update page</h1>
	<form action="updatesave">
		<input type="number" readonly="readonly" name=nid value=<%=nid %>><br>
		<input type="number" readonly="readonly" name=uid value=<%=uid %>> <br>
		<input type ="text" readonly="readonly" name ="uname" value=<%=uname %>> <br>
		<input ype="text" name ="title" value =<%=title %>><br>
		<input ype="text" name ="note" value =<%=note %>><br>
		<input type = "submit">
	</form>
	</center>
</body>
</html>