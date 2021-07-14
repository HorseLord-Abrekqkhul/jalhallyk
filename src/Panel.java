import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Panel extends JPanel{
	public List<Link> data;
	public List<Arrow> data2;
	
	public Panel(List<Link> l, List<Arrow> a) {
		data = l;
		data2 = a;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Link l : data) {
			g.drawImage(l.getIAD().getImage(l), l.getXPos(), l.getYPos(),null);
		}
		for(Arrow a : data2) {
			g.drawImage(a.getIAD().getImage(a), a.getXPos(), a.getYPos(),null);
		}
		
	}

}
