package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.User;

public class UserManager {

	
public static UserManager instance = new UserManager();
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
	
	
	private ArrayList<User> users = null;
	
	private UserManager() {
		this.users = new ArrayList<>();
	}
	
	public static int log=-1;
	
	
	private static String ID = "admin";
	private static String PASSWORD ="0000";
	
	
	
	public void init() {
		users.add(new User("qwer","1111"));
		users.add(new User("abcd", "2222"));
		users.add(new User("apple", "3333"));
	}
	
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
	
	public int checkLog(String id, String pw) {
		int log =0;
		for(User user : users) {
			if(user.getId().equals(id) && user.getPw().equals(pw))
				return log;
			else
				log++;
		}
		return -1;
		
	}
	public boolean login() {
		System.out.println("id : ");
		String id = sc.next();
		System.out.println("pw : ");
		String pw = sc.next();
		
		
		int check = checkLog(id, pw);
		if(check == 1) {
		for(User user : this.users) {
			if(id.equals(user.getId()) && pw.equals(pw))
				System.out.println(users.get(log).getId()+"님 로그인 성공.");
		}
		}else {
			System.out.println("잘못된 정보 입니다.");
			
		}
		return false;
		}
	
	
	
	public boolean adminLog() {
		int log =0;
		System.out.println("id : ");
		String id = sc.next();
		System.out.println("pw : ");
		String pw = sc.next();
		
		for(int i=0; i<users.size(); i++) {
		if(users.get(i).getId().equals(ID) && users.get(i).getPw().equals(PASSWORD)) {
			log =i;
			break;
			}
		}if(log == -1) {
				System.out.println("존재하지 않습니다.");
			}else {
				System.out.println("관리자 로그인");
				return true;
			}
		return false;
		}
		
	
	
	public void printUser() {
		for(int i=0; i<this.users.size(); i++) {
			System.out.println(i+" )");
			System.out.println(this.users.get(i));
		}
		
	}
	
	
	
	

	
	
	
}
