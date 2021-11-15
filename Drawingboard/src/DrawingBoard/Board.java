package DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

class NemoPanal extends MyUtil {
	
	
	private ArrayList<Nemo> nemo = new ArrayList<Nemo>(); //계속해서 생성하기 위해서는 배열이 필요하다 차곡차곡 
	private ArrayList<Nemo> circles = new ArrayList<Nemo>();
	private ArrayList<Nemo> triangles = new ArrayList<Nemo>();
	
	
	private Nemo ne = null; // 프레스 지점을 가지고 있기때문에 이걸 활용할것.
	
	
	private final int RECTANGLE=0;
	private final int CIRCLE=1;
	private final int TRI=2;
	
	private String[] btnText = {"☐","○","△"};
	private JButton[] btn = new JButton[3];
	int type;
	
	private boolean dir;
	
	private int dirX;
	private int dirY;
	
	private int xx;
	private int yy;
	
	private int nemow;
	private int nemoh;
	
	private int dx;
	private int dy;
	
	
	
	private boolean shift;
	
	public NemoPanal(){
		setLayout(null);
		setBounds(0, 0, 800, 800);
		setBackground(Color.white);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setFocusable(true);
		addKeyListener(this);
		
		setButton();
		
	}
	
	private void setButton() {
		
	int x=30;
	int y=50;
	
		for(int i=0; i<this.btn.length; i++) {
			this.btn[i]= new JButton();
			this.btn[i].setBounds(x, y, 50, 50);
			this.btn[i].setText(btnText[i]);
			this.btn[i].addActionListener(this);
			
			add(this.btn[i]);
			
			y+= 50 +3;
		}
		
	}
	
@Override
public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btn[RECTANGLE]) {
			this.type = RECTANGLE;
		}
		else if(e.getSource() == this.btn[CIRCLE]) {
			this.type = CIRCLE;
		}
		else if(e.getSource() == this.btn[TRI]) {
			this.type = TRI;
		}
		
}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//기본 삼각형 그리는 법.
		//g.drawPolygon(int[],int[],int[]); 을 이용.
		//1. x 좌표배열 
		//2. y 좌표배열 
		//3. 꼭지점의 갯수
		
		
		//this.ne : 임시 객체를 타입에 따라 다르게 그려주게끔.
		if(this.ne != null) {
			g.setColor(this.ne.getC());
			
			if(this.type == RECTANGLE) {
				g.drawRect(this.ne.getX(), this.ne.getY(), this.ne.getW(), this.ne.getH());
				
			}
			else if(this.type == CIRCLE) {
				g.drawRoundRect(this.ne.getX(), this.ne.getY(), this.ne.getW(), this.ne.getH(),this.ne.getW(), this.ne.getH());
			}
			
			else if(this.type == TRI) {
				//this.ne 기준으로 -> 삼각형을 그릴 좌표배열 만들기.
				
				int[] xx = new int [3];
				int[] yy = new int[3];
				xx[0] = this.ne.getX();// 시작점이 됨. 100
				yy[0] = this.ne.getY();// 시작점이 됨. 100
				xx[1] = this.ne.getX()-(this.ne.getW()/2);//150
				yy[1] = this.ne.getY()+this.ne.getH();//200
				xx[2] = this.ne.getX()+(this.ne.getW()/2);//50
				yy[2] = this.ne.getY()+this.ne.getH();//200
				g.drawPolygon(xx,yy,3);
			}
			
		}
		//네모
		for(int i=0; i<this.nemo.size(); i++) {
			Nemo  n = this.nemo.get(i);
			g.setColor(n.getC());
			g.drawRect(n.getX(), n.getY(),n.getW(), n.getH());
		}
		
		//동그라미
		for(int i=0; i<this.circles.size(); i++) {
			Nemo n = this.circles.get(i);
			g.setColor(n.getC());
			g.drawRoundRect(n.getX(), n.getY(), n.getW(), n.getH(), n.getW(), n.getH());
		}
		
		//삼각형
		for(int i=0; i<this.triangles.size(); i++) {
			Nemo n = this.triangles.get(i);
			
			int[] xx = new int [3];
			int[] yy = new int[3];
			xx[0] = n.getX();
			yy[0] = n.getY();
			xx[1] = n.getX()-n.getW()/2;
			yy[1] = n.getY()+n.getH();
			xx[2] = n.getX()+n.getW()/2;
			yy[2] = n.getY()+n.getH();
			g.setColor(n.getC());
			g.drawPolygon(xx,yy,3);
			
		}
		
		requestFocusInWindow();
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.shift=true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==e.VK_SHIFT) {
			this.shift = false;
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		
		
		//절대값 구할 수 있는 abs
		int w = this.type == TRI ? x - dirX : Math.abs(x-dirX);
		int h = this.type == TRI ? y - dirY : Math.abs(y-dirY);
		
		
		//이제 그림을 그리면 된다.!
		//여기서 문제 -좌표는 안 그려질 수 있음.
		//해결책 -> 스타트 좌표를 바꿔줘야한다.
		//(start x,start y -> x-w , y-h)
		
		if(shift)
			w=h;
		
		int neX = dirX;
		int neY = dirY;
		
		if(this.type != TRI) {
			if(x < dirX)
				neX = dirX - w;
			if(y < dirY)
				neY = dirY - h;
		}
		this.ne = new Nemo(neX, neY, w, h, Color.blue);
		
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		this.dx = e.getX();
		this.dy = e.getY();
		
		this.dirX = dx;
		this.dirY = dy;
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.ne.setC(Color.black);
		//this.nemo.add(this.ne);
		
		
		if(this.type == RECTANGLE) {
			this.nemo.add(this.ne);
		}
		else if(this.type == CIRCLE) {
			this.circles.add(this.ne);
		}
		else if(this.type == TRI) {
			this.triangles.add(this.ne);
		}
		
		
		this.ne=null;//초기화로 풀어줌.
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


public class Board {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NemoDrawing  dw = new NemoDrawing();
	}

}
