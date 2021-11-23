package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import models.Item;
import models.Util;


public class CoffeePanel extends Util{
		
	
	private final int SIZE =4;
	private JButton cobut[][] = new JButton[SIZE][SIZE];
	private int cprice[][] = new int[SIZE][SIZE];
	private String cName[][] = new String[SIZE][SIZE];
	
	private int cnt;
	
	int num=1;
	
	Vector<Vector<String>> choice = new Vector<>();
	
	JTable table = null;
	private Item Item; 
	
	
		public CoffeePanel(){
			setLayout(null);
			setBounds(0, 0, 500, 800);

			setmebnt();
			add(table);
			
		}

		
		private void setmebnt() {
			int x=50;
			int y=50;
			int w=100;
			int h=100;
			
			
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					this.Item = new Item(this.Item.Coffee, num, 50,100,100);
					this.cobut[i][j] = new JButton(this.Item.getFileName());
					this.cobut[i][j].setBounds(x, y, 100, 100);
					this.cobut[i][j].setBackground(Color.white);
					this.cobut[i][j].addActionListener(this);
					this.cName[i][j] = this.Item.getName();
					this.cprice[i][j] = this.Item.getPrice();
					this.cnt=0;
					add(this.cobut[i][j]);
					num++;
					x+=100;
					
				}
				x=50;
				y+=50;
			}

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == this.cobut) {
				JButton target =(JButton)e.getSource();
				
				for(int i=0; i<SIZE; i++) {
					for(int j=0; j<SIZE; j++) {
						
						if(target == this.cobut[i][j]) {
							//meunchoice(this.cName[i][j], this.cprice[i][j], this.cnt);
							
							this.cnt++;
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
		}

	}
	

