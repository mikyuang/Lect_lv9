package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class TeaPanel extends Util{
	
	private final int SIZE =4;
	private JButton teabut[][] = new JButton[SIZE][SIZE];
	private int teaprice[][] = new int[SIZE][SIZE];
	
	private int cnt[][] = new int [SIZE][SIZE];
	
	ImageIcon[][] teaiamge;
	
	String[][] teMenuImag= {{"tea01.png","tea02.png","tea03.png","tea04.png"},
			{"tea05.png","tea06.png","tea07.png","tea08.png"},
			{"tea09.png","tea10.png","tea11.png","tea12.png"},
			{"tea13.png","tea14.png","tea15.png","tea16.png"}};
	
	//int num=1;
	
	Vector<Vector<String>> choice = new Vector<>();
	
	TablePanel table = new TablePanel();

	
	public TeaPanel(){
		setLayout(null);
		setBackground(new Color(17, 101, 48));
		setBounds(0, 0, 500, 800);
		
		settbnt();
		add(table);
		
	}

	private void settbnt() {
	
		int x = 30;
		int y= 30;
		int w=100;
		int h=120;
		
		teaiamge = new ImageIcon[SIZE][SIZE];
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
			teaiamge[i][j] = new ImageIcon("images/" + this.teMenuImag[i][j]);
			teabut[i][j] = new JButton();
			this.teabut[i][j].setIcon(teaiamge[i][j]);
			teabut[i][j].setBounds(x, y, w, h);
			
			//teabut[i][j].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			
			teabut[i][j].setFocusPainted(false);
			teabut[i][j].addActionListener(this);
			cnt[i][j]=0;
			add(teabut[i][j]);
				
			x+= 110;
			
			}
			x=30;
			y+=130;
		}

}
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == this.teabut) {
			JButton target =(JButton)e.getSource();
			
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
				if(target == teabut[i][j])
				cnt[i][j]++;
			
				meunchoice(this.getName(), String.valueOf(this.teaprice[i][j]),String.valueOf(this.cnt[i][j]));
			}
				
			add(table,0);
			}	
		}
		
	}
	
	private void meunchoice(String cName, String price, String cnt) {
		Vector<String> choiceList = new Vector<>();
		choiceList.add(cName);
		choiceList.add(price);
		choiceList.add(cnt);
		this.choice.add(choiceList);
		revalidate();
		repaint();
	}

	
}
	
