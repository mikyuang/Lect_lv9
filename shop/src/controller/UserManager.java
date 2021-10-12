package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.User;

public class UserManager {

public static UserManager instance = new UserManager();
	
	
	private ArrayList<User> users = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	public void joinUser() {
		System.out.println("id : ");
		String id = sc.next();
		System.out.println("pw : ");
		String pw = sc.next();
		
		boolean check = false;
		
		for(User user : this.users) {
			if(id.equals(user.getId()))
				check = true;
		}
		
		if(!check) {
			User newUser = new User(id, pw);
			this.users.add(newUser);
		}else {
			System.out.println("중복된 아이디 입니다.");
		}
	}
	
	public int login() {
		System.out.println("id : ");
		String id = sc.next();
		System.out.println("pw : ");
		String pw = sc.next();
		
		for(int i=0; i<this.users.size(); i++) {
			if(users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				return i;
			}
		}
		return -1;
	}
	
	public User getUser(int log) {
		return this.users.get(log);
	}
	

	
	
	
}
