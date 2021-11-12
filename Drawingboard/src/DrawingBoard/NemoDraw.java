package DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Nemo{
	private int x,y,w,h;

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
	
	public Nemo(int x, int y, int w, int h, Color c) {
		this.h=h;
		this.w=w;
		this.x=x;
		this.y=y;
		this.c=c;
	}
	public Nemo() {
		// TODO Auto-generated constructor stub
	}
	
	private Color c;

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
	
}





public class NemoDraw {

	
}
