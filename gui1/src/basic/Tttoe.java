package basic;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class My_panel extends JPanel implements ActionListener {
	Font font = new Font("", Font.BOLD, 25); // 폰트 크기설정1

	JButton ttt[][];
	int data[][];
	boolean turn; // true와 false로 턴을 구분함

	JButton winner;
	int win;
	
	JButton reset;

	My_panel() {
		this.setLayout(null);
		basic_set();
		
	}

	void basic_set() {
		turn = true;
		ttt = new JButton[3][3];
		data = new int[3][3];
		winner = new JButton();
		win = 0;
		
		reset = new JButton();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ttt[i][j] = new JButton(); // 해당위치에 버튼생성
				ttt[i][j].setSize(100, 100); // 버튼 사이즈
				ttt[i][j].setLocation(i * 100, j * 100); // 버튼위치
				ttt[i][j].addActionListener(this); // 버튼이 눌린 신호와 마우스를 연결
				add(ttt[i][j]); // 패널에 버튼 부착
				data[i][j] = 0;
				
				ttt[i][j].setFont(font); // 폰트크기설정2
			}
		}

		winner.setSize(150, 100);
		winner.setText("승자는 누구?");	// 버튼 명은 스트링만 가능?
		winner.setLocation(10, 400);
		winner.addActionListener(this);
		add(winner);

		reset.setSize(100, 100);
		reset.setText("reset?");
		reset.setLocation(180, 400);
		reset.addActionListener(this);
		add(reset);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	// 반복문과 actionperformed의 차이점? ==> 버튼이 눌리는 곳으로 이동후 순차적으로 실행
		// 출력 및 턴
		for (int i = 0; i < 3; i++) {
			for (int n = 0; n < 3; n++) {
				if (e.getSource() == ttt[i][n]) {
					if (turn == true) {
						if (data[i][n] == 0) {
							ttt[i][n].setText("O");
							data[i][n] = 1;
							turn = !turn;

						}
					} else {
						if (data[i][n] == 0) {
							ttt[i][n].setText("X");
							data[i][n] = 2;
							turn = !turn;
						}
					}
				}
			}

		}

				// 가로
				for (int i = 0; i < 3; i++) {
					int cnt1 = 0;
					int cnt2 = 0;

					for (int j = 0; j < 3; j++) {
						if (data[i][j] == 1) {
							cnt1 += 1;
						} else if (data[i][j] == 2) {
							cnt2 += 1;
						}
					}
					
					if (cnt1 == 3) {
						win = 1;
					} else if (cnt2 == 3) {
						win = 2;
					}
				}

				// 세로
				for (int i = 0; i < 3; i++) {
					int cnt1 = 0;
					int cnt2 = 0;

					for (int j = 0; j < 3; j++) {
						if (data[j][i] == 1) {
							cnt1 += 1;
						} else if (data[j][i] == 2) {
							cnt2 += 1;
						}
					}
					
					if (cnt1 == 3) {
						win = 1;
					} else if (cnt2 == 3) {
						win = 2;
					}
				}

				// 대각선1
				int cnt1 = 0;
				for (int i = 0; i < 2; i++) {
					if (data[i][i] == 1) {
						cnt1 += 1;
					} else {
						cnt1 = 0;
					}
				}
				if (cnt1 == 3) {
					win = 1;
				}

				int cnt2 = 0;
				for (int i = 0; i < 3; i++) {
					if (data[i][i] == 2) {
						cnt2 += 1;
					} else {
						cnt2 = 0;
					}
				}
				if (cnt2 == 3) {
					win = 2;
				}

				// 대각선2
				int cnt3 = 0;
				for (int i = 0; i < 3; i++) {
					if (data[i][(3 - 1) - i] == 1) {
						cnt3 += 1;
					} else {
						cnt3 = 0;
					}
				}
				if (cnt3 == 3) {
					win = 1;
				}

				int cnt4 = 0;
				for (int i = 0; i < 3; i++) {
					if (data[i][(3 - 1) - i] == 2) {
						cnt4 += 1;
					} else {
						cnt4 = 0;
					}
				}
				if (cnt4 == 3) {
					win = 2;
				}



		if (win != 0) {
			if(win == 1) {
				winner.setText("[P1]의 승리!");				
			}else if(win == 2){				
				winner.setText("[P2]의 승리!");				
			}
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					data[i][j] = 3;
				}
			}
			
		}
		
		if(e.getSource() == reset) {			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					data[i][j] = 0;
					ttt[i][j].setText(" ");
				}
			}
			winner.setText("승자는 누구?");
			turn = true;
			win = 0;
			cnt1 = 0; 
			cnt2 = 0;
			cnt3 = 0;
			cnt4 = 0;
		}
	
	}

}

public class Tttoe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();

		frame.setTitle("틱 택 토");
		frame.setSize(310, 600);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		My_panel mp = new My_panel();
		frame.setContentPane(mp);
		frame.revalidate();


	}

}
