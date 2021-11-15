package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*1to50 
 * 타이머
 * 클릭과 동시에 시작 50누르면 스탑.
 * 클리어후, 소요시간 알림창
 */


class Time extends JFrame implements Runnable{
	
	private JLabel timer = new JLabel();
	
	public Time() {
		super("clork");
		setLayout(null);
		setBounds(100,100,400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setTimer();
		
		setVisible(true);
		revalidate();
	}
	
	private void setTimer() {
		this.timer.setBounds(0, 0, 400, 400);
		this.timer.setText("ready");
		this.timer.setFont(new Font("", Font.BOLD, 50));
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		this.timer.setVerticalAlignment(JLabel.CENTER);
		add(this.timer);
	}
	public void setTimer(int time) {
		this.timer.setText(String.format("%5d.%3d", time/1000, time%1000)); //%5d는 5칸을 띄운다랑 의미 (.이 고정이됨)
	}

	@Override
	public void run() {
		
		int n=0;
		while(true) {
			n++;
			try {
			Thread.sleep(1);	
				
			}catch(Exception e) {
				
			}
		}
	}
}


class OneGame extends JPanel implements ActionListener{
	Font font = new Font("",Font.BOLD, 25);
	
	boolean Time = false;
	
	private JButton[][] map;
	private int front[][];
	private int back[][];
	private JButton bt = new JButton();
	
	private int num;
	
	Random rn = new Random();
	
	public OneGame() {
		
		
		setLayout(null);
		bt = new JButton();
		bt.setBounds(0,0,800,800);
		bt.setBackground(Color.pink);
		bt.setOpaque(true);
		bt.setBorderPainted(false);
		
		bt.addActionListener(this);
		add(bt);
		
		map = new JButton[5][5];
		front =new int [5][5];
		back=new int[5][5];
		num=1;
		
		
		int n =1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				front[i][j] = n;
				back[i][j] = 25+n;
				n+=1;
			}
		}
		num_shuffle();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				this.map[i][j] = new JButton();
				this.map[i][j].setText(front[i][j]+"");
				this.map[i][j].setFont(font);
				this.map[i][j].setBounds(i*100, j*100, 100, 100);
				
				this.map[i][j].setOpaque(true);
				this.map[i][j].setBorderPainted(false);
				
				this.map[i][j].setBackground(Color.orange);
				this.map[i][j].addActionListener(this);
				
				add(this.map[i][j]);
			}
		}
		
		
	}
	
	public void num_shuffle() {
		
		for(int i=0; i<1000; i++) {
			int r1 = rn.nextInt(5);
			int r2 = rn.nextInt(5);
			
			int temp = front[r1][r2];
			front[r1][r2] = front[0][0];
			front[0][0] =temp;
		}
		
		for(int i=0; i<1000; i++) {
			int r1 =rn.nextInt(5);
			int r2 =rn.nextInt(5);
			
			int temp = back[r1][r2];
			back[r1][r2] = back[0][0];
			back[0][0] = temp;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(e.getSource()==this.map[i][j]) {//버튼 눌렀을때(타이머)
					Time = true;
					
					if(map[i][j].getText().equals(num+"")) {
					if(num < 26) {
						map[i][j].setText(back[i][j]+"");
						num+=1;
						bt.setText("next :" + num);
					}else{
						map[i][j].setText("X");
						num +=1;
						}
					}if(num > 50) {
						bt.setText("GAME CLEAR!");
						Time = false;
					}else {
						bt.setText("next num: "+num);
					}
				}
			}
		}
	}
	
}


class Myone extends JFrame{
	
//	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
//	public static int width = dm.width;
//	public static int height = dm.height;
//	
//	public static final int SIZE = 800;
	
	public OneGame Panel = new OneGame();
	
	public Myone(){
		
		setLayout(null);//레이아웃이 디폴트로 되지않도록 풀어진다.
		setTitle("1 to 50");
		
		setBounds(100,100,800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(Panel);
		
		setVisible(true);
		revalidate();//프레임위에서 변화하고있는 프레임인지
	}
}



public class one_to_50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Myone my = new Myone();
	}

}
