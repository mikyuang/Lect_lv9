package Horse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

	public class controller extends MyUtil implements Runnable{
		
		private Random rn = new Random();
		
		private int ms;
		private boolean isRun;
		
		private JLabel timer = new JLabel();
		
		private JButton start = new JButton();
		
		
		private final int SIZE = 5;
		private Horse[] horse = new Horse[SIZE];
		
		private int rank;
		
		private int startX =30;
		private int startY=80;
		
		private int endX = 800-50-30;
		
		public controller(){
			setLayout(null);
			setBounds(0, 0, 800, 600);
			setBackground(Color.white);
			
			setTime();
			setButton();
			setRace();
			
		}

		private void setTime() {
			this.timer.setBounds(30, 50, 100, 30);
			this.timer.setText("READY");
			add(this.timer);
			
		}

		private void setRace() {
			this.rank =1;
			this.ms =0;
			
			int x = startX;
			int y = startY;
			
			for(int i=0; i<this.SIZE; i++) {
				this.horse[i] = new Horse(i+1, x, y, 50, 50);
				y+=90;
			}
			
		}

		private void setButton() {
			this.start.setText("START");
			this.start.setBounds(350, 30, 60, 50);
			this.start.addActionListener(this);
			add(this.start);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			super.actionPerformed(e);
			if(e.getSource() instanceof JButton) {
				JButton target =(JButton) e.getSource();
				
				if(target == this.start) {
					
					this.isRun = !this.isRun;
					this.start.setText(this.isRun ? "reset" : "start");
					
			}
				if(!this.isRun) {
					setRace();
				}
			
			}
		}


		

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			//말
			for(int i=0; i<this.SIZE; i++) {
				Horse h = this.horse[i];
				g.drawImage(h.getImage().getImage(), h.getX(), h.getY(),null);
				g.drawLine(this.startX, h.getY()+h.getH(), 800-30, h.getY()+h.getH());
			
			if(h.getState() == h.GOAL) {
				g.setFont(new Font("",Font.BOLD,15));
				g.drawString(h.getRank()+"등", this.endX-100, h.getY()+h.getH()/2);
				g.setFont(new Font("",Font.PLAIN,10));
				g.drawString(h.getRecord(), this.endX-50, h.getY()+h.getH()/2);
			}
				
			}
			if(isRun)
				try {
					Thread.sleep(50);
					updata();
				}catch(Exception e) {
					
				}
			
			repaint();
		}


		private void updata() {
			//5마리의 말들이 랜덤하게 점프
			//setX()
			
			
			boolean goal = false; //한번 업데이트 할때에, 한마리만 골인 할 수 있다. 
			
				for(int i=0; i<this.SIZE; i++) {
					Horse h = this.horse[i];
					int jump = rn.nextInt(25)*2+5;//얼만큼 뛸지.
					
					int xx = h.getX()+jump;
				
					if(h.getState() == h.RUN) {
						if(xx >= this.endX && !goal) {
							xx = endX;
							h.setState(h.GOAL);
							h.setRecord(String.format("%d.%03d", this.ms/1000,this.ms%1000));
							h.setRank(this.rank);
							this.rank++;
							goal = !goal;
						}
						else if(xx >= this.endX && goal) {
							i--; 
							continue;
						}
					
					h.setX(xx);
					
				}
				
			}
			
			
		}

		@Override
		public void run() {
				while(true) {
					if(isRun)
						this.ms++;
					this.timer.setText(String.format("%3d.%03d", this.ms/1000, this.ms%1000));
					try {
						Thread.sleep(1);
					}catch(Exception e) {
						
					}
				}
				
			}
			
		}



