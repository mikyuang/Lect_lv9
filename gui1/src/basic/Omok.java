package basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class Winner extends JFrame{
	private JLabel text = new JLabel();
	
	public Winner(int win) {
		
		super("GAME CLARE!");
		
		setLayout(null);
		setBounds(500, 500, 300, 200);
		
		this.text.setText(String.format("%s 승리!",win));
		this.text.setBounds(0, 0, 200, 200);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		
		add(this.text);
		setVisible(true);
	}
	
	
}

class Gameplay extends JPanel implements ActionListener{
	
	private JButton btn[][];
	private JButton restart = new JButton();
	private JButton result = new JButton();
	
	private JLabel title = new JLabel("오.목.게.임");
	private JLabel nextturn = new JLabel();
	
	private final int SIZE = 30;
	private int omok[][] = new int[SIZE][SIZE];
	
	private int turn=0;
	private int win=0;
	
	public Gameplay() {
		setLayout(null);
		setBounds(0, 0, 800, 800);
		setBackground(Color.white);
		
		setTitle();
		setMap();
		setNextturn();
		
//		setResult();
		setReButton();
	}

	private void setNextturn() {
		this.nextturn.setText("Next turn : "+turn);
		
	
	}

	private void setReButton() {
		this.restart.setText("RESET");
		this.restart.setBounds(350, 680, 100, 50);
		this.restart.addActionListener(this);
		
		add(restart);
		
	}

	private void setTitle() {
		this.title.setBounds(0, 0, 790, 100);
		this.title.setFont(new Font("",Font.PLAIN,30));
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.BOTTOM);
		add(title);
		
	}

//	private void setResult() {
//		
//		this.result.setBounds(400, 700, 100, 50);
//		this.result.setBackground(new Color(111, 105, 172));
//		
//		add(result);
//		
//	}




	private void setMap() {
		btn = new JButton[SIZE][SIZE];
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				btn[i][j] = new JButton();
				btn[i][j].setBounds(130+17*(j+1), 130+17*(i+1), 17, 17);
				btn[i][j].setBackground(new Color(251, 243, 228));
				
				
				btn[i][j].setOpaque(true);
				btn[i][j].setBorderPainted(false);
				
				btn[i][j].addActionListener(this);
				
				add(this.btn[i][j]);
				

			}
		}
		
	}

	public void win() {
		int check =0;
		for(int i=2; i<SIZE-2; i++) {
			for(int j=2; j<SIZE-2; j++) {
					if(omok[i][j] ==1 && omok[i][j-1] == 1 && omok[i][j-2] ==1 && omok[i][j+1]==1 && omok[i][j+2] ==1) {
						check = 1;
					}else if(omok[i][j] ==2 && omok[i][j-1] == 2 && omok[i][j-2] ==2 && omok[i][j+1]==2 && omok[i][j+2] ==2) {
						check =2;
					}
					if(omok[i][j] ==1 && omok[i-1][j] == 1 && omok[i-2][j] ==1 && omok[i+1][j]==1 && omok[i+2][j] ==1) {
						check =1;
					}else if(omok[i][j] ==1 && omok[i-1][j] == 1 && omok[i-2][j] ==1 && omok[i+1][j]==1 && omok[i+2][j] ==1) {
						check = 2;
				}
			}
		}
		
		for(int i=2; i<SIZE-2; i++) {
			for(int j=2; j<SIZE-2; j++) {
				if(omok[i][j] ==1 && omok[i-1][j-1] == 1 && omok[i-2][j-2] ==1 && omok[i+1][j+1]==1 && omok[i+2][j+2] ==1) {
					check = 1;
				}else if(omok[i][j] ==2 && omok[i-1][j-1] == 2 && omok[i-2][j-2] ==2 && omok[i+1][j+1]==2 && omok[i+2][j+2] ==2) {
					check = 2;
				}
			}
		}
		
		for(int i=2; i<SIZE-2; i++) {
			for(int j=2; j<SIZE-2; j++) {
				if(omok[i][j] ==1 && omok[i-1][j+1] == 1 && omok[i-2][j+2] ==1 && omok[i+1][j-1]==1 && omok[i+2][j-2] ==1) {
					check =1;
				}else if(omok[i][j] ==2 && omok[i-1][j+1] == 2 && omok[i-2][j+2] ==2 && omok[i+1][j-1]==2 && omok[i+2][j-2] ==2) {
					check =2;
				}
			}
		}
		
		if(check ==1) {
			win =1;
		}else if(check ==2) {
			win =2;
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target =(JButton)e.getSource();
			
			if(target == this.restart) {
				System.out.println("reset!");
				setRe();
				
			}else {
				for(int i=0; i<SIZE; i++) {
					for(int j=0; j<SIZE; j++) {
				
				if(turn % 2 == 0) {
					if(omok[i][j] == 0) {
						if(target == this.btn[i][j]) {
							this.btn[i][j].setBackground(Color.black);
							this.omok[i][j]= 1;
							turn +=1;
						}
					}
				}else if(turn % 2 == 1){
					
					if(omok[i][j] ==0)
						if(target == this.btn[i][j])
							this.btn[i][j].setBackground(Color.white);
							this.omok[i][j] = 2;
							turn += 1;
						}

					}
				}

			}

		}
	}
	
	
	

	private void setRe() {
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					this.btn[i][j].setBackground(new Color(251, 243, 228));
				}
			}
			omok = new int[SIZE][SIZE];
			turn =0;
			win=0;
		}
}

class Ogame extends JFrame{
	
	private Gameplay panel = new Gameplay();
	
	public Ogame() {
		
		super("오목 게임!");
		setLayout(null);
		setBounds(100, 100, 800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		
		
		setVisible(true);
		validate();
		
	}
	
}


public class Omok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ogame og = new Ogame();
	}

}
