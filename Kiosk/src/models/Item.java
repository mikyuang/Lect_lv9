package models;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Item {
	
	private static final int Coffee =0;
	private static final int Tea =1;
	
	
	private int meunNum;
	
	private int x,y,w,h;
	
	private int price;
	
	private int cnt;
	
	private int AllCnt;
	
	private String fileName;
	private Image image;
	
	private String Name;
	
	public Item(String name, int x, int y, int w, int h) {
		this.Name=Name;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getW() {
		return w;
	}


	public void setW(int w) {
		this.w = w;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	public int getAllCnt() {
		return AllCnt;
	}


	public void setAllCnt(int allCnt) {
		AllCnt = allCnt;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
		
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getMeunNum() {
		return meunNum;
	}


	public void setMeunNum(int meunNum) {
		this.meunNum = meunNum;
		if(meunNum == getCoffee()) {
			this.fileName = String.format("images/coffee0%d.png", null);
			image = new ImageIcon(this.fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
			}
		if(meunNum == Tea) {
				this.fileName = String.format("images/tea0%d.png", null);
				image = new ImageIcon(this.fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
			}
	}


	public static int getCoffee() {
		return Coffee;
	}
	
	
}
