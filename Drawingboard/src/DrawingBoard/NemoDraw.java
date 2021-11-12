package DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
	
	public Nemo(int x, int y, int w, int h) {
		this.h=h;
		this.w=w;
		this.x=x;
		this.y=y;
	}
	private Color c;

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
	
}



class NemoPanal extends JPanel implements MouseListener, MouseMotionListener{
	
	
	private ArrayList<Nemo> nemo = new ArrayList<>();
	
	
	private boolean dir;
	
	
	private int dirX;
	private int dirY;
	
	private int endX;
	private int endY;
	
	private int nemow;
	private int nemoh;
	
	
	
	public NemoPanal(){
		setLayout(null);
		setBounds(0, 0, 800, 800);
		setBackground(Color.white);
		
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	

	/*
	 * 1.클릭한다.->사각객체 시작점으로 인식 
	 * 2.드래그 -> 객체 그려짐...
	 * 3.높기 -> 사각객체 완성.
	 *
	 */
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		for(int i=0; i<this.nemo.size(); i++) {
			g.setColor(this.nemo.get(i).getC());
			g.drawRect(this.nemo.get(i).getX(), this.nemo.get(i).getY(), this.nemo.get(i).getW(), this.nemo.get(i).getH());
		}
			
		
		
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		this.dirX =x;
		this.dirY =y;
		
		
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.dir=false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}




class NemoDrawing extends JFrame{
	
	public NemoDrawing() { 
	
		super("DRAWING PAN");
		setLayout(null);
		setBounds(800, 800, 800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		add(new NemoPanal());
	
		revalidate();
	
	}
	
}


public class NemoDraw {

	public static void NemoDraw (String[] args) {
		// TODO Auto-generated method stub

		NemoDrawing  dw = new NemoDrawing();
	}

}
