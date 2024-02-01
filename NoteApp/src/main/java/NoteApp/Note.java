package NoteApp;

import java.sql.Timestamp;

public class Note {
	private int nid;
	private String n_title;
	private String note;
	private Timestamp time ;
	private String user ;
	private int user_id;
	
	
	
	public Note() {
		
	}



	public Note(int nid, String n_title, String note, Timestamp time, String user, int user_id) {
		
		this.nid = nid;
		this.n_title = n_title;
		this.note = note;
		this.time = time;
		this.user = user;
		this.user_id = user_id;
	}



	public int getNid() {
		return nid;
	}



	public void setNid(int nid) {
		this.nid = nid;
	}



	public String getN_title() {
		return n_title;
	}



	public void setN_title(String n_title) {
		this.n_title = n_title;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public Timestamp getTime() {
		return time;
	}



	public void setTime(Timestamp time) {
		this.time = time;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	

}
