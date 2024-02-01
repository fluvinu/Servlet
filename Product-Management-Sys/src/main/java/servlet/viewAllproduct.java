package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Services;
import dto.Product;

@WebServlet("/view")
public class viewAllproduct extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Services ser = new Services();
		
		List<Product> prolist= ser.displayAllProduct();
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<table border=1>");
			out.print("<tr>");
				out.print("<th> id </th>");
				out.print("<th> name </th>");
				out.print("<th> price </th>");
				out.print("<th> type </th>");
			out.print("</tr>");
			
			for(Product p :prolist) {
				out.print("<tr>");
					out.print("<td>"+p.getpId()+"</td>");
					out.print("<td>"+p.getpName()+"</td>");
					out.print("<td>"+p.getPrice()+"</td>");
					out.print("<td>"+p.getType()+"</td>");
				out.print("</tr>");
			}
			
		out.print("</table>");
	}
	
	

}
