package models;

import java.util.ArrayList;
import java.util.Vector;

public class User {

	//회원정보.
	private Vector<User> userList = new Vector<User>();
	
	private String id;
	private int money;
	
	
	
	public User(String id, int mo) {
		this.id=id;
		money=mo;
	}
	
	public String getId() {
		return id;
	}
	

	public void print() {
		System.out.println("["+id+"]"+" 보유 금액 : "+ money);
	}


	
	
}
