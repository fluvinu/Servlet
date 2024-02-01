package NoteApp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class deleteServlt extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceCl ser= new ServiceCl();
		int nId = Integer.parseInt(req.getParameter("id"));
		int uId=Integer.parseInt(req.getParameter("uid"));
		String uname=ser.getUname(uId);
		int n = ser.deleteNote(nId,uId);
		if(n>0) {
			List<Note> notessr=ser.getUserDetails(uname);
			req.setAttribute("user", uname);
			req.setAttribute("userdetail", notessr);
			RequestDispatcher rd= req.getRequestDispatcher("wellcome.jsp");
			rd.forward(req, resp);
		}
	}
}
