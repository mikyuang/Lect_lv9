package Horse;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Horse {
	
	private String fileName;
	private ImageIcon image;
	
	
	public final int RUN =0;
	public final int GOAL =1;
	
	
	private int num;
	private int speed;
	private int rank;
	
	
	private String record;
	
	private int state; //말의 현재 상태. 0> 레디 1>런 2>골.
	
	private int x, y, w, h;
	
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		//이미지아이콘 수정.
		//this.image =  new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public ImageIcon getImage() {
		return image;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}


	public int getRUN() {
		return RUN;
	}
	
	public int getNum() {
		return num;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
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

	public int getGOAL() {
		return GOAL;
	}

	public Horse(int num, int x, int y, int w, int h) {
		this.num=num;
		this.h=h;
		this.x=x;
		this.y=y;
		this.w=w;
		this.fileName = String.format("image/horse%d.png", this.num);
		this.image =  new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
		
	}
	
	
	
	
}
