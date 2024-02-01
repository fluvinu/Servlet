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
	
	<form action="save">
	
	<% Food f=(Food) request.getAttribute("food") ;%>
	<input name="id" type="number" hidden value=<%=f.getFoodId()  %>>
	<input name="dite" type="text" hidden value=<%=f.getFoodDiet()  %>>
	
	<div align="center" class="mt-5"> <h1> update form !!</h1></div>
	<div class = "container mt-5 p-5 border ">
	
		<div class="row">
			<input name="pName" type="text" value=<%= f.getFoodName() %>>
		</div>
		
		
		
		<div align="center" class="row mt-4">
			<div class="col">
				<input name="pTime" type="number" value=<%=f.getPreptime() %>>
			</div>
			
			<div class="col">
				<input name="cTime" type="number" value=<%=f.getCookTime() %>>
			</div>
		</div>
		
		
		
		
		
		<div class="row mt-4">
			<input name="ingre" type="textarea" value=<%=f.getFoodIngredients() %>>
		</div>
		
		
		
		
		
		
		<div align="center" class="row mt-4" >
			<div class="col">
				<input name="flavorP" type="text" value=<%=f.getFlavorProfile() %>>
			</div>
			
			<div class="col">
				<input name="course" type="text" value=<%=f.getFoodCourse() %>>
			</div>
			
			<div class="col">
				<input name="stateR" type="text" value="<%=f.getRegion()+","+f.getState() %>">
				
			</div>
		</div>
	
	</div>
	
	
	
	<div align="center" > <button class="suss" type="submit"> save </button>  </div>
	
	</form>
</body>
</html>