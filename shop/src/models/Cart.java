package models;

public class Cart {

	
	private String userId;
	
	
	public void setUserId(String usId) {
		this.userId = userId;
	}


	public String getUserId() {
		return userId;
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
