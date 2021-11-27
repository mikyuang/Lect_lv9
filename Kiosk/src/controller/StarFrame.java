package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class StarFrame extends JFrame {
	
	public static Vector<Vector<String>> choiceMeun = new Vector<>();
	
	

	
	public StarFrame(){
		
		super("별다방");
		setLayout(null);
		setBounds(500, 500, 500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new StarPanel());
		
		setVisible(true);
		revalidate();
		
	}
}
