package controller;

import java.util.ArrayList;

import models.Item;
import models.User;

public class ItemManager {

	public static ItemManager instance = new ItemManager();
	
	private ArrayList<Item> item = null;
	
	
	public void myCart() {//장바구니 보여주기
		System.out.println("= = = MY CART = = =");
		for(Item Item : item) {
			
		}
	}
	
	public void cartAdd() {
		
		
	}
	
	public void delCart() {//장바구니 삭제
		
	}
	
	public void buyCart() { //구입후 > 장바구니 리스트에서 삭제
		
		
	}
	
	//관리자
	
	
	
	
	
}
