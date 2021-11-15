package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SnakeRect{
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
	public SnakeRect(int x, int y, int w, int h, Color c) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.c=c;
	}
}


class SnakeGame extends JPanel implements KeyListener , ActionListener,MouseListener{
	//맵, 방향 버튼, 뱀
	
	
	private final int SIZE = 10;
	
	private SnakeRect[][] map = new SnakeRect[SIZE][SIZE];

	private SnakeRect[] snake = new SnakeRect[4];//arraylist<snakeRect>
	
	private int[][] yx = new int [4][2]; //맵인덱스 좌표정보를 기억한다.
										//{{x,y},{x,y}}
	
	private ArrayList<SnakeRect> snake2 = new ArrayList<SnakeRect>(); 
	private ArrayList<ArrayList<Integer>> yx2 = new ArrayList<ArrayList<Integer>>();
	
	private ArrayList<SnakeRect> items = new ArrayList<SnakeRect>();
	private ArrayList<ArrayList<Integer>> itemYx = new ArrayList<ArrayList<Integer>>();
	
	private final int LEFT=0;
	private final int DONW=1;
	private final int RIT=2;
	private final int UP=3;
	private final int STOP=4;
	
	private int dir;
	
	
	
	private JButton[] btn = new JButton[4];
	private JButton reset = new JButton();

	
	public SnakeGame() {
		
		setLayout(null);
		setBounds(0, 0, 700, 500);
		
		
		setMap();
		setSnake();
		setBtn();
		
		setFocusable(true);
		addKeyListener(this);
	}



	private void setBtn() {
		String[] text = {"◀","▼","▶","▲"};	
		int x =700-200;
		int y =500-100;
		
		for(int i=0; i<this.btn.length; i++) {
			this.btn[i] = new JButton();
			
			btn[i].setBounds(x, y, 50, 50);
			btn[i].setText(text[i]);
			
			btn[i].addKeyListener(this);
			btn[i].addActionListener(this);
			
//			btn[i].setOpaque(true);
//			btn[i].setBorderPainted(false);
			
			add(btn[i]);
			x+=50; //초기화
			
			if(i == this.btn.length-1 -1) {
				y-=50;
				x-=100;
			}
		}
		this.reset.setBounds(700-180, y-50,100,50);
		this.reset.setText("reset");
		this.reset.addActionListener(this);
		add(this.reset);
		
	}

	private void setSnake() {
		for(int i=0; i<this.snake.length;  i++) {
			SnakeRect temp = this.map[0][i];
			
			int x = temp.getX();     //temp getX에 값이 null이라서 창 자체가 안 뜨는 오류가 있었음
			int y = temp.getY();	//해결책 -> public SankeGame() 안에 setMap 다음 setSnake 순으로 바꿔줌.
			int w = temp.getW();
			int h = temp.getH();
			Color c = Color.green;
			if(i == 0) 
				c = Color.red;
			
		this.snake[i] = new SnakeRect(x, y, w, h, c);
		
		//좌표를 기억하게한다. 
		int[] pair = new int[2];
		pair[0] = 0; 			//맴 배열의 인덱스y
		pair[1] = i; 			//맵 배열의 인덱스 x
		this.yx[i] = pair;
		}
	}

	private void setMap() {
		this.dir = STOP;
		
		int x = (700-200)/2-40*SIZE/2; //오른쪽으로 치우칠꺼니까 700-200을 해준다. 
		int y = 500/2-40*SIZE/2;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j]= new SnakeRect(x,y,40,40,Color.gray);
				
				x+=40;
				
			}
			x=(700-200)/2-40*SIZE/2;
			y+=40;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		
		if(e.getKeyCode()== e.VK_LEFT){
			this.dir = LEFT;
		}
		else if(e.getKeyCode()== e.VK_DOWN){
			this.dir = DONW;
		}
		else if(e.getKeyCode()== e.VK_RIGHT){
			this.dir = RIT;
		}
		else if(e.getKeyCode()== e.VK_UP){
			this.dir = UP;
		}	
			if(this.dir != STOP)
				update();
				
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.dir = STOP;
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0; i<this.snake.length; i++) {
		SnakeRect s = this.snake[i];
		g.setColor(s.getC());
		g.fillRect(s.getX(), s.getY(), s.getW(), s.getH());
	}
		
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				SnakeRect  r = map[i][j];
					g.setColor(r.getC());
					g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
					
			}
			
		}
		
		
		
		requestFocusInWindow(); //키 리스너를 위한 포커스를 재요청 셋트니까 같이 외워둘것.
		repaint();
		
	}
	
	
	private void update() {
		//맵의 머리기준으로 맵의 좌표를 기억하게끔 만들어주는 부분.
		
		int yy = this.yx[0][0];//머리 좌표 
		int xx = this.yx[0][1];
		
		if(this.dir == LEFT) {
			xx--;
		}
		else if(this.dir == DONW) {
			yy++;
		}
		else if(this.dir == RIT) {
			xx++;
		}
		else if(this.dir == UP) {
			yy--;
		}
		
		if(xx < 0 || xx >= SIZE || yy < 0 ||yy >= SIZE)//안되는 조건들 
			return;
	
		this.dir = STOP;
		
		boolean bodyCheck = false;
		for(int i=0; i<this.yx.length; i++) {
			if(yy == this.yx[i][0] && xx == this.yx[i][1])
				bodyCheck = true;
		}
		if(bodyCheck)
			return;
		
		
		//무빙.
		for(int i=this.snake.length-1; i>0; i--) {
			this.snake[i] = this.snake[i-1];
			this.snake[i].setC(Color.ORANGE); 
			
			//좌표갱신!
			//this.yx[i] = this.yx[i-1]; //주소가 공유되면 안된다.(버그 > 뱀의 머리가 자꾸 중간에 사라짐.)
			int[] pair = new int[2]; //새로운 객체를 만들어서 분리시켜줌. <해결책.
			pair[0] = this.yx[i-1][0];
			pair[1] = this.yx[i-1][1];
			this.yx[i] = pair;
			
		}
		
		SnakeRect t = this.map[yy][xx];
		this.snake[0]= new SnakeRect(t.getX(), t.getY(), t.getW(), t.getH(), Color.red);
		
		//좌표 갱신 
		this.yx[0][0] = yy;
		this.yx[0][1] = xx;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton) {
			JButton target =(JButton) e.getSource();
			
			if(target == this.reset) {
				resetMap();
			}else {
				if(target == this.btn[LEFT]) {
					this.dir = LEFT;
				}
				if(target == this.btn[DONW]) {
					this.dir =DONW;
				}
				if(target == this.btn[RIT]) {
					this.dir = RIT;
				}
				if(target == this.btn[UP]) {
					this.dir = UP;
				}
				if(this.dir != STOP)
					update();
					
				
			}
		}
		
	}

	private void resetMap() {

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.reset) {
			
			
			
		
		}
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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


public class Snake extends JFrame{
	
	
	
	public Snake() {
		super("snake");
		setLayout(null);
		setBounds(100, 100, 700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new SnakeGame());
		
		setVisible(true);
		revalidate();
	}


	public static void main(String[] args) {
		
		Snake snake = new Snake();
	}

}
