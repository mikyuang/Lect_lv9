package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;


public class StarPanel extends Util implements AncestorListener{

	//public static Vector<Vector<String>> chiceMeun = new Vector<>();
	
	private JButton cobnt = new JButton();
	private JButton tebnt = new JButton();
	
	//포장,매장
	ImageIcon himage = new ImageIcon( new ImageIcon("image/inDrik.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	ImageIcon outmage = new ImageIcon( new ImageIcon("image/takeout.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	private JButton outbtn = new JButton(outmage);
	private JButton herebtn = new JButton(himage);
		
	//결재,취소버튼 
	private JButton paybnt = new JButton("결재");
	private JButton cancelbnt = new JButton("취소");
		
	//현금,카드 
	private JButton cashbtn = new JButton();
	private JButton cardbtn = new JButton();
		
	//주문버튼
	private JButton Oderbnt = new JButton("주문하기");
	private JButton backbnt = new JButton("이전");
	
	TeaPanel tp = new TeaPanel();
	CoffeePanel cp = new CoffeePanel();
	CartItem cart = new CartItem();
	TablePanel tbp = new TablePanel();
	
	public static int total;
	
	
	//rgb(11, 70, 25)찐초   //rgb(232, 232, 204)베이지  rgb(255, 204, 29)//찐노
	public StarPanel(){
		
		setLayout(null);
		setBounds(0, 0, 500, 800);
		setBackground(new Color(17, 101, 48));
		
		setbackbnt();
		setCTbtn();
		
	}
	
	private void setbackbnt() {
		this.backbnt.setBounds(400, 700, 50, 50);
		this.backbnt.setFont(new Font("맑은고딕",Font.PLAIN,10));
		this.backbnt.setBorderPainted(false);
		this.backbnt.addAncestorListener(this);
	}

	private void setCTbtn() {
		
		this.tebnt.setBounds(280, 300, 130, 100);
		this.cobnt.setBounds(100, 300, 130, 100);
		
		this.tebnt.setFont(new Font("",Font.BOLD, 20));
		this.cobnt.setFont(new Font("",Font.BOLD, 20));
		
		this.tebnt.setText("TEA");
		this.cobnt.setText("COFFEE");
		
		this.tebnt.addActionListener(this);
		this.cobnt.addActionListener(this);
		
		add(cobnt);
		add(tebnt);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.cobnt ) {
			CoffeePanel cp = new CoffeePanel();
			this.removeAll();
			this.repaint();
			this.revalidate();
			this.add(cp);
			this.repaint();
			this.revalidate();
			
		}
		if(e.getSource() == this.tebnt) {
			TeaPanel tp = new TeaPanel();
			this.removeAll();
			this.repaint();
			this.revalidate();
			this.add(tp);
			this.repaint();
			this.revalidate();
			
		}
		if(e.getSource() == this.backbnt) {
			StarPanel sp = new StarPanel();
			this.removeAll();
			this.repaint();
			this.revalidate();
			this.add(sp);
			this.repaint();
			this.revalidate();
			
		}
		
	}

	@Override
	public void ancestorAdded(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ancestorRemoved(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ancestorMoved(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
