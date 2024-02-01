<%@page import="application.Food"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

	<%  Food f =(Food) request.getAttribute("food") ;%>
	
	<% String color;
		if(f.getFoodDiet().equals("vegetarian")){
			color="green";
		}else{
			color="red";
		}
	
	%>
	
	<div class ="container mt-4 border border-dark">
		<div style ="background-color:<%=color %>" align="center" class="container">
			<h1> <%= f.getFoodName() %></h1>
		</div>
		
		<div align="center" class="container p-5">
			<div class="row">
			
				<div class="col">
					<h4> prepared time is </h4>
						<p> <%= f.getFoodId() %></p>
				</div>
				
				<div class = "col">
					<h4>cook time is </h4>
					 <p> <%=f.getCookTime() %></p>
				</div>
			</div>
		</div>
	
	</div>
	
	<div style="text-align:center" class="container mt-5 ">
		<div class ="row">
			<div class="col">
				<a href=<%= "delete?id="+f.getFoodId() %>><button > delete </button></a>
			</div>
			<div class="col">
				<a href=<%= "update?id="+f.getFoodId() %>><button> update </button></a>
				
			</div>
		</div>
		
		
	
	</div>
	
	
	
</body>
</html>