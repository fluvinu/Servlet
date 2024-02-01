package application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteFood extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Serveces ser= new Serveces();
		String id =req.getParameter("id");
		
		String rst= ser.deletePro(id);
		
		PrintWriter pw = resp.getWriter();
		
		pw.print("<h1 style ='color:red'>"+rst+"<h1>");
		
//		RequestDispatcher rd = req.getRequestDispatcher("view");
		resp.sendRedirect("/food_management/view");
		
//		rd.include(req, resp);
		
		
	}
}
