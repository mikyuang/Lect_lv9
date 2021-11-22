package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import models.Item;


public class CoffeeFrame extends JFrame implements ActionListener{
		
	
	private Item[] cfe = new Item[16];
	
	JButton cobut[] = new JButton[16];
	
		public CoffeeFrame(){
			 
			
			setLayout(null);
			setBounds(0, 0, 500, 800);

			setmebnt();
			
			setVisible(true);
			revalidate();
			
		}

		private void setmebnt() {
			
			for(int i=0; i<this.cobut.length; i++) {
				this.cobut[i] = new JButton();
				this.cobut[i].setBounds(10, 10, 70, 70);
				this.cobut[i].setBackground(Color.white);
				add(this.cobut[i]);
			}
			
			
			
		}
		
		@Override
		public void paintComponents(Graphics g) {
			super.paintComponents(g);
			for(int i=0; i<this.cfe.length; i++) {
				Item c = this.cfe[i];
				
				g.drawImage(getIconImage(c.getImage()), i, i, rootPane)
			}
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			
		}
		
		
		
		
	}
	

