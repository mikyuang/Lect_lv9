package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class CoffeePanel extends Util{
		
	
	private final int SIZE =4;
	private JButton cobut[][] = new JButton[4][4];
	private int cprice[][] = new int[SIZE][SIZE];
	private String cName[][] = new String[SIZE][SIZE];
	
	
	
	ImageIcon[][] cobImag;
	
	String[][] coMenuImag= {{"coffee01.png","coffee02.png","coffee02.png","coffee04.png"},
			{"coffee05.png","coffee06.png","coffee07.png","coffee08.png"},
			{"coffee09.png","coffee10.png","coffee11.png","coffee12.png"},
			{"coffee13.png","coffee14.png","coffee15.png","coffee16.png"}};
	
	
	
	
	private int cnt[][] = new int[SIZE][SIZE];
	private Item item;
	
	int num=1;
	int x=50;
	int y=50;
	int w=100;
	int h=100;
	
	Vector<Vector<String>> choice = new Vector<>();
	
	TablePanel table = new TablePanel();

	
	
		public CoffeePanel(){
			setLayout(null);
			setBackground(new Color(17, 101, 48));
			setBounds(0, 0, 500, 800);

			setmebnt();
			add(table);
			
		}
		
		private void setmebnt() {
			int x=30;
			int y=30;
			int w=100;
			int h=120;
			
			cobImag = new ImageIcon[SIZE][SIZE];
			
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					this.item = new Item(item.Coffee,num,x,y,w,h);
				cobImag[i][j] = new ImageIcon("images/"+coMenuImag[i][j]);
				this.cobut[i][j] = new JButton();
				this.cobut[i][j].setBackground(new Color(17, 101, 48));
				this.cobut[i][j].setBounds(x, y, w, h);
				
				this.cName[i][j] = item.getName();
				this.cprice[i][j] = item.getPrice();
				
				this.cobut[i][j].setIcon(cobImag[i][j]);
				this.cobut[i][j].setFocusPainted(false);
				this.cobut[i][j].addActionListener(this);
				this.cnt[i][j] =0;
				
				add(cobut[i][j]);
				
				x+=110;
				}
				x=30;
				y+=130;
			}
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == this.cobut) {
				JButton target =(JButton)e.getSource();
				
				for(int i=0; i<SIZE; i++) {
					for(int j=0; j<SIZE; j++) {
						
						if(target == this.cobut[i][j]) {
							this.cnt[i][j]++;
							if(!table.chioces[i][j]) {
							meunchoice(this.cName[i][j], String.valueOf(this.cprice[i][j]),String.valueOf(this.cnt[i][j]));
							table.chioces[i][j] = true;
							}else {
								for(int n=0; n<StarFrame.choiceMeun.size(); n++) {
									if(this.cName[i][j] == StarFrame.choiceMeun.get(n).get(0)) {
										StarFrame.choiceMeun.get(n).set(2, String.valueOf(cnt[i][j]));
									}
								}
							}
						add(table,0);
						}
					}
					
				}
			
			}

		}
		
		private void meunchoice(String cName, String price, String cnt) {
			Vector<String> choiceList = new Vector<>();
			choiceList.add(cName);
			choiceList.add(price);
			choiceList.add(cnt);
			this.choice.add(choiceList);
			revalidate();
			repaint();
		}

	}
	

