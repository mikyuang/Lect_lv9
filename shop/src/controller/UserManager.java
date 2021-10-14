package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.User;

public class UserManager {

	
public static UserManager instance = new UserManager();
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
	
	
	private ArrayList<User> users = new ArrayList<>();
	
	public static int log=-1;
	
	
	private static String ID = "admin";
	private static String PASSWORD ="0000";
	
	
	
	private UserManager(){
		init();
	}
	public void init() {
		getUsers().add(new User("qwer","1111"));
		getUsers().add(new User("abcd", "2222"));
		getUsers().add(new User("apple", "3333"));
	}
	
	public void joinUser() {
		System.out.println("id : ");
		String id = sc.next();
		System.out.println("pw : ");
		String pw = sc.next();
		
		boolean check = false;
		
		for(User user : this.getUsers()) {
			if(id.equals(user.getId()))
				check = true;
		}
		
		if(!check) {
			User newUser = new User(id, pw);
			this.getUsers().add(newUser);
		}else {
			System.out.println("중복된 아이디 입니다.");
		}
	}
	
	public int checkLog(String id, String pw) {
		int log =0;
		for(User user : getUsers()) {
			if(user.getId().equals(id) && user.getPw().equals(pw))
				return log;
			else
				log++;
		}
		return -1;
		
	}
	public boolean login() {
		int log =0;
		System.out.println("id : ");
		String id = sc.next();
		System.out.println("pw : ");
		String pw = sc.next();
		
		
		for(int i=0; i<getUsers().size(); i++) {
			if(getUsers().get(i).getId().equals(id) && getUsers().get(i).getPw().equals(pw)){
				log = i;
				break;
			}
		}
		if(log == -1) {
			System.out.println("존재하지 않는 id입니다.");
		}else {
			System.out.println(getUsers().get(log)+"님 로그인 성공.");
			return true;
		}
		return false;
		
	}
	
	public void printUser() {
		for(int i=0; i<this.getUsers().size(); i++) {
			System.out.println(i+" )");
			System.out.println(this.getUsers().get(i));
		}
		
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public String getUsers(int log2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
	
	
}
