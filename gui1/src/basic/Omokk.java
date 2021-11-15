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


class ButtonPanel extends JPanel{
	
	public JButton reset = new JButton();
	
	public ButtonPanel() {
		setLayout(null);
		setBounds(0, 0, OmokFrame.SIZE, OmokFrame.SIZE);
		setResetButton();
	}
	private void setResetButton() {
		this.reset.setText("RESET");
		this.reset.setFont(new Font("",Font.PLAIN,50));
		this.reset.setBounds(OmokFrame.SIZE/2-150, OmokFrame.SIZE/2-150, 300, 300);
		
		add(this.reset);
		
	}
}


class AlertResult extends JFrame{
	private JLabel text = new JLabel();
	
	public AlertResult(String str){
		super("GAME OVER");
		setBounds(OmokFrame.W/2-150, OmokFrame.H/2-100, 300, 200);
	
		text.setText(str);	
		text.setBounds(0, 0, 300, 200);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		
		setVisible(true);
		revalidate();
	}
}

class OmokPanal extends JPanel implements ActionListener{
	
	private JLabel text = new JLabel("Omok Game");
	
	private final int size =10;
	private JButton[][] map = new JButton[size][size];
	private int[][] mark = new int[size][size];
	
	private int turn =1;
	private int win;
	
	private ButtonPanel reset = new ButtonPanel();
	
	public OmokPanal(){
		setLayout(null);
		setBounds(0, 0, OmokFrame.SIZE, OmokFrame.SIZE);
		setBackground(new Color(80, 109, 132));
		
		//add하는 순서대로 컴포넌트의 우선순위가 top부터 정해짐 
		//add(추가할 컴포넌트,0) 으로해서 0이 최우선순위로 
		
		this.reset.reset.addActionListener(this);
		add(this.reset);
		this.reset.setVisible(false);
		
		setTitle();
		setMap();
	}


	private void setTitle() {
		this.text.setBounds(0, 0, OmokFrame.SIZE, 100);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		this.text.setFont(getFont());
		add(this.text);
	}


	


	private void setMap() {
		
		int x = OmokFrame.SIZE/2-50*10/2;//프레임의 중앙에 버튼들을 나열하라~
		int y = OmokFrame.SIZE/2-50*10/2;
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				//버튼 생성 
				JButton bt = new JButton();
				//버튼 설정
				bt.setBounds(x, y, 50, 50);
				bt.setBackground(new Color(243, 213, 192));
				
				bt.setOpaque(true);
				bt.setBorderPainted(false);
				
				//이벤트 리스너 달기
				//jbutton : Actionlister <인터페이스로 제공. 
				bt.addActionListener(this); //this :  bt > 이벤트 발생시 메소드인 actionPerformed가 동작.
				
				
				this.map[i][j] = bt;
				
				add(this.map[i][j]);
				//다음 버튼을 위한 좌표 설정.
				x+= 50+1;
				
			}
			x=OmokFrame.SIZE/2-50*10/2;
			y += 50 +1;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton target = (JButton)e.getSource();
			
			if(target == this.reset.reset) {
				resetGame();
				System.out.println("reset!");
				
			}else {
			//맵 안에 있는 버튼이 맞는지,
			//어떤 버튼인지, turn에 따라서 marking
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					if(target == this.map[i][j] && this.mark[i][j] == 0) {//아직 마킹하지 않은 자리 확인
						if(this.turn==1) {
							target.setBackground(new Color(136, 158, 175));
						}else {
							target.setBackground(new Color(212, 180, 153));
						}
						
						this.mark[i][j] = this.turn;//마킹하고 
						checkWin(); 				//검사 
						
						this.turn = this.turn == 1 ? 2 : 1;

					}
				}
			}

		}
	}
}

	private void resetGame() {
		this.mark = new int[size][size];
		this.turn=1;
		this.win=0;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				this.map[i][j].setBackground(new Color(243, 213, 192));
			}
		}
		
		//컴포넌트의 삭제 방법 
//		this.remove(this.reset);
//		this.revalidate();
//		this.repaint();
		
		this.reset.setVisible(false);
	}


	private void checkWin() {
		this.win = this.win == 0 ? checkHori() :  this.win;
		this.win = this.win == 0 ? checkVerti() :  this.win;
		this.win = this.win == 0 ? checkdia() :  this.win;
		this.win = this.win == 0 ? checkReverse() :  this.win;
		
		if(this.win != 0) {
			this.reset.setVisible(true);
			new AlertResult(String.format("p%d win!", this.win));
			
		}
	}
	private int checkReverse() {	// /대각선
		for(int i=4; i<size; i++) {
			for(int j=0; j<size-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt =0;
					for(int k=0; k<5; k++) {
						if(this.mark[i-k][j+k] == this.turn)
							cnt++;
					}
					if(cnt ==5)
						return this.turn;
				}
			}
		}
		return 0;
	}
	private int checkdia() {		//  \대각선 
		for(int i=0; i<size-4; i++) {
			for(int j=0; j<size-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt=0;
					for(int k=0; k<5; k++) {
						if(this.mark[i+k][j+k] == this.turn)
							cnt++;
					}
					if(cnt ==5)
						return this.turn;
				}
				
			}
		}
		return 0;
	}
	private int checkVerti() {//세로
		for(int i=0; i<size-4; i++) { //열에 대한 제한을 주면 세로 체크!
			for(int j=0; j<size; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt =0;
					for(int k=0; k<5; k++) {
						if(this.mark[i+k][j]==this.turn) {
							cnt++;
						}
						if(cnt==5)
							return this.turn;
					}
				}
				
			}
		}
		return 0;
	}


	private int checkHori() { //가로
		for(int i=0; i<size; i++) {
			for(int j=0; j<size-4; j++) {	//행에대한 제한만 주면 가로가 체크!
				if(this.mark[i][j] == this.turn) {
					int cnt =0;
					for(int k=0; k<5; k++) {
						if(this.mark[i][j+k] == this.turn) {
							cnt++;
						}
						if(cnt ==5) {
							return this.turn;
						}
					}
				}
				
				
			}
		}
		return 0;
	}
	
}

class OmokFrame extends JFrame{
	
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int W = dm.width;
	public static final int H = dm.height;
	
	public static final int SIZE =700;
	
	private OmokPanal panell = new OmokPanal();
	
	public OmokFrame() {
		
		super("OMOK");
		
		setLayout(null);
		setBounds(W/2-SIZE/2, H/2-SIZE/2, SIZE, SIZE);//setLocation(x,y ),setSize(int w, int h) 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panell);
		
		setVisible(true);
		revalidate();
		
		
	}
	
}

public class Omokk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OmokFrame o = new OmokFrame();
	}

}
