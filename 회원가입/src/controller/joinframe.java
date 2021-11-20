package controller;

import javax.swing.JFrame;

public class joinframe extends JFrame{
	
	public joinframe() {
		
		super("회원가입");
		setLayout(null);
		setBounds(100, 100, 400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new joinpanel());
		setVisible(true);
		revalidate();
		
	}

}
