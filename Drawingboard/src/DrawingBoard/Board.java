package DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

class NemoPanal extends MyUtil {
	
	
	private ArrayList<Nemo> nemo = new ArrayList<>();
	
	private Nemo ne = null; //선생님 풀이 사용.
	
	private boolean dir;
	
	
	private int dirX;
	private int dirY;
	
	private int endX;
	private int endY;
	
	private int nemow;
	private int nemoh;
	
	private int dx;
	private int dy;
	
	private boolean shift;
	
	public NemoPanal(){
		setLayout(null);
		setBounds(0, 0, 800, 800);
		setBackground(Color.white);
		
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setFocusable(true);
		addKeyListener(this);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(this.ne != null) {
			g.setColor(this.ne.getC());
			g.drawRect(this.ne.getX(), this.ne.getY(), this.ne.getW(), this.ne.getH());
			
		}
		for(int i=0; i<this.nemo.size(); i++) {
			g.setColor(this.nemo.get(i).getC());
			g.drawRect(this.nemo.get(i).getX(), this.nemo.get(i).getY(), this.nemo.get(i).getW(), this.nemo.get(i).getH());
		}
			
		
		requestFocusInWindow();
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.shift=true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==e.VK_SHIFT) {
			this.shift = false;
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		//절대값 구할 수 있는 abs
		int w = Math.abs(x-dirX);
		int h = Math.abs(y-dirY);
		
		
		//이제 그림을 그리면 된다.!
		//여기서 문제 -좌표는 안 그려질 수 있음.
		//해결책 -> 스타트 좌표를 바꿔줘야한다.
		//(start x,start y -> x-w , y-h)
		
		if(shift)
			w=h;
		
		int neX = dirX;
		int neY = dirY;
		
		if(x < dirX)
			neX = dirX - w;
		if(y < dirY)
			neY = dirY - h;
		
		this.ne = new Nemo(neX, neY, w, h, Color.blue);
		
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		this.dirX = e.getX();
		this.dirY = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.ne.setC(Color.black);
	}
}


class NemoDrawing extends JFrame{
	
	public NemoDrawing() { 
	
		super("DRAWING PAN");
		setLayout(null);
		setBounds(800, 800, 800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		add(new NemoPanal());
	
		revalidate();
	
	}
	
}


public class Board {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NemoDrawing  dw = new NemoDrawing();
	}

}
