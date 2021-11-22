package controller;

import javax.swing.JFrame;

class StarFrame extends JFrame{
	
	public StarFrame(){
		
		super("별다방");
		setLayout(null);
		setBounds(100, 100, 500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new StarPanel());
		
		setVisible(true);
		revalidate();
		
	}

}
