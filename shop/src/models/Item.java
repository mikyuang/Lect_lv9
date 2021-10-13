package models;

public class Item {

	//아이템-이름,가격,카테고리 -OUTER, TOP, BOTTOM, DERSS 
	
	private String name;
	private int price;
	private String category;
	
	public Item(String name, int price, String cate) {
		this.name=name;
		this.price=price;
		this.category=cate;
	}

	public void print() {
		System.out.println(name + " : "+price + " "+category);
	}
	
}
