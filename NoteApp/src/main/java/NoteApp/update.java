package NoteApp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceCl ser= new ServiceCl();
		
		int nid = Integer.parseInt(req.getParameter("id"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		
		List<Note> upList=ser.getUpDetails(nid,uid);
		
		req.setAttribute("upnote", upList);
		
		RequestDispatcher  rs = req.getRequestDispatcher("update.jsp");
		rs.forward(req, resp);
		
		
		
		
		
		
	}
	
}
