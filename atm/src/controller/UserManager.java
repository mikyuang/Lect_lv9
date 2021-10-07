package controller;

import java.util.ArrayList;
import java.util.Scanner;

import podels.Bank;
import podels.User;

public class UserManager {

	
	//user : 중앙(총) 데이터
	
	
	private ArrayList<User>users = new ArrayList<>();
	
	//가입 
	public void joinUser() {
		System.out.println("id : ");
		String id = Bank.sc.next();
		System.out.println("pw : ");
		String pw = Bank.sc.next();
		System.out.println("name : ");
		String name = Bank.sc.next();
	
		
		User newUser = new User(randomCode(), id, pw, name); 
		 this.users.add(newUser);
			
	}
		private int randomCode() {
			return 0;
		}
		
		public int login() {
			System.out.println("id : ");
			String id = Bank.sc.next();
			System.out.println("pw : ");
			String pw = Bank.sc.next();
			for(int i=0; i<this.users.size(); i++) {
				if(users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				return i;
				}
			}
			return -1;
		}
		
		public void logout() {
			
			
		}
		
		public void delId() {
			
			
		}
		
	}
	

