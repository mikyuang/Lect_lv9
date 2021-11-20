package controller;

import javax.swing.JFrame;

class loginframe extends JFrame{

	public loginframe(){
	
	super("LOGIN");
	setLayout(null);
	setBounds(100, 100, 400, 400);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	add(new loginPanel());
	
	revalidate();
	
	}
}
