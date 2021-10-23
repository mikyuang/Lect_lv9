package controller;

import java.util.ArrayList;
import java.util.Random;

import podels.Accont;
import podels.Bank;
import podels.User;

public class AccountManager {
	
	
	//AccountManager(Account 타입의 객체배열)
	
	private UserManager um = UserManager.instance;
	public static AccountManager instance = new AccountManager();
	
	private ArrayList<Accont> accs = new ArrayList<>();
	
	private User getUser(int log) {
		return um.getUser(log);
	}
	
	
	public void creataAcc() {
		//현재 로그인 중인 회원 보유안 계좌의 수가 확인. 그 계좌의 Account Max 값을 기준으로 처리가 두가지로 나뉨 
		
		int userCode =getUser(Bank.log).getUserCode();
		
		
//		int cnt=0;
//		for(Accont acc : accs) {
//			if(userCode == acc.getUserCode()) {
//				cnt++;
//			}
//		}
		
		
		int cnt = getUser(Bank.log).getAccCnt();
		if(cnt < 3) {
			this.accs.add(new Accont(randomCode(), userCode));
			getUser(Bank.log).setAccCnt(++cnt);
			System.out.println("계좌생성 완료!");
		}else {
			System.out.println("계좌초과");
		}
	}
	public void delcteAcc() {
		printAccs();
		System.out.println("삭제할 계좌 선택 : ");
		
		String input = Bank.sc.next();
		int delIdx = findIndex(input);
		
		int cnt = getUser(Bank.log).getAccCnt();
		
		if(delIdx != -1) {
			this.accs.remove(delIdx);
			getUser(Bank.log).setAccCnt(--cnt);
			System.out.println("계좌철회 완료");
			
				}
			}
	
	private int findIndex(String input) { //위에 트라캐치문 비슷하게 사용하기떄문에, 따로띠어줌 
		int index =-1;
		try {
			int cnt = getUser(Bank.log).getAccCnt();
			int userCode = getUser(Bank.log).getUserCode();
			int num = Integer.parseInt(input);
			
			if(num >= 0 && num < cnt) {
				int tempCnt = 0;
				for(int i=0; i<this.accs.size(); i++) {
					if(userCode == this.accs.get(i).getUserCode()) {
						index =i;
						tempCnt++;
						if(tempCnt == num)
							break;
					}
				}
			}
			
		}catch(Exception e) {
			
		}
		return index;
	}
	
	public void inputMoney() {
		printAccs();
		System.out.println("입금할 계좌 선택 : ");
		
		String input = Bank.sc.next();
		int index = findIndex(input);
		
		if(index != -1) {
			Accont temp = this.accs.get(index);
			int balance = temp.getMoney();
			
			System.out.println("입금금액: ");
			int money = Bank.sc.nextInt();
			
			if(money > 0) {
			balance += money;
			temp.setMoney(balance);
			System.out.printf("입금완료!, 잔액 :  %d원", balance);
			}
		}
		
	}
	
	public void outMoney(){
		printAccs();
		System.out.println("출금할 계좌 선택 : ");
		
		String input = Bank.sc.next();
		int index = findIndex(input);
		
		if(index != -1) {
			Accont temp = this.accs.get(index);
			int balance = temp.getMoney(); //실잔액
			
			System.out.println("출금금액 : ");
			int money = Bank.sc.nextInt();
			
			if(balance >= money) {
				balance -= money;
				temp.setMoney(balance);
				System.out.printf("출금완료!, 잔액 :  %d원", balance);
			}
		}
		
		
	}
	public void withdraw() {
		System.out.println("이체할 꼐좌번호 : ");
		int target = Bank.sc.nextInt();
		
		int targetIdx = -1;
		for(int i=0; i<this.accs.size(); i++) {
			if(target == this.accs.get(i).getAccNum()) {
				targetIdx =i;
			}
			printAccs();
			System.out.println("출금할 계좌 선택 : ");
			
			String input = Bank.sc.next();
			int index = findIndex(input);
			
			if(targetIdx != -1 && index != -1) {
				System.out.println("이체할 금액 : ");
				int money = Bank.sc.nextInt();
				
				
				Accont temp = this.accs.get(index);
				int balance = temp.getMoney();
				
				if(balance >= money) {
					balance -= money;
					temp.setMoney(balance);
					
					temp = this.accs.get(targetIdx);
					balance = temp.getMoney();
					
					balance += money;
					temp.setMoney(balance);
					
				}else {
					System.out.println("잔액이 부족합니다.");
				}
				
			}else {
				System.out.println("없는 계좌 ");
			}
		}
		
	}
	
	
	private int randomCode() {
		Random rn = new Random();
		
		while(true) {
			int rCode = rn.nextInt(8999)+1000;
			
			boolean check =false;
			for(Accont acc : this.accs) {
				if(rCode == acc.getAccNum())
					check = true;
			}
			if(! check)
				return rCode;
		}
	}
	
	public void printAccs() {
		int userCode = getUser(Bank.log).getUserCode();
		for(int i=0; i<this.accs.size(); i++) {
			if(userCode == accs.get(i).getUserCode())
			System.out.println((i+1 + ")"));
				System.out.println(accs.get(i));
		}
	}
	public void printAllData() {
		for(Accont acc : this.accs) {
			System.out.println(acc);
		}
	}
		
	public Accont getAccont(int index) {
			return this.accs.get(index);
		}
	public int getAccsSize() {
		return this.accs.size();
		}
	public void addAccount(Accont acc) {
		this.accs.add(acc);
	}
	
	
}
