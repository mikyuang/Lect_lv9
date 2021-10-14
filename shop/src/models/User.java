package models;

import java.util.ArrayList;

public class User {

	//회원정보.
	
	private String id;
	private String pw;
	
	
	
	public User(String id, String pw) {
		this.id=id;
		this.pw=pw;
	}
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}


	
	
}
