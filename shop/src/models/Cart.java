package models;

public class Cart {

	
	private String userId;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	private String itemName;
	
	public void print() {
		System.out.println(userId + "현재 담겨있는 ITEM > "+itemName);
	}
	
}
