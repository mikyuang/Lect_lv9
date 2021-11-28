package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;


public class StarPanel extends Util implements AncestorListener{

	//public static Vector<Vector<String>> chiceMeun = new Vector<>();
	public static Vector<Vector<String>> choiceMeun = new Vector<>();
	
	private JButton cobnt = new JButton();
	private JButton tebnt = new JButton();
	
	//포장,매장
	ImageIcon himage = new ImageIcon( new ImageIcon("image/inDrik.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	ImageIcon outmage = new ImageIcon( new ImageIcon("image/takeout.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	private JButton outbtn = new JButton(outmage);
	private JButton herebtn = new JButton(himage);
		
	
	private JButton paybnt,cancelbnt,Oderbnt,backbnt,cashbtn,cardbtn;
	
	
	TeaPanel tp = new TeaPanel();
	CoffeePanel cp = new CoffeePanel();
	PayPanel pp = new PayPanel();
	TablePanel tbp = new TablePanel();
	
	public static int total;
	public static int totalCnt;
	public static int sel;
	JButton selectFinish = new JButton();
	public static JLabel totalText = new JLabel();
	
	
	private JScrollPane scroll;
	private static JTable table;
	
	
	//rgb(11, 70, 25)찐초   //rgb(232, 232, 204)베이지  rgb(255, 204, 29)//찐노
	public StarPanel(){
		
		setLayout(null);
		setBounds(0, 0, 500, 800);
		setBackground(new Color(17, 101, 48));
		
		setbtn();
		setpay();
		setrebtn();
		
	}
	
	private void setrebtn() {
		
		
	}

	private void setpay() {
		this.cardbtn.setBounds(100, 400, 200, 200);
		this.cashbtn.setBounds(250, 400, 200, 200);
		this.cardbtn.setText("카드결제");
		this.cashbtn.setText("현금결재");
		this.cardbtn.addActionListener(this);
		this.cashbtn.addActionListener(this);
		add(this.cardbtn);
		add(this.cashbtn);
		
		
	}

	private void setbtn() {
		this.outbtn = new JButton();
		this.herebtn = new JButton();
		
		this.outbtn.setBounds(150, 400, 200, 200);
		this.herebtn.setBounds(250, 400, 200, 200);
		
		this.outbtn.addActionListener(this);
		this.herebtn.addActionListener(this);
		
		add(this.herebtn);
		add(this.outbtn);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == this.herebtn || e.getSource() == this.outbtn) {
		CoffeePanel cp = new CoffeePanel();
	}
	add(tbp,0);
	Total();
	add(totalText);
	
	if(e.getSource()== this.cobnt) {
		CoffeePanel cp = new CoffeePanel();
		this.add(cp);
		this.repaint();
		this.revalidate();
	}
	if(e.getSource()==this.tebnt) {
		TeaPanel tp = new TeaPanel();
		this.add(tp);
		this.repaint();
		this.revalidate();
	}
	Total();
	add(totalText);
	add(tbp,0);
	add(this.cobnt);
	add(this.tebnt);
	add(this.Oderbnt);
	
	
	if(e.getSource()== this.Oderbnt || e.getSource()== this.cardbtn || e.getSource()==this.cashbtn) {
		this.removeAll();
		
	}
	if(e.getSource()==this.Oderbnt) {
		PayPanel pp = new PayPanel();
		setpay();
		
	}
}
	
	
	
	public static void calculate() {
		total=0;
		for(int i=0; i<choiceMeun.size(); i++ ) {
			int cnt = Integer.parseInt(choiceMeun.get(i).get(1));
			int price = Integer.parseInt(choiceMeun.get(i).get(2));
			total +=(cnt * price);
		}
		System.out.println(total);
		
	}
	
	public static void Total() {
		totalText.setBounds(500, 800, 300, 60);
		totalText.setText("합계 : " + total +"원");
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
