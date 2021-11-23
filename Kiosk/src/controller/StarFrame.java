package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class StarFrame extends JFrame implements ActionListener {
	//커피 & 차 버튼 
	private JButton cobnt = new JButton();
	private JButton tebnt = new JButton();
	//결재,취소버튼 
	private JButton Oderbnt = new JButton("결재");
	private JButton cancelbnt = new JButton("취소");
	//포장,매장
	ImageIcon himage = new ImageIcon( new ImageIcon("image/inDrik.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	ImageIcon outmage = new ImageIcon( new ImageIcon("image/takeout.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	
	private JButton outbtn = new JButton(outmage);
	private JButton herebtn = new JButton(himage);
	//현금,카드 
	private JButton cashbtn = new JButton();
	private JButton cardbtn = new JButton();
	
	//커피,차,결재 
	TeaPanel tp = new TeaPanel();
	CoffeePanel cp = new CoffeePanel();
	
	
	public StarFrame(){
		
		super("별다방");
		setLayout(null);
		setBounds(100, 100, 500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//add(new StarPanel());
		setBackground(new Color(17, 101, 48));
		setbtn();
		setVisible(true);
		revalidate();
		
	}

	private void setbtn() {
		// TODO Auto-generated method stub
		this.tebnt.setBounds(280, 400, 130, 100);
		this.cobnt.setBounds(130, 400, 130, 100);
		
		this.tebnt.setFont(new Font("",Font.BOLD, 20));
		this.cobnt.setFont(new Font("",Font.BOLD, 20));
		
		this.cobnt.setBorderPainted(false);
		this.tebnt.setBorderPainted(false);
		
		this.tebnt.setText("TEA");
		this.cobnt.setText("COFFEE");
		
		this.tebnt.addActionListener(this);
		this.cobnt.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == this.cobnt && this.getContentPane() == tp) {
			this.setContentPane(cp);
			
		}
		if(e.getSource() == this.tebnt && this.getContentPane()==cp) {
			this.setContentPane(tp);
		}
		add(this.cobnt);
		add(this.tebnt);
	}



	
}
