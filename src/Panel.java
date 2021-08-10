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
	public List<BombDeflagration> data5;
	public List<Monster> data6;
	public List<FireBall1> data7;
	
	Image bigTree = Toolkit.getDefaultToolkit().getImage("res/BigTree.png");
	Image bg = Toolkit.getDefaultToolkit().getImage("res/BackgroundForest.png");
	Image kirby = Toolkit.getDefaultToolkit().getImage("res/2.png");
	
	public Panel(List<Link> l, List<Arrow> a, List<Bomb> b, List<Decor> d, List<BombDeflagration> bombDeflagration, List<Monster> monster, List<FireBall1> f) {
		data = l;
		data2 = a;
		data3 = b;
		data4 = d;
		data5 = bombDeflagration;
		data6 = monster;
		data7 = f;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i =0; i<15;i++){
			for(int j=0;j<15;j++) {
				g.drawImage(bg,i*40,j*40,null);				
			}
		}
		for(Decor d : data4) {
			if(d.getImage()==bigTree && (d.getXPos()==0 || d.getYPos()==0 || d.getXPos()==40*15)) {
				g.drawImage(d.getImage(), d.getXPos()-40, d.getYPos()-40,null);				
			}
			else {
			g.drawImage(d.getImage(), d.getXPos(), d.getYPos(),null);
		}
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
		for(Monster m : data6) {
			g.drawImage(m.getIAD().getImage(m), m.getXPos(), m.getYPos(),null);
		}
		for(BombDeflagration d : data5) {
			for(int j = 0; j< d.getUp().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(2).get(1), d.getXPos(), d.getUp().get(j),null);
				}
				else{
					g.drawImage(d.getIAD().getImage(2).get(0), d.getXPos(), d.getUp().get(j),null);
				}
			}
			for(int j = 0; j< d.getDown().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(3).get(1), d.getXPos(), d.getDown().get(j),null);
				}
				else{
					g.drawImage(d.getIAD().getImage(3).get(0), d.getXPos(), d.getDown().get(j),null);
				}
			}
			for(int j = 0; j< d.getLeft().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(0).get(1), d.getLeft().get(j), d.getYPos(),null);
				}
				else{
					g.drawImage(d.getIAD().getImage(0).get(0), d.getLeft().get(j), d.getYPos(),null);
				}
			}
			for(int j = 0; j< d.getRight().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(1).get(1), d.getRight().get(j), d.getYPos(),null);
				}
				else{
					g.drawImage(d.getIAD().getImage(1).get(0), d.getRight().get(j), d.getYPos(),null);
				}
			}
		}
		for(FireBall1 a : data7) {
			g.drawImage(kirby, a.getXPos(), a.getYPos(),null);
		}
		}
	}
