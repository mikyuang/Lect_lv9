package basic;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MonP extends JPanel{
	
	
	private ImageIcon icon;
	public MonP (ImageIcon icon) {
		setLayout(null);
		setBounds(0, 0, 700, 500);
		this.icon = icon;
		
	}
	@Override
	protected void paintChildren(Graphics g) {
		super.paintChildren(g);
		
		//drawImage(Image,x,y,null)
		g.drawImage(icon.getImage(), 0, 0, null);
		repaint();
	}
	
}



class Mon extends JFrame{
	
	JLabel image = null;
	Image im = new ImageIcon("images/서강준배경 복사본.jpeg").getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH);
	ImageIcon icon = new ImageIcon(im);
	public Mon(){
	super("image");
	setLayout(null);
	setBounds(100, 100, 700, 500);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	//setImageLabal();
	add(new MonP(icon));
	
	setVisible(true);
		revalidate();
	}

//	private void setImageLabal() {
//		
//		this.image = new JLabel(icon);
//		this.image.setBounds(0, 0, 700, 500);
//		add(this.image);
//	}
//	
}

public class Ex1115 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Mon();
	}

}
