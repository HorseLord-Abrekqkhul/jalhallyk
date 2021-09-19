import javax.swing.*;

public class Menu {
	private JFrame frame;
	private JPanel panel;
	
public Menu(){
	
	this.initializeControls();
}

private void initializeControls(){
	frame = new JFrame("TLOB");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel = new JPanel();
	frame.getContentPane().add(panel);
	Button button = new Button ();
	button.addActionListener(new SoloActionListener());
	panel.add(button);
	frame.pack();
	frame.setVisible(true);
}
}