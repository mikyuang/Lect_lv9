package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class Rect{
	
	private int x,y,w,h;
	private Color c;
	
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
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	
	public Rect(int x, int y, int w, int h, Color c) {
		this.c=c;
		this.h=h;
		this.w=w;
		this.x=x;
		this.y=y;
	}
	public Rect() {
		// TODO Auto-generated constructor stub
	}
	
	
}



class Pupaly extends JPanel implements MouseListener,ActionListener{
	
	private final int LEFT=0;
	private final int DOWN=1;
	private final int RIT=2;
	private final int UP=3;
	
	private Rect rect1 = null;
	private Rect rect2 = null;

	private final int SIZE = 700;
	
	private JButton[] btn = new JButton[4];
	
	private int dir;//1-LF 2-D 3-R 4-U
	private boolean isMoving;
	
	private boolean check; 
	
	public Pupaly(){
		setLayout(null);
		setBounds(0, 0, SIZE, SIZE);
		setBackground(Color.white);
		
		this.dir=5;
		
		setBtn();
		setRect();
		
	}
	
	//랜덤으로 상자를 놓게하자.
	private void setRect() {
		Random rn = new Random();
		
		int rX = rn.nextInt(SIZE -100);
		int rY = rn.nextInt(SIZE -100);
		this.rect1 = new Rect(rX,rY,100,100,Color.pink);
		
		while(true) {
			rX = rn.nextInt(SIZE -100-100);
			rY = rn.nextInt(SIZE -100-100);
			this.rect2 = new Rect(rX,rY,100,100,Color.RED);
			
			//검증 rect1 과 rect가 겹치지 않게 하는 검증.
			//가능한 범위 설정 > 스타트점(x,y),(x+w,y+h)x기준으로 미만이거나 x+w의 초과이거나. y도 같다. 
			
			if((rX+this.rect1.getW() < this.rect1.getX() || rX > this.rect1.getX() + this.rect1.getW()) 
			|| rY+this.rect1.getY() < this.rect1.getY() || rY > this.rect1.getY() + this.rect1.getH()) {
				break;
		}
		
			
			if(this.rect1.getX() == this.rect2.getX()) {
				
			}
			
			if(!check) {
				this.rect2= new Rect(rX,rY,100,100,Color.green);
				break;
			}
		}
	}

	private void setBtn() {
		String[] text = {"◀","▼","▶","▲"};		
		int x =500;
		int y =500;
		
		for(int i=0; i<4; i++) {
			JButton bt = new JButton();
			bt.setBounds(x, y, 50, 50);
			bt.setText(text[i]);
	//		bt.addActionListener(this);//this:bt
			add(bt);
			bt.addMouseListener(this);
			
			this.btn[i] = bt;
			
			x+=50;
			
			if(i == this.btn.length-1 -1) {
				y-=50;
				x-=100;
			}
		}
		
		
	}

	

	@Override
	protected void paintChildren(Graphics g) {
		super.paintChildren(g);
		//draw rect 
		
		if(this.rect1 != null && this.rect2 != null) {
			g.setColor(Color.orange);
			g.drawRect(this.rect1.getX(), this.rect1.getY(), this.rect1.getW(), this.rect1.getH());
			
			if(this.check)
				g.setColor(Color.BLACK);
			else
			g.setColor(Color.BLUE);
			g.drawRect(this.rect2.getX(), this.rect2.getY(), this.rect2.getW(), this.rect2.getH());
			
			
		}
		
		repaint();
		if(isMoving)
			update();
	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}


	@Override
	public void mousePressed(MouseEvent e) {
		this.isMoving = true;
		
		if(e.getSource() instanceof JButton) {//형변환! 겟소스!
				JButton target = (JButton) e.getSource();
				
				if(target == this.btn[LEFT]) {
					this.dir=LEFT;
				}
				else if(target == this.btn[DOWN]) {
					this.dir=DOWN;
				}
				else if(target == this.btn[RIT]) {
					this.dir=RIT;
				}
				else if(target == this.btn[UP]) {
					this.dir=UP;
			}
				
		}	
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		//check button
		
		this.isMoving = false;
		
		
	}


	private void update() {
		
		checkSecond();	
		
		if(this.dir ==LEFT) {
			if(! check && this.rect1.getX() > 0 || (check && this.rect2.getX()>0 && this.rect1.getX() > this.rect2.getW()))
				this.rect1.setX(this.rect1.getX()-1);
		}
		else if(this.dir ==DOWN) {
			if(!check &&this.rect1.getY() < SIZE - this.rect1.getH() || (check && this.rect2.getY() < SIZE - this.rect2.getH()) )
				this.rect1.setY(this.rect1.getY()+1);
		}
		else if(this.dir ==RIT) {
			if(! check && this.rect1.getX() < SIZE - this.rect1.getW() || (check && this.rect2.getX()< SIZE - this.rect2.getW()))
				this.rect1.setX(this.rect1.getX()+1);
		}
		else if(this.dir ==UP) {
			if(!check && this.rect1.getY() > 0 || (check && this.rect2.getY()> 0))
				this.rect1.setY(this.rect1.getY()-1);
		}
		this.check = false;
	}

	private void checkSecond() {
		// 네모1의 왼쪽위의 (x,y)지점이으로 이동하면서 네모2의 오른쪾아래 (x+W)가 닿으면!
		
		if(this.dir == LEFT) { 
			if(this.rect2.getX()+this.rect2.getW() >= this.rect1.getX() 
					&& this.rect2.getY() > this.rect1.getY() - this.rect1.getH()
					&& this.rect2.getY() < this.rect1.getY() + this.rect1.getH()){
				//	&& this.rect2.getX() >0) {
				
					if(this.rect2.getX()>0)
						this.rect2.setX(this.rect2.getX()-1);
						this.check = true;
			}
		
		}else if(this.dir == DOWN) {
			if(this.rect2.getY() <= this.rect1.getY()+this.rect1.getH()
				&& this.rect2.getX() > this.rect1.getX()-this.rect1.getW()
				&& this.rect2.getX() < this.rect1.getX()+this.rect1.getW()) {
				//&& this.rect2.getY()< SIZE - this.rect2.getH()) {
				
			if(this.rect2.getY() <SIZE - this.rect2.getH())
				this.rect2.setY(this.rect2.getY()+1);
			this.check = true;
			}
		}else if(this.dir == RIT) {
			if(this.rect2.getX() <= this.rect2.getX()+this.rect1.getW() 
				&& this.rect2.getY() > this.rect1.getY() - this.rect1.getH()
				&& this.rect2.getY() < this.rect1.getY() + this.rect1.getH()) {
			//&& this.rect2.getX() < SIZE - this.rect2.getW()) {
				
				if(this.rect2.getX() < SIZE - this.rect2.getW())
					this.rect2.setX(this.rect2.getX()+1);
					this.check = true;
			}
		}
		else if(this.dir == UP) {
			if(this.rect2.getY()+this.rect2.getH() >= this.rect1.getY()
				&& this.rect2.getX() > this.rect1.getX() - this.rect1.getW()
				&& this.rect2.getX() < this.rect1.getX() + this.rect1.getW()) {
				//&& this.rect2.getX() >0) {
				if(this.rect2.getY()>0)
				this.rect2.setY(this.rect2.getY()-1);
				this.check = true;
			}
		}
		else check = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

class Pu extends JFrame{
	
	private Pupaly pu = new Pupaly();
	
	
	public Pu() {
		
		super("Push!");
		setLayout(null);
		setBounds(50, 50, 700, 700);
		setVisible(true);
		
		add(pu);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		
		
	}
	
	
	
}

public class pushpush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Pu p = new Pu();
	}

}
