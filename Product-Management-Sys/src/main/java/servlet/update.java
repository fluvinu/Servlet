package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Services;
import dto.Product;

@WebServlet("/update")
public class update extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("pname");
		double price=Double.parseDouble(req.getParameter("price"));
		String type=req.getParameter("type");
		
		Product p=new Product(id, name, price, type);
		Services ser=new Services();
		int n = ser.updateProduct(p);
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.print(n+" row updated");
		RequestDispatcher rd=req.getRequestDispatcher("view");
		rd.include(req, resp);
	}
}
