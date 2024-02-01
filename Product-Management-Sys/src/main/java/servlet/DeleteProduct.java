package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Services;

@WebServlet("/delete")
public class DeleteProduct extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Services ser = new Services();
		String id=req.getParameter("id");
		int iId=Integer.parseInt(id);
		int n =ser.deleteProduct(iId);
		out.print(n+" row deleted");
	}
}
