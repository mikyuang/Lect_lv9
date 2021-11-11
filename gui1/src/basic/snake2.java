package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SnakeGame2 extends JPanel implements ActionListener, KeyListener{

	private final int SIZE =10;
	private SnakeRect[][] map = new SnakeRect[SIZE][SIZE];
	
	private ArrayList<SnakeRect>snake = new ArrayList<SnakeRect>();
	private ArrayList<ArrayList<Integer>> yx = new ArrayList<ArrayList<Integer>>();
	
	private ArrayList<SnakeRect>items = new ArrayList<SnakeRect>();
	private ArrayList<ArrayList<Integer>> itemYx = new ArrayList<ArrayList<Integer>>();
	
	private final int LEFT =0;
	private final int DOWN =1;
	private final int RIT =2;
	private final int UP =3;
	private final int STOP =4;
	
	private int dir;
	
	private boolean death;
	
	private JButton[] btn = new JButton[4];
	private JButton reset = new JButton();
	
	
	
	public SnakeGame2() {
		setLayout(null);
		setBounds(0, 0, 700, 500);
		setBackground(Color.white);
		setMap();
		setSnake();
		setItems();
		setButton();
		
		setFocusable(true);
		addKeyListener(this);
	}

	private void setButton() {
		String[] text = {"←","↓","→","↑"};
		int x = 700-200;
		int y = 500-100;
		
		for(int i=0; i<this.btn.length; i++) {
			this.btn[i] = new JButton();
			
			this.btn[i].setBounds(x, y, 50, 50);
			this.btn[i].setText(text[i]);
			
			this.btn[i].addKeyListener(this);
			this.btn[i].addActionListener(this);
			add(this.btn[i]);
			
			x+=50;
			
			if(i == this.btn.length-1 -1) {
				x-=100;
				y-=50;
			}
		}
		this.reset.setBounds(700-180, y-50, 100, 50);
		this.reset.setText("RESET");
		this.reset.addActionListener(this);
		add(this.reset);
		
	}

	private void setItems() {
		Random rn = new Random();
		int r = rn.nextInt(SIZE*SIZE/5)+5; //5개이상 25개 이하
		
		for(int i=0; i<r; i++) {
			int rY = rn.nextInt(SIZE);
			int rX = rn.nextInt(SIZE);
			
			//뱀이 있는지 없는지 검증을 해야함.
			boolean check = false;
			
			for(int j=0; j<this.yx.size(); j++) {
				if(rY == this.yx.get(j).get(0) && rY== this.yx.get(j).get(1))
					check = true;
				if(check) {
					i--; //i의 대상이 바깥에 있는 i를 가르키고 있기 때문에 continue를 하면 무한 루프에 갇친다. 그래서 break로 수정하였다.
				break;
					
				}
			}
			if(check) 
				continue;
				
			for(int j=0; j<this.itemYx.size(); j++) {
				if(rY == this.itemYx.get(j).get(0) && rX == this.itemYx.get(j).get(1))
					check = true;
				if(check) {
					i--;
					break;
				}
			}
			
			if(! check) {
				SnakeRect t = this.map[rY][rX];
					this.items.add(new SnakeRect(t.getX()+10,t.getY()+10, 20, 20,new Color(240, 165, 0)));
					
					ArrayList<Integer>pair = new ArrayList<Integer>();
					pair.add(rY);
					pair.add(rX);
					this.itemYx.add(pair);
			}
			System.out.println("items : "+ this.items.size());
		}
		
		
	}
	
	private void setSnake() {
		
		for(int i=0; i<4; i++) {
			SnakeRect t = this.map[0][i];
			Color c = new Color(211, 228, 205);
			if(i == 0)
				c = new Color(153, 167, 153);
			
			this.snake.add(new SnakeRect(t.getX(),t.getY(),t.getW(),t.getH(),c));
			
			//yx
			ArrayList<Integer> pair = new ArrayList<Integer>();
			pair.add(0); //맵의 y인덱스  
			pair.add(i);//맵의 x인덱스 
			this.yx.add(pair);
			
		}
	}

	private void setMap() {
		int x = (700-200)/2-40*SIZE/2;
		int y = 500/2-40*SIZE/2;
			
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j] = new SnakeRect(x,y,40,40,Color.gray);
				x +=40;
			}
			x = (700-200)/2-40*SIZE/2;
			y +=40;
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//snake
		for(int i=0; i<this.snake.size(); i++){
			SnakeRect r = this.snake.get(i);
			Color c = r.getC();
			if(death)
				c=Color.red;
			g.setColor(c);
			g.fillRect(r.getX(), r.getY(), r.getW(), r.getH());
		}
		
		//item
		for(int i=0; i<this.items.size(); i++) {
			SnakeRect r = this.items.get(i);
			g.setColor(r.getC());
			g.fillRoundRect(r.getX(), r.getY(), r.getW(), r.getH(),r.getW(), r.getH());
		}
		//map
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				SnakeRect r = this.map[i][j];
				g.setColor(r.getC());
				g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
			}
		}
		requestFocusInWindow();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_LEFT)
			this.dir = LEFT;
		if(e.getKeyCode() == e.VK_DOWN)
			this.dir = DOWN;
		if(e.getKeyCode() == e.VK_RIGHT)
			this.dir = RIT;
		if(e.getKeyCode() == e.VK_UP)
			this.dir = UP;
		
		move();
		
	}

	private void move() {
		int yy = this.yx.get(0).get(0);
		int xx = this.yx.get(0).get(1);
		
		
		if(this.dir == LEFT)
			xx--;
		else if(this.dir == DOWN)
			yy++;
		else if(this.dir == RIT)
			xx++;
		else if(this.dir == UP)
			yy--;
		
		//체크
		if(xx < 0  || xx >= SIZE || yy < 0 || yy >= SIZE)
			return;
		
		//몸체크!
		for(int i=0; i<this.yx.size(); i++) {
			if(yy== this.yx.get(i).get(0) && xx == this.yx.get(i).get(1))
				this.death = true;
		}
		//아이템 체크
		boolean isGrow = false;//몸통이 아이템으로 커진것을 체크
		for(int i=0; i<this.itemYx.size(); i++) {
			if(yy ==this.itemYx.get(i).get(0) && xx == this.itemYx.get(i).get(1)) {
				isGrow = true;
			this.items.remove(i);//먹은 아이템 삭제.
			this.itemYx.remove(i);
			
			}
		}
		
		
		if(!death) {
			SnakeRect tail = this.snake.get(this.snake.size()-1);
			ArrayList<Integer> tailYx = this.yx.get(this.yx.size()-1);
			
			
			for(int i=this.snake.size()-1; i>0; i--) {
				SnakeRect temp = this.snake.get(i-1);
				temp.setC(new Color(153, 167, 153));
				this.snake.set(i, temp);
				
				ArrayList<Integer> pair = this.yx.get(i-1);//좌표수정해서 물려받기 한다. 
				this.yx.set(i, pair);
			}
			SnakeRect t = this.map[yy][xx];
			this.snake.set(0, new SnakeRect(t.getX(),t.getY(),t.getW(),t.getH(),Color.red));
			ArrayList<Integer>pair = new ArrayList<Integer>();
			pair.add(yy);
			pair.add(xx);
			this.yx.set(0, pair);
			
			if(isGrow) {
				this.snake.add(tail);
				this.yx.add(tailYx);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.dir = STOP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target =(JButton)e.getSource();
			
			if(target == this.reset) {
				resetMap();
				
			}else {
				if(target == this.btn[LEFT]) {
					this.dir = LEFT;
				}else if(target == this.btn[DOWN]) {
					this.dir = DOWN;
				}else if(target == this.btn[RIT]) {
					this.dir = RIT;
				}else if(target == this.btn[UP]) {
					this.dir = UP;
				}
			
			}
		}
		
	}

	private void resetMap() {
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j].setC(Color.gray);
			}
		}
		move();
		
		this.reset.setVisible(false);
	}
}



public class snake2 extends JFrame{

	 public snake2() {
		 
		 super("Snake");
		 setLayout(null);
		 setBounds(100, 100, 700, 500);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		 add(new SnakeGame2());
		setVisible(true);
		revalidate();
		 
		 
		 
	 }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		snake2 s2 = new snake2();
	}

}
