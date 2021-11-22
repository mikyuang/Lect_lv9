package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class joinf extends JFrame{
	
	private JLabel idLable = new JLabel("ID :");
	private JLabel pwLable = new JLabel("PW :");
	private JLabel nameLable = new JLabel("NAME :");
	
	private JTextField idField = new JTextField();
	private JTextField pwField = new JTextField();
	private JTextField nameField = new JTextField(); 
	
	private JButton JOIN = new JButton();
	
	public joinf() {
		
		super("회원가입");
		setLayout(null);
		setBounds(100, 100, 400, 200);
		setBackground(new Color(251, 243, 228));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setTexteField();
		setjbnt();
		setVisible(true);
		revalidate();
		
	}

private void setjbnt() {
	this.JOIN.setText("JOIN");
	this.JOIN.setBounds(200, 20, 70, 70);
	this.JOIN.setBackground(Color.white);
	add(this.JOIN);
	}

private void setTexteField() {
	idLable.setBounds(10, 8, 60, 50);
	add(idLable);
	pwLable.setBounds(10, 30, 60, 50);
	add(pwLable);
	nameLable.setBounds(10, 50, 60, 50);
	add(nameLable);
	
	
	getIdField().setBounds(80, 20, 100, 25);
	add(getIdField());
	getPwField().setBounds(80, 45, 100, 25);
	add(getPwField());
	getNameField().setBounds(80, 65, 100, 25);
	add(getNameField());		
	}

public JTextField getIdField() {
	return idField;
}

public void setIdField(JTextField idField) {
	this.idField = idField;
}

public JTextField getPwField() {
	return pwField;
}

public void setPwField(JTextField pwField) {
	this.pwField = pwField;
}

public JTextField getNameField() {
	return nameField;
}

public void setNameField(JTextField nameField) {
	this.nameField = nameField;
}
}

public class Mainpanel extends Util{
 
	
	private JButton log = new JButton();
	private JButton join = new JButton();
	
	joinf jof = null;
	
	Vector<Vector<String>> users = new Vector<>();
	
	public Mainpanel(){
		
		setLayout(null);
		setBounds(0, 0, 500, 500);
		setBackground(Color.white);
		setButton();
		
		
	}


	private void setButton() {
		
		this.log.setText("로그인");
		this.log.setBounds(100, 200, 100, 30);
		this.log.addActionListener(this);
		add(this.log);
		
		this.join.setText("회원가입");
		this.join.setBounds(300, 200, 100, 30);
		this.join.addActionListener(this);
		add(this.join);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == this.log) {
			
			Mainframe.logframe = new loginframe();
		}
		
		if(e.getSource() == this.join) {
			this.jof = new joinf();
			
			this.jof.getIdField().setFocusable(true);
			this.jof.getIdField().addKeyListener(this);
			
			this.jof.getPwField().setFocusable(true);
			this.jof.getPwField().addKeyListener(this);
			
			this.jof.getNameField().setFocusable(true);
			this.jof.getNameField().addKeyListener(this);
			
		}
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
			Object target = e.getSource();
		
		
		if(e.getKeyCode() == e.VK_ENTER && target == this.jof.getIdField() 
				|| target == this.jof.getPwField() || target == this.jof.getNameField()) {
			
			String id = this.jof.getIdField().getText();
			String pw = this.jof.getPwField().getText();
			String name = this.jof.getNameField().getText();
			
			//빈칸이 있으면 안됨 
			if(!id.equals("") && !pw.equals("") && !name.equals("")) {
				joinUser(id,pw,name);
			}
		}
		
		
	}
	
	private void joinUser(String id, String pw, String name) {
		//중복id를 걸러내기위한 불리언값.
		
		boolean check = checkUserid(id);
		
		if(!check) {
		//user
		 Vector<String> user = new Vector<>();
		 user.add(id);
		 user.add(pw);
		 user.add(name);
		 
		 this.users.add(user);
		 
		 System.out.println("가입완료");
		 System.out.println("user.size() : "+this.users.size());
		 
		// this.jof.dispose();//프레임에 대한 창 닫기 //프레임만!! 사용가능.
		 
		}
		else {
			//단순 팝업창을 띄울때에만 사용(권장하진 않음.경고창 정도로만 쓰임.)
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
		}
	}
	private boolean checkUserid(String id) {
		for(int i=0; i<this.users.size(); i++) {
			if(this.users.get(i).get(0).equals(id))
				return true;
		}
		return false;
	}
	
}
