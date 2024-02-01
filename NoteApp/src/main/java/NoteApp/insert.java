package NoteApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class insert extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceCl ser=new ServiceCl();
		PrintWriter out=resp.getWriter();
		String uname =req.getParameter("uname");
		int  uid=ser.getUid(uname);
		String notes =req.getParameter("note");
		String title = req.getParameter("title");
		
		Note n=new Note();
		n.setN_title(title);
		n.setNote(notes);
		n.setUser(uname);
		n.setUser_id(uid);
		
		
		int u= ser.insertNote(n);
		
		if(u>0) {
			List<Note> note= ser.getUserDetails(uname);
			req.setAttribute("userdetail", note);
			req.setAttribute("uname", uname);
			RequestDispatcher rd = req.getRequestDispatcher("wellcome.jsp");
			rd.forward(req, resp);
		}else {
			out.print("somthis is wrong");
		}
		 
	}

}
