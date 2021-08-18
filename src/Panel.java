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
	private int dec = 90;
	
	Image bigTree = Toolkit.getDefaultToolkit().getImage("res/BigTree.png");
	Image bg = Toolkit.getDefaultToolkit().getImage("res/BackgroundForest.png");
	Image kirby = Toolkit.getDefaultToolkit().getImage("res/2.png");
	Image heart = Toolkit.getDefaultToolkit().getImage("res/Heart.png");
	Image statusBar = Toolkit.getDefaultToolkit().getImage("res/StatusBar - Copie.png");
	Image Char0 = Toolkit.getDefaultToolkit().getImage("res/Char0.png");
	Image Char1 = Toolkit.getDefaultToolkit().getImage("res/Char1.png");
	Image Char2 = Toolkit.getDefaultToolkit().getImage("res/Char2.png");
	Image Char3 = Toolkit.getDefaultToolkit().getImage("res/Char3.png");
	Image Char4 = Toolkit.getDefaultToolkit().getImage("res/Char4.png");
	Image Char5 = Toolkit.getDefaultToolkit().getImage("res/Char5.png");
	Image Char6 = Toolkit.getDefaultToolkit().getImage("res/Char6.png");
	Image Char7 = Toolkit.getDefaultToolkit().getImage("res/Char7.png");
	Image Char8 = Toolkit.getDefaultToolkit().getImage("res/Char8.png");
	Image Char9 = Toolkit.getDefaultToolkit().getImage("res/Char9.png");
	

	private Image charNumber[]={Char0,Char1,Char2,Char3,Char4,Char5,Char6,Char7,Char8,Char9};
	
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
		
		g.drawImage(statusBar,0,0,null);
		
		for(int i =0; i<15;i++){
			for(int j=0;j<15;j++) {
				g.drawImage(bg,i*40,j*40+dec,null);				
			}
		}
		for(Decor d : data4) {
			if(d.getImage()==bigTree && (d.getXPos()==0 || d.getYPos()==0 || d.getXPos()==40*15)) {
				g.drawImage(d.getImage(), d.getXPos()-40, d.getYPos()-40+dec,null);				
			}
			else {
			g.drawImage(d.getImage(), d.getXPos(), d.getYPos()+dec,null);
		}
		}
		for(Bomb b : data3) {
			g.drawImage(b.getImage(), b.getXPos(), b.getYPos()+dec,null);
		}
		for(Link l : data) {
			g.drawImage(l.getIAD().getImage(l), l.getXPos(), l.getYPos()+dec,null);
			for(int i=0; i<l.getLifePoint();i++) {
				g.drawImage(heart,180+i*15,45,null);				
			}
			g.drawImage(charNumber[l.getNumberBomb()-data3.size()],485,42,null);
			//g.drawImage(charNumber[l.getNumberArrow()-data2.size()],0,0,null);
		}
		for(Arrow a : data2) {
			g.drawImage(a.getIAD().getImage(a), a.getXPos(), a.getYPos()+dec,null);
		}	
		for(Monster m : data6) {
			g.drawImage(m.getIAD().getImage(m), m.getXPos(), m.getYPos()+dec,null);
		}
		for(BombDeflagration d : data5) {
			for(int j = 0; j< d.getUp().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(2).get(1), d.getXPos(), d.getUp().get(j)+dec,null);
				}
				else{
					g.drawImage(d.getIAD().getImage(2).get(0), d.getXPos(), d.getUp().get(j)+dec,null);
				}
			}
			for(int j = 0; j< d.getDown().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(3).get(1), d.getXPos(), d.getDown().get(j)+dec,null);
				}
				else{
					g.drawImage(d.getIAD().getImage(3).get(0), d.getXPos(), d.getDown().get(j)+dec,null);
				}
			}
			for(int j = 0; j< d.getLeft().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(0).get(1), d.getLeft().get(j), d.getYPos()+dec,null);
				}
				else{
					g.drawImage(d.getIAD().getImage(0).get(0), d.getLeft().get(j), d.getYPos()+dec,null);
				}
			}
			for(int j = 0; j< d.getRight().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(1).get(1), d.getRight().get(j), d.getYPos()+dec,null);
				}
				else{
					g.drawImage(d.getIAD().getImage(1).get(0), d.getRight().get(j), d.getYPos()+dec,null);
				}
			}
		}
		for(FireBall1 a : data7) {
			g.drawImage(kirby, a.getXPos(), a.getYPos()+dec,null);
		}
		}
	}
