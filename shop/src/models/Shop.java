package models;

import java.util.Scanner;

import controller.ItemManager;
import controller.UserManager;

public class Shop {//로그인 화면 

	
	private UserManager um = UserManager.instance;
	private ItemManager im = ItemManager.instance;
	
	Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {
		
		boolean isRun = true;
		while(isRun) {
			System.out.print("= = = S H O P = = =\t");
			System.out.println("\n1.로그인\n2.회원가입\n3.종료"+"\n100.관리자\n0.뒤로가기");
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
			
		}
		
		else if(sel == 100) {
			ManagerMu();
		}
		}
	}
		public void selectMenu() {
			boolean run=true;
			while(run) {
				System.out.print("\n1.쇼핑\n2.장바구니목록\n3.로그아웃\n0.뒤로가기");
				int sel = sc.nextInt();
				if(sel ==1) {
					shopMenu();
				}
				else if (sel ==2) {
					cartMenu();
				}else if(sel ==3) {
					um.log=-1;
				}
				else if (sel ==0) {break;}
				
			}
			
		}
		
		public void shopMenu() {
			boolean run=true;
			while(run) {
			System.out.println("1.카데고리 선택");
			System.out.println("2.아이템 선택");
			
			}
		}
		
		public void cartMenu() {
			boolean run=true;
			while(run) {
			System.out.print("\n1.나의장바구니\n2.삭제\n3.구입\n0.뒤로가기\n");
			int sel = sc.nextInt();
			
			if(sel ==1) {}
			else if(sel ==2) {}
			else if(sel ==3) {}
			else if(sel ==0) {}
			
			}
		}
		
		public void ManagerMu() {
			if(um.log == 0) {
				System.out.println("= = = 관 리 자 = = =");
				System.out.print("\n1.아이템 관리\n2.카데고리관리\n3.장바구니관리\n4.유저관리\n0.뒤로가기");
			int sel = sc.nextInt();
			
			if(sel ==1) {
				
			}
			else if(sel ==2) {
				
			}
			else if(sel ==3) {
				
			}
			else if(sel ==4) {
				
			}
			else if(sel ==0) {
				
			}
			else {
				System.out.println("잘못된 입력입니다.");
			}
			}
			}
		}
	
	
	

