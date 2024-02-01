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

	<%! String user; %>
	<%! String pass; %>
	<% 
	
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");
	
	if(user==null){
		user =(String) request.getAttribute("user");
	}
	
	%>
	
		
	<h1> wrllcome <%=user %></h1>
	<a href=<%= "insert.jsp?uname="+user+""%>> <input type="button" value ="insert" ></a>
	<a href="./"><input type="button" value="logout"></a>
	
	<%  List<Note> userdetail =(List<Note>) request.getAttribute("userdetail"); %>
	
	
	
	<% int count=0; %>
	
	
	<% for(Note n:userdetail){ %>
	<% if(count==0){ %>
	
		
		<div>
			<form action="search">
		<input type="search" name ="sWord" placeholder="search somthig">
		<input type="text" name = "user" readonly="readonly" hidden value=<%= user %>>  
		<input type="submit" value="search">
		</form>
		
		</div>
		
		
		
		
		<table width=100% >
		<th > id </th>
		<th> title </th>
		<th>note </th>
		<th> date</th>
		
		<% count++ ;} %>

		<tr> 
			<td align="center"><%=n.getNid() %></td>
			<td style="text-align: center"><b><%=n.getN_title() %><b></td>
			<td style="text-align: center"><%=n.getNote() %></td>
			<td style="text-align: center"><%=n.getTime() %></td>
			<td style="text-align: center"><a href=<%= "delete?id="+n.getNid()+"&uid="+n.getUser_id() %>><button>delete</button></a></td>
			<td style="text-align: center"><a href=<%= "update?id="+n.getNid()+"&uid="+n.getUser_id() %>> <button>update</button></a></td>
		</tr>	
	
	<%} %>
	
	</table>
	
	
</body>
</html>