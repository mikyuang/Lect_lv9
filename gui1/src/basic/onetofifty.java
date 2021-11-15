package basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//복습 - 횟수 

class AlertResult extends JFrame{
	
	private JLabel text = new JLabel();
	
	public AlertResult(int ms) {
		super("Game claer");
		setLayout(null);
		setBounds(100, 100, 300, 200);
		
		this.text.setText(String.format("성적 : %5d.%3d 소요",  ms/1000, ms%1000));
		this.text.setBounds(0, 0, 300, 200);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		
		add(this.text);
		setVisible(true);
	}
}


class GamePalne extends JPanel implements ActionListener ,Runnable{
	
	private JLabel title = new JLabel("1 to 50");
	private JLabel timer = new JLabel("READY");
	private int ms;
	private boolean isRun;
	
	private final int SIZE =5;
	private JButton[][] map = new JButton[SIZE][SIZE];
	private int[][] front = new int [SIZE][SIZE];
	private int[][] back = new int [SIZE][SIZE];
	
	private JButton reset = new JButton();
	
	private int gameNum=1;
	
	public GamePalne() {
		
		setLayout(null);
		setBounds(0, 0, 700, 800);
		
		setTitle();
		setTimer();
		
		setData();
		setMap();
		
		setResetButton();
	}
	
	private void setResetButton() {
		this.reset.setText("RESET");
		this.reset.setBounds(700/2-100/2,800-150, 100, 50);
		this.reset.addActionListener(this);
		
		add(this.reset);
	}

	private void setTimer() {
	this.timer.setBounds(20, 0, 200, 50);
	this.timer.setBackground(Color.gray);
	this.timer.setHorizontalAlignment(JLabel.CENTER);
	
	add(this.timer);
		
	}

	private void setTitle() {
		this.title.setBounds(0,0,700,100);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.BOTTOM);
		this.title.setFont(new Font("", Font.BOLD,30));
		
		add(this.title);
	}
		
	

	private void setData() {
		int n=1;
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++) {
				this.front[i][j] =n;
				this.back[i][j] = n + SIZE*SIZE;
				n++;
			}
		}
		shuffle();
	}
	
	
	private void shuffle() {
		Random rn = new Random();
		
		for(int i=0; i<1000; i++) {
			int r1 = rn.nextInt(SIZE);
			int r2 = rn.nextInt(SIZE);
			
			int temp = this.front[0][0];
			this.front[0][0] = this.front[r1][r2];
			this.front[r1][r2] =temp;
		
		
			 r1 = rn.nextInt(SIZE);
			 r2 = rn.nextInt(SIZE);
			
			temp = back[0][0];
			back[0][0] = back[r1][r2];
			back[r1][r2] = temp;
		}
		
	}
	private void setMap() {
		int x = 700/2-100*SIZE/2;
		int y = 700/2-100*SIZE/2;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j] = new JButton();// 인스턴스만 존재 집터만 만들어둔 상태 
			
				this.map[i][j].setBounds(x, y, 100, 100); //집크기 위치 선정 
				this.map[i][j].setText(this.front[i][j]+""); //간판 
				this.map[i][j].setFont(new Font("THEJung170",Font.PLAIN,20));
				
				
				this.map[i][j].setOpaque(true);
				this.map[i][j].setBorderPainted(false);
				
				this.map[i][j].setBackground(Color.ORANGE);
				this.map[i][j].addActionListener(this); //기능, 초인종을 달았다!
			
				add(this.map[i][j]);
			
			x+= 100+3;
			
		}
		x=700/2-100*SIZE/2;
		y += 100+3;
		
	}
	
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton taget =(JButton)e.getSource();
			
			if(taget == this.reset) {
				System.out.println("reset");
				resetGame();
			}else {
				for(int i=0; i<SIZE; i++) {
					for(int j=0; j<SIZE; j++) {
						if(taget == this.map[i][j] && this.front[i][j] == this.gameNum) {
							if(!isRun)
								isRun = true;
						
						
						this.front[i][j] = this.back[i][j];
						this.back[i][j] =0;
						
						if(this.front[i][j] ==0) {
							this.map[i][j].setBackground(Color.white);
							this.map[i][j].setText("");
						}
						else {
							this.map[i][j].setBackground(Color.pink);
							this.map[i][j].setText(this.front[i][j]+"");
						}
						this.gameNum++;
						
						isRun = winCheck();
						if(!isRun)
							new AlertResult(this.ms);//성적 출력
					}
				}
			}
		}
	}
}	
	
	private void resetGame() {
		this.gameNum =1;
		
		isRun = false;
		this.ms =0;
		this.timer.setText("READY");
		
		setData();
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j].setText(this.front[i][j]+"");
				this.map[i][j].setBackground(Color.orange);
			}
		}
	}

	private boolean winCheck() {
		boolean check = false;
//		for(int i=0; i<SIZE; i++) {
//			for(int j=0; j<SIZE; j++) {
//				if(this.front[i][j] != 0)
//					check = true;
//			}
//		}
//		return check;
		
			if(this.gameNum > SIZE * SIZE * 2)
				return false;
			else
				return true;
	}

	@Override
	public void run() {
		while(true) {
			if(isRun) {
			this.ms++;
			this.timer.setText(String.format("%5d.%3d", this.ms / 1000, this.ms % 1000));
			}
			try {
				Thread.sleep(1);
				
			}catch(Exception e) {
				
			}
		}
	}
}

class Game extends JFrame{
	
	private GamePalne panel = new GamePalne(); // runnabel 생성. 
	
	public Game() {
		
		super("one to fifty");
		setLayout(null);
		
		setBounds(50, 50, 700, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		add(panel);
		
		
		setVisible(true);
		revalidate();
		
		panel.run();//생성된 runnable의 호출.>스레드 가동
	}
}

public class onetofifty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game g = new Game();
		
	}

}



