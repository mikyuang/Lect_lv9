package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Mainpanel extends Util{
 
	
	private JButton log = new JButton();
	private JButton join = new JButton();
	
	Vector<Vector<String>> users = new Vector<>();
	
	public Mainpanel(){
		
		setLayout(null);
		setBounds(0, 0, 500, 500);
		setBackground(Color.white);
		setButton();
		addMouseListener(this);
		
	}


	private void setButton() {
		
		this.log.setText("로그인");
		this.log.setBounds(100, 200, 100, 30);
		this.log.addActionListener(this);
		add(this.log);
		
		this.join.setText("회원가입");
		this.join.setBounds(300, 200, 100, 30);
		this.join.addActionListener(this);
		add(this.join);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == this.log) {
			
			Mainframe.logframe = new loginframe();
		}
		if(e.getSource() == this.join) {
			Mainframe.joframe = new joinframe();
		}
		
	}
}
