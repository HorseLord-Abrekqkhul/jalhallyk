
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JTextArea;


public class SoloActionListener implements ActionListener {


public SoloActionListener(){
	
}
@Override
public void actionPerformed(ActionEvent arg0) {
	Map map = new Map(16,16,"1","3","1");
	char[][] tableau = new char[16][16];
	tableau = map.loadRoom();
	ArrayList<Decor> decor = map.mapToListDecor(tableau);
	ArrayList<Monster> monstre = map.mapToListMonster(tableau);
	new Fenetre(decor,monstre,map);
	System.out.println("yolo");
}
}