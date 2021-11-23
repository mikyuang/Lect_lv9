package models;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Item {
	
	public static final int Coffee =0;
	public static final int Tea =1;
	
	
	private int meunNum;
	
	private int x,y,w,h;
	
	private int price;
	
	private int num;
	
	private int cnt;
	
	private int AllCnt;
	
	private String fileName;
	private ImageIcon image;
	
	private String Name;
	
	public Item(int num, int x, int y, int w, int h) {
		this.num=num;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		if (this.meunNum == Coffee) {
			this.fileName = String.format("images/coffee0%d.png", null);
		}if(this.meunNum == Tea) {
			this.fileName = String.format("images/tea0%d.png", null);
		}
		Image temp = new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		this.image = new ImageIcon(temp);
		
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
		if(this.meunNum == Coffee) {
			if(num == 1) {this.price = 1500;}
			else if(num==2) {this.price = 2500;}
			else if(num==3) {this.price = 2000;}
			else if(num==4) {this.price = 2500;}
			else if(num==5) {this.price = 5500;}
			else if(num==6) {this.price = 2500;}
			else if(num==7) {this.price = 3000;}
			else if(num==8) {this.price = 3000;}
			else if(num==9) {this.price = 3000;}
			else if(num==10) {this.price = 3500;}
			else if(num==11) {this.price = 3500;}
			else if(num==12) {this.price = 3500;}
			else if(num==13) {this.price = 1500;}
			else if(num==14) {this.price = 2500;}
			else if(num==15) {this.price = 3000;}
			else if(num==16) {this.price = 3000;}
			
			
		}
		if(this.meunNum == Tea) {
			if(num == 1) {this.price = 3500;}
			else if(num==2) {this.price = 3500;}
			else if(num==3) {this.price = 3500;}
			else if(num==4) {this.price = 2500;}
			else if(num==5) {this.price = 2500;}
			else if(num==6) {this.price = 2500;}
			else if(num==7) {this.price = 2500;}
			else if(num==8) {this.price = 2500;}
			else if(num==9) {this.price = 3500;}
			else if(num==10) {this.price = 2500;}
			else if(num==11) {this.price = 2500;}
			else if(num==12) {this.price = 2500;}
			else if(num==13) {this.price = 2500;}
			else if(num==14) {this.price = 3000;}
			else if(num==15) {this.price = 3500;}
			else if(num==16) {this.price = 3500;}
			
			
		}
		
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


	public String getName() {
		
		if(this.meunNum == Coffee) {
			if(num == 1) {this.Name = "아메리카노";}
			else if(num==2) {this.Name = "스폐셜 아메리카노";}
			else if(num==3) {this.Name = "헤이즐넛 아메리카노";}
			else if(num==4) {this.Name = "유자 아메리카노";}
			else if(num==5) {this.Name = "카푸치노";}
			else if(num==6) {this.Name = "카페라떼";}
			else if(num==7) {this.Name = "헤이즐럿라떼";}
			else if(num==8) {this.Name = "바닐라라떼";}
			else if(num==9) {this.Name = "크리미라떼";}
			else if(num==10) {this.Name = "헤이즐넛크리미라떼";}
			else if(num==11) {this.Name = "카페모카";}
			else if(num==12) {this.Name = "카라멜마끼아또";}
			else if(num==13) {this.Name = "에소프레소";}
			else if(num==14) {this.Name = "더치커피";}
			else if(num==15) {this.Name = "더치시나몬라떼";}
			else if(num==16) {this.Name = "더치코코넛라떼";}
			
			
		}
		if(this.meunNum == Tea) {
			if(num == 1) {this.Name = "허니레몬티";}
			else if(num==2) {this.Name = "허니유자티";}
			else if(num==3) {this.Name = "허니자몽티";}
			else if(num==4) {this.Name = "얼그레이";}
			else if(num==5) {this.Name = "국화차";}
			else if(num==6) {this.Name = "민트초코티";}
			else if(num==7) {this.Name = "캐모마일";}
			else if(num==8) {this.Name = "페퍼민트";}
			else if(num==9) {this.Name = "청포도에이드";}
			else if(num==10) {this.Name = "보이차";}
			else if(num==11) {this.Name = "루이보스";}
			else if(num==12) {this.Name = "로즈힙";}
			else if(num==13) {this.Name = "히비스커스";}
			else if(num==14) {this.Name = "복숭아아이스티";}
			else if(num==15) {this.Name = "블루레몬아이스티";}
			else if(num==16) {this.Name = "자몽에이드";}
		
		}
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getMeunNum() {
		return meunNum;
	}


	
}
