import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Fenetre extends JFrame {
	
	private Panel panel;
	
	public Fenetre() {
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new Panel("res/1.png");
		getContentPane().add(panel);
		
		Timer timer = new Timer(30, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				wololo();
			}
		});
		timer.start();
	}
	
	private void wololo() {
		System.out.println(panel.x);
		panel.x += 2;
		repaint();
	}
}
