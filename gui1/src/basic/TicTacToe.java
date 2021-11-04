package basic;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;



//버튼 9개
//빈칸 >클릭후ㅇ,x
//마킹용 Int[]

class ResultFrame extends JFrame{
	//라벨에 텍스트를 붙일 수 있음
	private JLabel text = new JLabel();
	
	
	//300*200
	public ResultFrame(String winText) {
		super("Game Clear!");
		setLayout(null);
		setBounds(MyFramee.WIDTH/2-300/3, MyFramee.HEIGHT/2-200/2,300,200);
		
		text.setBounds(0,0,300,200);
		text.setText("test");
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		
		
		setVisible(true);
		revalidate();
		
	}
	
}



class TicGamee extends JPanel implements AncestorListener, ActionListener{
	
	
	private JButton[] map = new JButton[9];
	private int[] mark = new int[9];
	
	private int turn =1;
	private int win;
	
	
	private JLabel title = new JLabel("틱택토");
	private JButton reset = new JButton("reset");
	
	public TicGamee() {
		setLayout(null);
		setBounds(0, 0, MyFramee.SIZE, MyFramee.SIZE);
		
		setTitle();
		setMap();
		setResetButton();
		
	}
	
	private void setTitle() {
		this.title.setBounds(0,0,MyFramee.SIZE,150);
		this.title.setFont(Font.BOLD,40);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.BOTTOM);
		
		add(this.title);
		
	}
	
	private void setResetButton() {
		this.reset.setBounds(MyFramee.SIZE/2-50, MyFramee.SIZE-150, 100,50);
		this.reset.addActionListener(this);
		add(this.reset);
	}
	
		private void setMap() {
		int x = MyFramee.SIZE/2-100*3/2;
		int y = MyFramee.SIZE/2-100*3/2;
		
		for(int i=0; i<this.map.length; i++) {
			this.map[i] = new JButton();
			this.map[i].setBounds(x,y,100,100);
			
			this.map[i].setOpaque(true);
			this.map[i].setBorderPainted(false);
			this.map[i].setBackground(Color.black);
			
			this.map[i].addAncestorListener(this);
			add(this.map[i]);
			
			x+=100+3;
			if(i %3 ==2) {
				x = MyFramee.SIZE/2-100*3/2;
				y+=100+3;
			}
			
		}
	}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton target = (JButton)e.getSource();
			if(target == this.reset) {
				resetGame();
			}else {
			for(int i=0; i<this.map.length; i++) {
				if(target == this.map[i] && this.mark[i] == 0) {
					if(this.reset.getText().equals("start"))
						this.reset.setText("reset");
					
					if(this.turn == 1)
						target.setBackground(Color.blue);
					else
						target.setBackground(Color.DARK_GRAY);
					this.mark[i] = this.turn;
					
					checkWin();
					
					this.turn = this.turn == 1 ? 2 : 1;
				}
			}
		}
		}
		private void resetGame() {
			this.turn =1;
			this.win=0;
			this.mark = new int[9];
			
			for(int i=0; i<this.map.length; i++) {
				this.map[i].setBackground(Color.magenta);
				
			}
			
		}
		
			private void checkWin() {
				this.win = this.win == 0 ? checkHori() : this.win;
				this.win = this.win == 0 ? checkVerti() : this.win;
				this.win = this.win == 0 ? checkDie() : this.win;
				this.win = this.win == 0 ? checkReverse() : this.win;
				
				if(this.win != 0) {
					System.out.printf("p%d의 승리!\n", this.win);
					new ResultFrame(String.format("p%d의 승!\n",this.win));
				}
	
}
		
		
		private int checkReverse() {
			int cnt =0;
			for(int i=0; i<=3; i++) {
				if(this.mark[i*2]==this.turn)
					cnt++;
			}
			if(cnt ==3)
				return this.turn;
			return 0;
			
		}
		private int checkDie() {
			int cnt =0;
			for(int i=0; i<3; i++) {
				if(this.mark[i*4] == this.turn)
					cnt++;
			}
			if(cnt ==3)
				return this.turn;
			return 0;
		}
		
		private int checkVerti() {
			for(int i=0; i<3; i++) {
				int cnt =0;
				for(int j=0; j<3; j++) {
					if(this.mark[i+j*3]== this.turn)
						cnt++;
				}
				if(cnt ==3) {
					return this.turn;
				}
			}
			return 0;
			
		}
		private int checkHori() {
			for(int i=0; i<this.mark.length; i+=3) {
				int cnt =0;
				for(int j=0; j<3; j++) {
					if(this.mark[i+j] == this.turn)
						cnt ++;
				}
				if(cnt ==3) {
					return this.turn;
				}
				
			}
			return 0;
		}
		
	
	
	
}	





class MyFramee extends JFrame{

	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height= dm.height;
	
	public static final int SIZE = 700;
	
	public MyFramee() {
		setLayout(null);
		setTitle("TIC TAC TOE");
		
		
		setBounds(width/2-SIZE/2, height/2-SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new TicGamee());
		
		setVisible(true);
		revalidate();
		
		
	}
	
}
	




public class TicTacToe {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyFramee f = new MyFramee();
	
		
	}
	
}




