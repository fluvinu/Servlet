<%@page import="application.Food"%>
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
	
		<%  List <Food> foodList = (List<Food>) request.getAttribute("foodList"); %>
		
		<table border=1 width="100%" class="e">
			<tr>
				<th> id </th>
				<th> name </th>
				<th> dite </th>
			</tr>
			
			<%! String colrrr="green";%>
			<% for(Food f : foodList) {%>
			
			<% if(f.getFoodDiet().equals("vegetarian")){
				colrrr="green";
			}else{
				colrrr="red";
			}
			%>
				<tr>
					<td> <%=f.getFoodId() %></td>
					<td> <%=f.getFoodName() %></td>
					<td style="background-color:<%=colrrr%>"><center> <%=f.getFoodDiet() %></center> </td>
					<td align="center"><a href=<%= "product?id="+f.getFoodId() %>> <button type="button"  style="background-color:<%=colrrr%> "> VIEW PRODUCT</button></a></td>
				</tr>
			
			<%} %>
		</table>
</body>
</html>