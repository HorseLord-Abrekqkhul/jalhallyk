import java.awt.Graphics;

import javax.swing.JPanel;


public class Panel extends JPanel {
	public int x;
	
	public Panel() {
		x = 0;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(x, 300, 20, 40);
	}
}
