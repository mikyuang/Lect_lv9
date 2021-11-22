package basic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

class Jonin extends JFrame{

	JLabel idLable = new JLabel("ID :"); //줄바꿈을 하려면 <br>을 넣으면 된다!
	JLabel pwLable = new JLabel("PW :");
	JLabel nameLable = new JLabel("NAME :");
	
	JTextField idField = new JTextField();
	JTextField pwField = new JTextField();
	JTextField nameField = new JTextField(); 
	
	public Jonin(){
		setLayout(null);
		setBounds(200, 200, 300, 400);
		
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
	
}



class SokobanP extends JPanel implements KeyListener, ActionListener {
	
	//줄바꿈이 안된다.
	JTextField jf = new JTextField();
	
	//줄바꿈가능
	JTextArea ja = new JTextArea();
	
	
	//로그인 & 회원가입
	//메인 프레임에 버튼 두개, 로그인 /회원가입
	//버튼 > 팝업창에서 텍스트 입력
	//회원가입 정보는 vector에 저장.
	
	Vector<Vector<String>> users = new Vector<>();//<테이블을 만들기 위해서 백터를 사용했다. 
	//User : vector<String>(데이터 저장배열)
	//add(id) > 중복 예외처리 
	//add(pw)
	//add(name)
	
	Vector<String> colName = null;
	
	//옵션 : 파일 처리까지.
	//팝업창에 입력된 내용은 창을 닫으면 그대로 날아가버리기 때문에 메인에 저장되게 해야한다. 
	
	
	JButton login = new JButton();
	JButton join = new JButton();
	
	Jonin joinf = null;///< Jonin joinf = new Jonin(); 으로 해놓으니 join눌렀을때 나와야하는 창이 먼저 나옴. 그래서 null로 바꾸니 버튼으로 작동!
	
	JTable table = null;
	
	public SokobanP(){
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
//		setTextField();
//		setTextArea();
		setTable();
		setBnt();
		
		init();
		
	}
	private void init() {
		Random rn = new Random();
		String[] Front = {"김","이","나","박","양"};
		String[] Back = {"예","랑","소","희","은"};
		String[] Back2 = {"호","수","경","가","곽"};
		
		for(int i=0; i<100; i++) {
			Vector<String>user = new Vector<>();
			String name = Front[rn.nextInt(Front.length)] + Back[rn.nextInt(Back.length)]+Back2[rn.nextInt(Back2.length)];
			user.add(name);
			user.add(i+"");
			user.add(i+"");
			this.users.add(user);
		}
		
	}
	private void setTable() {
		this.colName = new Vector();
		this.colName.add("id");
		this.colName.add("pw");
		this.colName.add("name");
		
		table = new JTable(users, colName); //vector를 이용하는 table을 사용한것.
		table.setBounds(50, 50, 300, 300);
		
		
		//꾸미기
		table.setGridColor(Color.pink);
		table.setBorder(new LineBorder(Color.orange));
		
		JScrollPane js = new JScrollPane(table);
		js.setBounds(50, 50, 300, 300);
		setAutoscrolls(true); //default 
		add(js);
		
		
	}
	private void setBnt() {
		this.join.setBounds(100, 400, 50, 50);
		this.join.setText("join");
		this.join.addActionListener(this);
		add(this.join);
		
		this.login.setText("login");
		this.login.setBounds(200, 400, 50, 50);
		this.login.addActionListener(this);
		add(this.login);
		
	}
//	private void setTextArea() {
//		ja.setBounds(200, 200, 200, 200);
//		
//		add(ja);
//	}
//	private void setTextField() {
//		
//		jf.setBounds(100, 100, 100, 30);
//		
//		jf.addKeyListener(this);
//		jf.setFocusable(true);
//		add(jf);
//		
//	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		Object target = e.getSource();
		
		
		if(e.getKeyCode() == e.VK_ENTER && target == this.joinf.idField 
				|| target == this.joinf.pwField || target == this.joinf.nameField) {
			
			String id = this.joinf.idField.getText();
			String pw = this.joinf.pwField.getText();
			String name = this.joinf.nameField.getText();
			
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
		 
		 table.revalidate();
		 table.repaint();
		 
		 System.out.println("0인덱스 유저 정보 :");
		System.out.println(this.users.get(0));
		System.out.println(this.users.get(1));
		System.out.println(this.users.get(2));
		 
		 this.joinf.dispose();//프레임에 대한 창 닫기 //프레임만!! 사용가능.
		 
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.join) {
			this.joinf = new Jonin();
			
//			this.joinf.setFocusable(true);
//			this.joinf.addKeyListener(this);
			
			this.joinf.idField.setFocusable(true);
			this.joinf.idField.addKeyListener(this);
			
			this.joinf.pwField.setFocusable(true);
			this.joinf.pwField.addKeyListener(this);
			
			this.joinf.nameField.setFocusable(true);
			this.joinf.nameField.addKeyListener(this);
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

class Sokobannn extends JFrame{
	
	public Sokobannn() {
		
		super("회원가입");
		setLayout(null);
		setBounds(100, 100, 500, 500);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//JFrame에는 pane
		
		// this.getContentPane() -> 유리창 교체 this.setContendtPane()

		//컴포넌트이 달려있는 패널을 갈아끼워준다는 > 화면전환이 된다. 
		
		//
		// this.getContentPane().add(new SokobanP()); > 밑에 애드에 생략이 되어있는것이다.
		add(new SokobanP());
		
		
		setVisible(true);
		revalidate();
		
	}

	
}

public class ex1119JText{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sokobannn sk = new Sokobannn();
	
		
		
	}

}
