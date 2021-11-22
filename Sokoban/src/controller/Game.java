package controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Game extends JFrame{
	
	
	private GamePlay gameplay = new GamePlay();
	
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();

	public static final int W = dm.width;
	public static final int H = dm.height;
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;
	
	public Game(){
		
		super("SOKOBAN");
		setLayout(null);
		setBounds(W /2 -WIDTH/2 , H /2 - HEIGHT /2 , WIDTH, HEIGHT);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new GamePlay());
		
		setVisible(true);
		revalidate();
	}
	
	
	

}
