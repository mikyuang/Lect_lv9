package controller;

import podels.Bank;

public class BankManager {

	public static BankManager instance = new BankManager();
	private BankManager() {}

	
	public void run() {
		//싱행시작
		//고객이 입력하는건 다 String 타입으로 
		
		boolean isRun = true;
		while(isRun) {
			System.out.println(Bank.getName()+"ATM");
			printMenu();
			selectMenu();
			
		}
	}
	
	private void printMenu() {
		
		if(Bank.log == -1) {
		
		System.out.println("1.로그인 2.회원가입 3. 종료.");
		}else {
			System.out.println("1.");
		}
	}
		
		private void selectMenu() {
			String input = Bank.sc.next();
			
			try {
				
				int sel = Integer.parseInt(input);
				if(Bank.log == -1) {
					if(sel ==1) {
						Bank.log = um.login();
					}
					else if(sel ==2) {
						//회원가입 메소드를 호툴
						um.joinUser();
					}
					else if(sel ==3) {
						
					}else {
						
					}
				}
				
			}catch(Exception e) {
				System.out.println("입력값을 확인하세요.");
			}
		}
	}

