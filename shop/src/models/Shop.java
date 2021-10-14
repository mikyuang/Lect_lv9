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
			System.out.println("\n1.로그인\n2.회원가입\n3.종료"+"\n100.관리자");
			int sel =sc.nextInt();
		
		if(sel == 1) {
			if(um.login()) {
				selectMenu();
			}
		}else if(sel ==2) {
			um.joinUser();
		}
		else if(sel ==3) {
			System.out.println("프로그램을 종료합니다.");
			break;
		}
		if(sel == 100) {
			if(um.login()) {
			ManagerMu();
			}
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
			im.printCategory();
			System.out.println("카데고리 선택");
			int caId = sc.nextInt();
			System.out.println("아이템 선택 : ");
			im.printItemList(caId);
			int itId = sc.nextInt();
			im.addCart(um.getUsers(um.log), caId, itId);
			
			
			}
		}
		
		public void cartMenu() {
			boolean run=true;
			while(run) {
			System.out.print("\n1.나의장바구니\n2.삭제\n3.구입\n0.뒤로가기\n");
			int sel = sc.nextInt();
			
			if(sel ==1) {
				im.printJang(um.getUsers(um.log));
			}
			else if(sel ==2) {
				
			}
			else if(sel ==3) {
				
			}
			else if(sel ==0) {}
			run = false;
			}
		}
		
		public void ManagerMu() {
			
			boolean run = true;
			while(run) {
			if(um.log == 0) {
				System.out.println("= = = 관 리 자 = = =");
				System.out.print("\n1.아이템 관리\n2.카데고리관리\n3.장바구니관리\n4.유저관리\n0.뒤로가기");
			int sel = sc.nextInt();
			
			if(sel ==1) {
				itemMenu();
			}
			else if(sel ==2) {
				categoryMenu();
			}else if(sel ==3) {
				
			}
			else if(sel ==4) {
				userMenu();
			}
			else if(sel ==0) {
			run = false;
			}
			else {
				System.out.println("잘못된 입력입니다.");
				}
			}
		}
	}
		private void categoryMenu() {
			boolean run = true;
			while(run) {
				System.out.println("\n1.전체카테고리\n2.카테고리 추가\n3.카테고리 삭제\n0.뒤로가기");
				int sel = sc.nextInt();
				
				if(sel ==1) {
					
				}else if(sel ==2) {
					
				}else if(sel ==0) {
					run = false;
				}
			}
			
		}
		private void itemMenu() {
			boolean run = true;
			while(run) {
				System.out.println("\n1.전체아이템\n2.아이템추가\n3.아이템삭제\n0.뒤로가기");
				int sel = sc.nextInt();
				if(sel ==1) {
					im.printItemList();
				}else if(sel ==2) {
					im.addItem();
				}else if(sel ==0) {
					run = false;
				}
			}
		}
		private void userMenu() {
			boolean run=true;
			while(run) {
				System.out.println("\n1.전체유저\n2.유저추가\n3.유저삭제\n0.뒤로가기");
				int sel = sc.nextInt();
				
			if(sel ==1) {
				um.printUser();
			}else if(sel ==0) {
				run = false;
			}
				
			}
		}
		
		
}
	
	
	

