package NoteApp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatesave")
public class updateSave extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceCl ser= new ServiceCl();
		int nId= Integer.parseInt(req.getParameter("nid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		String uname=req.getParameter("uname");
		String title =req.getParameter("title");
		String note = req.getParameter("note");
		
		
		int n = ser.updateNote(nId,uid,title,note);
		List<Note> notes= ser.getUserDetails(uname);
		req.setAttribute("user", uname);
		req.setAttribute("userdetail", notes);
		if(n>0) {
			RequestDispatcher rd= req.getRequestDispatcher("wellcome.jsp");
			rd.forward(req, resp);
		}
	}
}
