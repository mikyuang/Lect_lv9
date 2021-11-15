package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


//드로우에 필요한 객체를 만들었다. 3D작업이라고 생각하면 쉽다.

//11.12
//mouse 모션리스터를 활용해서 사각형을 만들어서 그 마우스를 잡고 드래그


class Nemo{
	private int x,y,width,height;
	private Color c;
	
	public Nemo(int x, int y, int width, int height, Color c) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.c=c;
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
}

class My_p extends JPanel implements MouseListener , MouseMotionListener{
	
//	private Nemo nemo = new Nemo();
	
	private Nemo[][] map = new Nemo[3][3];
	
	private Nemo ne=null;
	
	boolean dir = false;
	int dirX;
	int dirY;
	
	
	
	public My_p() {
	setLayout(null);
	setBounds(0, 0, 500, 400);
	setBackground(Color.white);
	
//	nemo.setX(100);
//	nemo.setY(100);
//	nemo.setWidth(200);
//	nemo.setHeight(200);
//	nemo.setC(Color.orange);
	
	//setMap();
	
	setNemo();
	
	//패널에 혹은 독점하는 컴포넌트에 > 마우스 리스너를 달 수 있다. 
	addMouseListener(this);
	addMouseMotionListener(this);
}
	
	
private void setNemo() {
	Random rn = new Random();//랜덤하게 생성.
	int rX = rn.nextInt(500);
	int rY = rn.nextInt(400);
	
	this.ne = new Nemo(rX, rY,100,100,Color.pink);
	
	}



//	private void setMap() {
//		int x =40;
//		int y =40;
//		
//		for(int i=0; i<3; i++) {
//			for(int j=0; j<3; j++) {
//				this.map[i][j] = new Nemo(x, y, 50, 50, Color.red);
//				x+= 40;
//			}
//			x=40;
//			y+=40;
//		}
//		
//	}
	//paintComponent 메소드 오버라이딩 JComponent
	@Override
		protected void paintComponent(Graphics g) {//페인트상의 쓰레드를 돔 
		//화면상의 그래픽을 그려주는 역활을 한다. 
			super.paintComponent(g);//> 그래픽을 초기화 
			
			
			//2D오 그냥 그려놓기만한것. 사용할순없다. 그러기위해선 객체를 만든다. 
//			g.setColor(Color.pink);
//			g.drawRect(100, 100, 100, 1000);
//			g.setColor(this.nemo.getC());
//			g.drawRect(this.nemo.getX(),  this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight());
//			for(int i=0; i<3; i++) {
//				for(int j=0; j<3; j++) {
//					Nemo temp= this.map[i][j];
//					g.setColor(Color.orange);
//					//동그라미로 그려주는 매소드 
//					g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), temp.getWidth(), temp.getHeight());
//				}
//			}
			
			
			g.setColor(this.ne.getC());
			g.fillRect(this.ne.getX(), this.ne.getY(), this.ne.getWidth(), this.ne.getHeight());
			
			repaint();//기본 셋트 꼭 닫아주자!
			
		}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("클!");
		
		
		
		int x = e.getX();
		int y = e.getY();
		
		System.out.println(x+"/"+y);
		
//		if(x > this.ne.getX() && x < this.ne.getX() + this.ne.getWidth() && y > this.ne.getY()+this.ne.getHeight())
//			dir = true;
//			dirX = x - this.ne.getX();
//			dirY = y - this.ne.getY();
		
			//1. 이벤트가 발생한 지점을 검증!<상자안에 클릭했는지.
		if(x >= this.ne.getX() && x < this.ne.getX()+this.ne.getWidth() 
		&& y >= this.ne.getY() && y < this.ne.getY()+this.ne.getHeight()) {
			this.dir = true;
			this.dirX = x - this.ne.getX();//기존의 값과 현재의값과의 캡차이를 여기서만!!
			this.dirY = y - this.ne.getY();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("릭!");	
		
		this.dir = false; //클릭이 떨어지면 이벤트 종료.
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("안녕~!");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("잘가~~");		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int x =e.getX();
		int y =e.getY();
		
		if(dir == true) {
			this.ne.setX(x-dirX);///getX라고 해서!!!!!!
			this.ne.setY(y-dirY);
			
		}
		
		
			
	
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("moved");
		
		dirX=this.ne.getX();
		dirY=this.ne.getY();
		
	//	repaint();
		
	}
}

class Mmf extends JFrame{
	
	public Mmf() {
		setLayout(null);
		setTitle("myR");
		setBounds(50, 50, 500, 400);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new My_p());
		
		setVisible(true);
		revalidate();
	}
}


public class Ex1105 {

	public static void main(String[] args) {

		Mmf mg = new Mmf();
	}

}
