package controller;

import java.util.Scanner;
import java.util.Vector;

import models.Cart;
import models.Item;
import models.User;


public class ItemManager {
	
	UserManager um = new UserManager();
	public static ItemManager instance = new ItemManager();
	
	 Vector<Item> itemList = new Vector<Item>();
	 Vector<Cart> jangList = new Vector<Cart>();
	
	 public Vector<Item> getItemList() {
		return itemList;
	}
	public Vector<Cart> getJangList() {
		return jangList;
	}
	public Vector<String> getCategory() {
		return category;
	}
	Vector<String> category = new Vector<String>();
	
	Scanner sc = new Scanner(System.in);

	public ItemManager(){
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
			System.out.println(i+" ) ");
			itemList.get(i).print();
		}
	}
	
	public void printItemList(int caId) {
		int n=0;
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(caId).equals(itemList.get(i).getCateGory())) {
				System.out.println(n + ")");
				itemList.get(i).print();
				n+=1;
			}
		}
	}
	
	public void delCate() {
		for(int i=0; i<category.size(); i++) {
			System.out.println(i+")"+category.get(i));
		}
		System.out.println("삭제할 카데고리를 입력하세요 : ");
		String name = sc.next();
		
		Item delCa = null;
		for(int i=0; i<category.size(); i++) {
		//	if(name.equals();
		}
		this.category.remove(delCa);
		}
	
	
	public void delItem() {
		
		System.out.println("삭제할 아이템 이름을 입력하세요 : ");
		String name = sc.next();
		
		Cart delJang = null;
		for(Cart jL: this.jangList) {
			if(name.equals(jL.getItemName())) {
				delJang = jL;
			}
	}
	this.jangList.remove(delJang);
	System.out.println("삭제가 완료되었습니다.");
		
	}
	
	public void buyItem() {
		System.out.print("\n장바구니 아이템을 모두 구입하시겠습니까?\n1.yes\n2.no ");
		int sel = sc.nextInt();
		
		int total =0;
		if(sel ==1) {
		
			for(int i=0; i<this.jangList.size(); i++) {
				if(this.jangList.get(i).getUserId() == um.getUserList().get(i).getId());{
					if(this.jangList.get(i).getItemName() == this.itemList.get(i).getName());{
						total += this.itemList.get(i).getPrice();
					}
				}
			}
			System.out.println("총 금액 : "+total+" 원");
			System.out.println("현금 입력 : ");
			int money = sc.nextInt();
			
			if(money <= 0 || money < total) {
				System.out.println("금액이 부족합니다.");
				return;
			}else {
				int cash = money - total;
				System.out.println("구매 감사합니다.");
				System.out.println("잔돈 : "+cash+" 원 입니다.");
			}
			
		}else if(sel ==2) {
			return;
		}
	}
	
	
	public void addItem() {
		System.out.println("추가) 아이템 이름을 입력하세요 : ");
		String name = sc.next();
		System.out.println("추가) 가격을 입력하세요: ");
		int price = sc.nextInt();
		
		printCategory();
		
		System.out.println("추가) 카테고리를 입력하세요 : ");
		int sel= sc.nextInt(); 
		Item temp = new Item(name, price, category.get(sel));
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
			if(category.get(caId).equals(itemList.get(i).getCateGory())) {
				if(itemId == n) {
					temp.setItemName(itemList.get(i).getName());
				}
				n+=1;
			}
		}
		jangList.add(temp);
	}
	
	
	public void printAllCart() {
		System.out.println("size : "+this.jangList.size());
		for(Cart ct : jangList) {
			System.out.println(ct.getUserId()+" 님의 장바구니 : "+ ct.getItemName());
		}
	}	
				

	
	public void addAllCart(){
		//아이디를선택 검증맞으면  > 아이템이름/추가 > 장바구니에 반영.
		int check=-1;
		System.out.println("수정할 ID 입력하세요 : ");
		String id = sc.next();
		
		for(int i=0; i<this.jangList.size(); i++) {
		if (id.equals(um.getUserList().get(i).getId())) {
			check =1;
			
		}
		}if(check == -1) {
			System.out.println(id+"님에게 추가할 아이템 입력하세요 : ");
			String name = sc.next();
			System.out.println("추가) 가격을 입력하세요: ");
			int price = sc.nextInt();
			
			printCategory();
			
			System.out.println("추가) 카테고리를 입력하세요 : ");
			int sel= sc.nextInt(); 
			
			this.jangList.get(check).setItemName(name);
			
			
			
		}else {
			System.out.println("잘못된 입력입니다.");
		}
		}
	
	
	
	public void delAllCart() {
		
	}
		
}
