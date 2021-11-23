package controller;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;

import models.Item;
import models.Util;

public class TeaPanel extends Util{
	
	private final int SIZE =4;
	private JButton teabut[][] = new JButton[SIZE][SIZE];
	private int teaprice[][] = new int[SIZE][SIZE];
	private String teaName[][] = new String[SIZE][SIZE];
	
	private int cnt;
	
	int num=1;
	
	Vector<Vector<String>> choice = new Vector<>();
	
	JTable table = null;
	private Item Item; 
	
	public TeaPanel(){
		setLayout(null);
		setBounds(0, 0, 500, 800);
		
		
		settbnt();
		
	}

	private void settbnt() {
	
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
			
				
			}
		}
	}
	

}
