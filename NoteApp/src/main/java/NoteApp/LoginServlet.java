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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("user");
		String pass = req.getParameter("pass");
		PrintWriter out = resp.getWriter();
		int count=0;

		
		ServiceCl ser=new ServiceCl();
		boolean rs1=ser.checkuName(name);
		
		if(rs1) {
			boolean rs= ser.checkUser(name ,pass);
			
			if(rs) {
				
				List<Note> note= ser.getUserDetails(name);
				
				req.setAttribute("userdetail", note);
				
				
				RequestDispatcher rd= req.getRequestDispatcher("wellcome.jsp");
				rd.forward(req, resp);
			}else {
				resp.setContentType("text/html");
				out.print("<center><h1 style='color:red,z-index:5'>pass wront</h1></center> ");
				RequestDispatcher rd= req.getRequestDispatcher("index.html");
				rd.include(req, resp);
				
			}
		}else {
			out.print("<center><h1 style='color:red'>user not found register first</h1></center>");
			
			resp.setContentType("text/html");
			RequestDispatcher rd =req.getRequestDispatcher("register.html");
			rd.include(req, resp);
		}
		
		
		
		
		
		
		
	}
}
