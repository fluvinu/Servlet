package NoteApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class searchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceCl ser= new ServiceCl();
		String sword=req.getParameter("sWord");
		String user = req.getParameter("user");
		List <Note> searcL=ser.search(sword,user);
		PrintWriter out = resp.getWriter();
		
		if(searcL.isEmpty()) {
			resp.setContentType("text/html");
			List <Note> searcLAll = ser.getUserDetails(user);
			out.print("result not found ");
			req.setAttribute("user", user);
			req.setAttribute("userdetail", searcLAll);
			RequestDispatcher rd= req.getRequestDispatcher("wellcome.jsp");
			rd.include(req, resp);
			
		}else {
			resp.setContentType("text/html");
			req.setAttribute("user", user);
			req.setAttribute("userdetail", searcL);
			RequestDispatcher rd= req.getRequestDispatcher("wellcome.jsp");
			rd.include(req, resp);
		}
		
		
	}
}
