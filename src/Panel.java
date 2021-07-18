import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Panel extends JPanel{
	public List<Link> data;
	public List<Arrow> data2;
	public List<Bomb> data3;
	public List<Decor> data4;
	
	public Panel(List<Link> l, List<Arrow> a, List<Bomb> b, List<Decor> d) {
		data = l;
		data2 = a;
		data3 = b;
		data4 = d;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Decor d : data4) {
			g.drawImage(d.getImage(), d.getXPos(), d.getYPos(),null);
		}
		for(Bomb b : data3) {
			g.drawImage(b.getImage(), b.getXPos(), b.getYPos(),null);
		}
		for(Link l : data) {
			g.drawImage(l.getIAD().getImage(l), l.getXPos(), l.getYPos(),null);
		}
		for(Arrow a : data2) {
			g.drawImage(a.getIAD().getImage(a), a.getXPos(), a.getYPos(),null);
		}			
		
		}
	}


