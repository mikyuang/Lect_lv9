package basic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//GUI
//ㄴ awt(무겁다) && swing -(라이트) 자바 라이브러리(스윙)

//UI 앨리먼트를 담는 컨테이너(바구니)
//최상위 컨테이너 : Jrame //예가 없으면 gui앨리먼트들을 사용할 수 없음.
//일반 컨테이너 : JPanel
//컴포넌트 : JButton, JLabel, JTextField,...등등.

//윈도우 하나는 프레임이라고 한다.(ex) 화이트보드)
//제목표시줄 - 타이틀 
//Jpanel -(ex)포스트잇)
//컴포던트 = 앨리먼트 


//class ManualPanel extends JPanel{
//	public ManualPanel(int x, int y) {
//	}
//	
//}

class MyPanel extends JPanel{
	public MyPanel() {
		setBounds(0, 0, 250, 400);
		setBackground(Color.pink);
	}
	
}

class MyPanel2 extends JPanel{
	
	public MyPanel2() {
		setBounds(250, 0, 250, 400);
		setBackground(Color.ORANGE);
	}
}

class Contents extends JPanel implements ActionListener{
	
	//버튼 만들기
	//JButton 클래스는 imoprt 해서 객체 생성.
	
	
	private JButton bt = new JButton();
	private boolean click;
	
	public Contents() {
		setLayout(null);
		setBounds(0,0,500,400);
		
		//버튼 속성 설정.
		bt.setBounds(100, 100, 100, 100); //크기,위치 설정.
		bt.setText("PUSH!!");
		
		//이건 맥이라서 그레이를 보여주기위해서 쓴 코드.
		bt.setOpaque(true); //투명도 
		bt.setBorderPainted(false); //테투리 삭제.
		
		bt.setBackground(Color.pink); //버튼컬러.
		bt.addActionListener(this); //버튼에 리스너를 달아줌.
		
		//패널에 버튼을 달아줌.
		add(bt);
	}
	
	//ActionListener 인터페이스를 통한 메소드 오버라이딩.
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("하이!");
		
	
		if(e.getSource()== this.bt) {
			this.bt.setBackground(Color.ORANGE);
			this.click=this.click ? false : true; //true면  flase로, flase면 true로 
			if(this.click)
				this.bt.setBackground(Color.WHITE);
			else
				this.bt.setBackground(Color.pink);
		}
		
		
		
	}
	
	
}

//JFrame 만들기 
class MyFrame extends JFrame{//마이프레임이 제이프레임의 역활을 할 수 있게됨.
	public MyFrame() {
		//JFrame설정 
		
		//0
		//기본 레이아웃 구성의 성절 > 순서대로 나열식.수동으로 붙일 수 있게 해준다.
		setLayout(null);//디폴트값으로하면 1234로 임의로 꽉꽉채워넣어버림.
		
		//1
		//타이틀설정
		//super("title");
		//setTitle("title");
		setTitle("MyFrame");
		
		
		//2
		//크기
		//setBounds(x,y,width,height)
		setBounds(300,300,500,400);
		
		//3
		//종료조건
		setDefaultCloseOperation(EXIT_ON_CLOSE);//쓰레드 과부화걸리기때문에 이 부분을 빼 먹지 안토록 한다.
		
		//add()메소드를 통해 컨테이너 및 컴포넌트를 추가할 수 잇다.
//		add(new MyPanel());
//		add(new MyPanel2());
//		add(new ManualPanel(0,0,250,400,Color.DARK_GRAY));
//		add(new ManualPanel(250,0,250,400,Color.pink));
		add(new Contents());
		
		
		
		
		//4
		//보이기
		setVisible(true);
		
		//5
		//갱신 색이 바뀌기도는부
		revalidate();
		

	}
	
}

public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		MyFrame frame = new MyFrame();
	}

}
