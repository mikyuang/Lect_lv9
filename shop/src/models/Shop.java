package models;

import java.util.Scanner;

import controller.UserManager;

public class Shop {//로그인 화면 

	
	private UserManager um = UserManager.instance;
	
	Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {
		
		boolean isRun = true;
		while(isRun) {
			System.out.print("= = = S H O P = = =\t");
		System.out.println("\n1.로그인\n2.회원가입\n3.종료"+"n100.관리자\n0.뒤로가기");
		int sel =sc.nextInt();
		
		if(sel == 1) {
			if(um.login()) {
				selectMenu();
			}
		}
		else if(sel ==2) {
			um.joinUser();
		}
		else if(sel ==3) {
			System.out.println("프로그램을 종료합니다.");
			break;
		}else if(sel ==100) {
			ManagerMu();
		}
		}
	}
		private void selectMenu() {
			boolean run=true;
			while(run) {
				System.out.println(um.getUser()"님 접속중");
				
				
			}
			
			
		}
	}
	
	

