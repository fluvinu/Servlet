package NoteApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class ServiceCl {
	
	static Connection  conn =GetConn.conn;;
	
	
	public boolean checkUser(String name, String pass) {
		boolean rsf = false;
		
		String quary="select * from user where user='"+name+"' and pass='"+pass+"'";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(quary);
			
			if (rs.next()) {
				rsf=true;
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		return rsf;
		
	}


	public List<Note> getUserDetails(String name) {
		List<Note> nor= new ArrayList<Note>();
		
		String qury="select * from notes where user='"+name+"';";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(qury);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String title=rs.getString(2);
				String note =rs.getString(3);
				Timestamp time = rs.getTimestamp(4);
				String user =rs.getString(5);
				int uid = rs.getInt(6);
				
				Note n = new Note(id, title, note, time, user, uid);
				
				nor.add(n);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nor;
	}


	public int insertNote(Note n) {
		int r=0;
		String qury="INSERT INTO `note`.`notes` (`n_title`, `note`,`date`, `user`, `user_id`) VALUES ( ?, ?,now(), ?, ?);";
		try {
			PreparedStatement pstmt = conn.prepareStatement(qury);
			pstmt.setString(1, n.getN_title());
			pstmt.setString(2, n.getNote());
			pstmt.setString(3, n.getUser());
			pstmt.setInt(4, n.getUser_id());
			r=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
		
	}


	public List<Note> getUpDetails(int nid, int uid) {
		String Quary ="select * from notes where nid="+nid+" and user_id="+uid;
		List <Note> uplist=new ArrayList<Note>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Quary);
		
			while (rs.next()) {
				Note uno=new Note();
				uno.setNid(rs.getInt(1));
				uno.setN_title(rs.getString(2));
				uno.setNote(rs.getString(3));
				uno.setTime(rs.getTimestamp(4));
				uno.setUser(rs.getString(5));
				uno.setUser_id(rs.getInt(6));
				uplist.add(uno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return uplist;
	}


	public int updateNote(int nId, int uid, String title, String note) {
		int number=0;
		String quary = "UPDATE notes SET n_title = '"+title+"', note = '"+note+"' ,`date` = now() WHERE nid = "+nId+" and user_id = "+uid+";";
		try {
			Statement stmt = conn.createStatement();
			 number= stmt.executeUpdate(quary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return number;
	}


	public int deleteNote(int nId, int uId) {
		String quary= "delete from notes where user_id = "+uId+" and nid ="+nId;
		int n=0;
		try {
			Statement stmt= conn.createStatement();
			 n= stmt.executeUpdate(quary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}


	public String getUname(int uId) {
		String quary = "select user from user where user_id="+uId;
		String uname="defalt";
		try {
			Statement stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery(quary);
			rs.next();
			uname=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uname;
	}


	public boolean checkuName(String name) {
		String qury="select user from user where user='"+name+"'";
		boolean b=false;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(qury);
			if(rs.next()) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}


	public int makeUser(String uname, String pass) {
		String quury ="INSERT INTO `note`.`user` (`user`, `pass`) VALUES (?, ?);";
		PreparedStatement pstmt;
		int n = 0;
		
		try {
			pstmt = conn.prepareStatement(quury);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			n=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}
	
	public static int getUid(String uname) {
		String quary = "select user_id from user where user='"+uname+"'";
		int uid = 0;
		try {
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(quary);
			rs.next();
			uid=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return uid;
	}


	public List<Note> search(String sword, String user) {
		List<Note> list=new ArrayList<Note>();
		String squry="select * from notes  where user='"+user+"' and n_title like  "+"'%"+sword+"%'" ;
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(squry);
			while(rs.next()) {
				int id = rs.getInt(1);
				String title=rs.getString(2);
				String note =rs.getString(3);
				Timestamp time = rs.getTimestamp(4);
				int uid = rs.getInt(6);
				
				Note n = new Note(id, title, note, time, user, uid);
				
				list.add(n);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}
