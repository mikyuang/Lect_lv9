package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.Cart;
import models.Item;
import models.User;

public class ItemManager {

	public static ItemManager instance = new ItemManager();
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private ArrayList<Cart> jangList = new ArrayList<Cart>();
	
	private ArrayList<String> category = new ArrayList<String>();
	
	Scanner sc = new Scanner(System.in);

	public void ItemManager(){
		init();
	}
	public void init() {
		category.add("OUTRE");
		category.add("TOP");
		category.add("BOTTOM");
		category.add("DERSS");
		Item temp = new Item("패딩", 100000, category.get(0));
		itemList.add(temp);
		temp = new Item("맨투맨", 50000, category.get(1));
		itemList.add(temp);
		temp = new Item("스커트", 100000, category.get(2));
		itemList.add(temp);
		temp = new Item("청바지", 100000, category.get(2));
		itemList.add(temp);
		temp = new Item("원피스", 100000, category.get(3));
		itemList.add(temp);
	}
	
	public void printJang() {
		for(int i=0; i<jangList.size(); i++) {
			jangList.get(i).print();
		}
	}
	
	public void printJang(User u) {
		for(int i=0; i<jangList.size(); i++) {
			if(u.getId().equals(jangList.get(i).getUserId())) {
				jangList.get(i).print();
			}
		}
	}
	
	
	public void printCategory() {
		for(int i=0; i<category.size(); i++) {
			System.out.println(i+" )"+category.get(i));
		}
	}
	
	public void printItemList() {
		for(int i=0; i<itemList.size(); i++) {
			System.out.println(i+" ) "+itemList.get(i));
		}
	}
	
	public void printItemList(int caId) {
		int n=0;
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(caId).equals(itemList.get(i).getCategory())) {
				System.out.println(n + ")"+itemList.get(i));
				n+=1;
			}
		}
	}
	
	
	public void addItem() {
		System.out.println("추가) 아이템 이름을 입력하세요 : ");
		String name = sc.next();
		System.out.println("추가) 가격을 입력하세요: ");
		int price = sc.nextInt();
		printCategory();
		System.out.println("추가) 카테고리를 입력하세요 : ");
		Item temp = new Item(name, price, category.get(price));
		itemList.add(temp);
	}
	public void addCategory() {
		System.out.println("카테고리 이름을 입력하세요 : ");
		String name = sc.next();
		category.add(name);
		
	}
	
	public void addCart(String usId, int caId, int itemId) {
		int n=0;
		Cart temp = new Cart();
		temp.setUserId(usId);
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(caId).equals(itemList.get(i).getCategory())) {
				if(itemId == n) {
					temp.setItemName(itemList.get(i).getName());
				}
				n+=1;
			}
		}
		jangList.add(temp);
	}
	public void printJang(String users) {
		// TODO Auto-generated method stub
		
	}
	
}
