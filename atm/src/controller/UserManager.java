package controller;

import java.util.ArrayList;
import java.util.Random;

import podels.Bank;
import podels.User;

public class UserManager {

	public static UserManager instance = new UserManager();
	private UserManager() {}
	
	//관리자
	public void setadmin() {
		User admin = new User(9999, "admin", "0000","관리자");
		this.users.add(admin);
	}
	
	
	//user : 중앙(총) 데이터
	//회원가입/탈퇴
	private ArrayList<User>users = new ArrayList<>();
	
	//가입 
	public void joinUser() {
		System.out.println("id : ");
		String id = Bank.sc.next();
		System.out.println("pw : ");
		String pw = Bank.sc.next();
		System.out.println("name : ");
		String name = Bank.sc.next();
	
		boolean check = false;
		for(User user : this.users) {
			if(id.equals(user.getId()))
				check = true;
		}
		if(!check) {
			User newUser = new User(randomCode(), id, pw, name);
			this.users.add(newUser);
		}else {
			System.out.println("중복된 아이디 입니다.");
		}
			
	}
		private int randomCode() {
			Random rn = new Random();
			
			while(true) {
				int rCode = rn.nextInt(8999)+1000;
				
				boolean check =false;
				for(User users : this.users) {
					if(rCode == users.getUserCode())
						check = true;
				}
				if(!check)
					return rCode;
			}
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
		
			
		public void printAllData() {
			for(User user : this.users)
				System.out.println(user);
		}
		
		public User getUser(int index) {
			return this.users.get(index);
		}
		public int getUserSize(){
			return this.users.size();
			}
		
		public void addUser(User user) {
			this.users.add(user);
		}
		}


		
		
	

