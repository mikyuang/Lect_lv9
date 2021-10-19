package controller;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.User;

public class UserManager {

	
public static UserManager instance = new UserManager();
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
	
	private Vector<User> userList = new Vector<User>(); // 전체 유저 리스트
	
	public int userLog = -1;

	public UserManager() {
		init();
	}

	public void init() {
		String[] a = { "김", "박", "이", "최", "정", "오" };
		String[] b = { "철", "병", "만", "여", "아", "영" };
		String[] c = { "수", "욱", "수", "정", "름", "희" };
		for (int i = 0; i < 10; i++) {
			int r = rn.nextInt(a.length);
			String name = a[r];
			r = rn.nextInt(b.length);
			name += b[r];
			r = rn.nextInt(c.length);
			name += c[r];
			User temp = new User(name, rn.nextInt(5000));
			getUserList().add(temp);
		}
	}

	public boolean join() {
		int check = -1;
		System.out.println("[가입] id 를 입력하세요.\n");
		String id = sc.next();
		
		for(int i=0; i<getUserList().size(); i++) {
			if(id.equals(getUserList().get(i).getId())) {
				check =i;
				break;
			}
		}
		if(check == -1) {
			User temp = new User(id, 0);
			
			getUserList().add(temp);
			System.out.println("[메세지] " + temp.getId() + "님 가입을 축하합니다.\n");
			return true;
			
		}else {
			System.out.println("이미 존재하는 id입니다.\n");
			}
		return false;
	}

	public boolean logIn() {
		userLog = -1;
		System.out.println("[로그인] id 를 입력하세요.\n");
		String id = sc.next();
		for (int i = 0; i < getUserList().size(); i++) {
			if (id.equals(getUserList().get(i).getId())) {
				userLog = i;
				break;
			}
		}
		if (userLog == -1) {
			System.out.println("[메세지] 없는 id 입니다.\n");
		} else {
			System.out.println("[메세지] " + getUserList().get(userLog).getId() + "님 로그인.\n");
			return true;
		}
		return false;
	}

	public void logOut() {
		if (userLog != -1) {
			System.out.println("[메세지] " + getUserList().get(userLog).getId() + "님 로그아웃.\n");
		}
		userLog = -1;
	}

	public void printUser() {
		for (int i = 0; i < getUserList().size(); i++) {
			System.out.print("[" + i + "] ");
		getUserList().get(i).print();
			
		}
	}
	public void deluser() {
		System.out.println("[탈퇴] id 를 입력하세요.\n");
		String id = sc.next();
		
		User delur = null;
		for(User user : this.userList) {
			if(id.equals(user.getId())){
				delur = user;
			}
		}
		this.userList.remove(delur);
		System.out.println("탈퇴가 완료되었습니다.\n");
	}

	
	public Vector<User> getUserList() {
		return userList;
	}

	public void setUserList(Vector<User> userList) {
		this.userList = userList;
	}
}
