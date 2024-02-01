package application;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllProduct extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn= GetConnection.conn;
		Serveces ser= new Serveces();
		 
		List<Food> foodList= ser.getFood();
		
		req.setAttribute("foodList", foodList);
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.include(req, resp);
	
	}
}
