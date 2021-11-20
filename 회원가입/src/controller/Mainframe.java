package controller;

import javax.swing.JFrame;

public class Mainframe extends JFrame{
	
	
	public static loginframe logframe;
	public static joinframe joframe;

	public Mainframe() {
		
		super("MAIN");
		setLayout(null);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Mainpanel());
		
		setVisible(true);
		revalidate();
		
	}
	
	

}
