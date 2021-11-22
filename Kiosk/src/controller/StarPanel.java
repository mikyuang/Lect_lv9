package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import models.Util;



public class StarPanel extends Util{

	private JButton cobnt = new JButton();
	private JButton tebnt = new JButton();
	private JButton Oderbnt = new JButton("결재");
	private JButton cancelbnt = new JButton("취소");
	
	CoffeeFrame cf =null;
	
	//rgb(11, 70, 25)찐초   //rgb(232, 232, 204)베이지  rgb(255, 204, 29)//찐노
	public StarPanel(){
		
		setLayout(null);
		setBounds(0, 0, 500, 800);
		setBackground(new Color(17, 101, 48));
		
		setbtn();
		setTable();
		

		
	}
	private void setbtn() {
		this.tebnt.setBounds(280, 400, 100, 100);
		this.cobnt.setBounds(130, 400, 100, 100);
		
		this.tebnt.setFont(new Font("",Font.BOLD, 20));
		this.cobnt.setFont(new Font("",Font.BOLD, 20));
		
		this.tebnt.setText("TEA");
		this.cobnt.setText("COFFEE");
		
	
		
		
		this.tebnt.addActionListener(this);
		this.cobnt.addActionListener(this);
		
		add(cobnt);
		add(tebnt);
		
	}
	

	private void setTable() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == this.cobnt) {
			this.cf = new CoffeeFrame();
			
		}
		if(e.getSource() == this.tebnt) {
			//this.mf = new MeunFrame();
		}
		
	}
	
	
	
	
	
}
