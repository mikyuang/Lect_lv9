package Horse;

import javax.swing.JFrame;

public class Race extends JFrame {
	
	private controller hp = new controller();
	
	public Race() {
		
		super("HorseRace");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		add(this.hp);
		
		setVisible(true);
		revalidate();
		
		hp.run();
	}
	
}
	


