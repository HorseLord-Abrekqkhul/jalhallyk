import javax.swing.*;

public class Menu {
	private JPanel panel;
	
public Menu(){
	
	this.initializeControls();
}

private void initializeControls(){
	Fenetre fenetre = new Fenetre(null,null,null);

	panel = new JPanel();
	panel.setSize(500,500);
	fenetre.setContentPane(panel);
	Button button = new Button ();
	button.addActionListener(new SoloActionListener());
	panel.add(button);
	fenetre.pack();
	fenetre.setVisible(true);
}
}