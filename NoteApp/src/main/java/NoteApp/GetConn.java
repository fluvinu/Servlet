package NoteApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConn {
	static Connection conn=null;
	
	static {
		String url="jdbc:mysql://localhost:3306/note" , uname="root" , pass="tiger";
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(url,uname,pass);
			} catch ( SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}




}
