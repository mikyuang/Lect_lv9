package models;

public class Item {

	//아이템-이름,가격,카테고리 -OUTER, TOP, BOTTOM, DERSS 
	
	private String name;
	private int price;
	private String cateGory;
	private int cnt;
	
	public Item(String name, int price, String cate) {
		this.name=name;
		this.price=price;
		this.cateGory=cate;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCateGory() {
		return cateGory;
	}
	
	public void setCateGory(String cateGory) {
		this.cateGory = cateGory;
	}

public void print() {
	System.out.println(this.name + " : "+ this.price + " , "+ this.cateGory);
}

}
