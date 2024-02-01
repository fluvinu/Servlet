package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Services;
import dto.Product;

@WebServlet("/insertdata")
public class insertdata extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Services ser= new Services();
		String id = req.getParameter("pId");
		String name = req.getParameter("pname");
		String price = req.getParameter("price");
		String type = req.getParameter("type");	
		int Iid= Integer.parseInt(id);
		double dPrce=Double.parseDouble(price);
		Product pro= new Product(Iid, name, dPrce, type);
		int b = ser.insert(pro);
		resp.setContentType("text/html");
		System.out.println(b+" row inserteed");
		resp.getWriter().print(b+" inserted row");
		
		RequestDispatcher rd=req.getRequestDispatcher("view");
//		rd.forward(req, resp);
		rd.include(req, resp);
	}
	
}
