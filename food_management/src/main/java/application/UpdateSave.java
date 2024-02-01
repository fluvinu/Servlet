package application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/save")
public class UpdateSave extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Serveces ser= new Serveces();
		int id = Integer.parseInt(req.getParameter("id"));
		
		String pName=req.getParameter("pName");
		int pTime = Integer.parseInt(req.getParameter("pTime"));
		int cTime = Integer.parseInt(req.getParameter("cTime"));
		String ingre= req.getParameter("ingre");
		String die = req.getParameter("dite");
		String flavorP = req.getParameter("flavorP");
		String course = req.getParameter("course");
		String stateR = req.getParameter("stateR");
		
		Food newfood=new Food(id, pName, ingre, die, pTime, cTime, flavorP, course, stateR, stateR);
		
		int n = ser.updateFood(newfood);
		
		if(n>0) {
			resp.sendRedirect("/food_management/view");
		}else {
			PrintWriter out = resp.getWriter();
			out.print("<h1 style='color:red'> it is not updated</h1>");
		}
	}
}
