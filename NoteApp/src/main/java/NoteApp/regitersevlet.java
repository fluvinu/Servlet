package NoteApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class regitersevlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceCl ser=new ServiceCl();
		String uname = req.getParameter("uname");
		String pass= req.getParameter("pass");
		PrintWriter out = resp.getWriter();
		
		int n = ser.makeUser(uname,pass);
		if(n>0) {
			resp.setContentType("text/html");
			out.print("<center><h1 style='color:red'>register sussfull try to login </h1></center>");
			RequestDispatcher rs = req.getRequestDispatcher("index.html");
			rs.include(req, resp);
		}else {
			out.print("somthig wrong !!! from data base");
		}
	}

}
