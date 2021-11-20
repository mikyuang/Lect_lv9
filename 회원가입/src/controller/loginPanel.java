package controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;





public class loginPanel extends Util {

	private JTextField jf = new JTextField();
	private JTextField jf1 = new JTextField();
	
	private JLabel id = new JLabel();
	private JLabel pw = new JLabel();
	private JButton login = new JButton();
	
	
	public loginPanel() {
		
		setLayout(null);
		setBounds(0, 0, 400, 400);
		setBackground(Color.orange);
		setlogid();
		setlogpw();
		setbnt();
		
	}


	private void setlogpw() {
		pw.setText("PW ");
		pw.setBounds(100, 130, 30, 50);
		jf1.setBounds(130, 145, 50, 20);
		
		jf1.addKeyListener(this);
		jf1.setFocusable(true);
		add(pw);
		add(jf1);
	}


	private void setlogid() {
		
		id.setText("ID ");
		id.setBounds(100, 100, 20, 30);
		jf.setBounds(130, 105, 50, 20);
		
		jf.addKeyListener(this);
		jf.setFocusable(true);
		
		add(id);
		add(jf);
		
	}
	


	private void setbnt() {
		
		this.login.setText("LOGIN");
		this.login.setBounds(200, 90, 80, 80);
		add(this.login);
		
	}



	

}
