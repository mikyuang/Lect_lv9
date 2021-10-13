package models;

public class Cart {

	
	private String userId;
	private String itemName;
	
	public void print() {
		System.out.println(userId + "현재 담겨있는 ITEM > "+itemName);
	}
	
}
