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
	int userLog = -1;

	UserManager() {
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
			userList.add(temp);
		}
	}

	public void join() {
		System.out.println("[가입] id 를 입력하세요.");
		String id = sc.next();
		User temp = new User(id, 0);
		userList.add(temp);
		System.out.println("[메세지] " + temp.getId() + "님 가입을 축하합니다.");
	}

	public boolean logIn() {
		userLog = -1;
		System.out.println("[로그인] id 를 입력하세요.");
		String id = sc.next();
		for (int i = 0; i < userList.size(); i++) {
			if (id.equals(userList.get(i).getId())) {
				userLog = i;
				break;
			}
		}
		if (userLog == -1) {
			System.out.println("[메세지] 없는 id 입니다.");
		} else {
			System.out.println("[메세지] " + userList.get(userLog).getId() + "님 로그인.");
			return true;
		}
		return false;
	}

	public void logOut() {
		if (userLog != -1) {
			System.out.println("[메세지] " + userList.get(userLog).getId() + "님 로그아웃.");
		}
		userLog = -1;
	}

	public void printUser() {
		for (int i = 0; i < userList.size(); i++) {
			System.out.print("[" + i + "] "+userList.get(i));
			
		}
	}
	
	
	
	
	
	

	
	
	
}
