package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/product")
public class ViewFood extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Serveces ser= new Serveces();
		
		String id = req.getParameter("id");
				
		Food fod= ser.getFoodById(id);
		
		req.setAttribute("food", fod);
		
		RequestDispatcher rd= req.getRequestDispatcher("product.jsp");
		rd.forward(req, resp);
	}
}
