package controller;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class joinpanel extends Util{
	
	//id -중복검사
	//pw
	//name 
	
	private JLabel idLable = new JLabel("ID :");
	private JLabel pwLable = new JLabel("PW :");
	private JLabel nameLable = new JLabel("NAME :");
	
	private JTextField idField = new JTextField();
	private JTextField pwField = new JTextField();
	private JTextField nameField = new JTextField(); 
	
	public joinpanel(){
		
	setLayout(null);
	setBounds(0, 0, 400, 400);
	setBackground(new Color(251, 243, 228));
	
	setTexteField();
	setVisible(true);
	revalidate();
		
	}

	private void setTexteField() {
		idLable.setBounds(30, 50, 60, 50);
		add(idLable);
		pwLable.setBounds(30,110,60, 50);
		add(pwLable);
		nameLable.setBounds(30, 170, 60, 50);
		add(nameLable);
		
		
		idField.setBounds(80, 50, 150, 50);
		add(idField);
		pwField.setBounds(80, 110, 150, 50);
		add(pwField);
		nameField.setBounds(80, 170, 150, 50);
		add(nameField);
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);

		Object target = e.getSource();
		
		
		if(e.getKeyCode() == e.VK_ENTER
				|| target == this.pwField || target == this.nameField) {
			
			String id = this.idField.getText();
			String pw = this.pwField.getText();
			String name = this.nameField.getText();
			
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
		 
		// Mainpanel.users.add(user);
		 
		 System.out.println("가입완료");
		// System.out.println("user.size() : "+this.users.size());
		 
		// this.joinpanel.dispose();//프레임에 대한 창 닫기 //프레임만!! 사용가능.
		 
		}
		else {
			//단순 팝업창을 띄울때에만 사용(권장하진 않음.경고창 정도로만 쓰임.)
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
		}
	}
	private boolean checkUserid(String id) {
	//	for(int i=0; i<this.users.size(); i++) {
	//		if(this.users.get(i).get(0).equals(id))
	//			return true;
	//	}
		return false;
	}
	
	

}
