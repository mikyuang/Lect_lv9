package podels;

import java.util.Scanner;

public class Bank {

	public static Scanner sc = new Scanner(System.in);
	
	public static int log = -1; //로그정보 참조
	
	private static  String name;
	
	private Bank() {} //new 를 통한 Bank 생성이 안되게 막음 생성자를 숨김.
	
	public static String getName() {
		return Bank.name;
		
	}
	
	public static void setName(String name) {
		Bank.name = name;
		
	}
	
	
	
}
