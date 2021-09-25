import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
	public List<Bonus> data8;
	private int decY = 120;
	private int decX = 100;
	
	Image bigTree = Toolkit.getDefaultToolkit().getImage("res/BigTree.png");
	Image bg = Toolkit.getDefaultToolkit().getImage("res/BackgroundForest.png");
	Image kirby = Toolkit.getDefaultToolkit().getImage("res/2.png");
	Image heart = Toolkit.getDefaultToolkit().getImage("res/Heart.png");
	Image statusBar = Toolkit.getDefaultToolkit().getImage("res/StatusBar.png");
	Image imageLink = Toolkit.getDefaultToolkit().getImage("res/LinkRunDown1.png");
	Image fireStaff = Toolkit.getDefaultToolkit().getImage("res/FireStaff.png");
	Image iceStaff = Toolkit.getDefaultToolkit().getImage("res/IceStaff.png");
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
	
	public Panel(List<Link> l, List<Arrow> a, List<Bomb> b, List<Decor> d, List<BombDeflagration> bombDeflagration, 
			List<Monster> monster, List<FireBall1> f, List<Bonus> bonus) {
		data = l;
		data2 = a;
		data3 = b;
		data4 = d;
		data5 = bombDeflagration;
		data6 = monster;
		data7 = f;
		data8 = bonus;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(statusBar,0,0,null);
		
		for(int i =0; i<15;i++){
			for(int j=0;j<15;j++) {
				g.drawImage(bg,i*40+decX,j*40+decY,null);				
			}
		}
		for(Decor d : data4) {
			if(d.getImage()==bigTree && (d.getXPos()==0 || d.getYPos()==0 || d.getXPos()==40*15)) {
				g.drawImage(d.getImage(), d.getXPos()-40+decX, d.getYPos()-40+decY,null);				
			}
			else {
			g.drawImage(d.getImage(), d.getXPos()+decX, d.getYPos()+decY,null);
			}
		}
		for(Bomb b : data3) {
			g.drawImage(b.getImage(), b.getXPos()+decX, b.getYPos()+decY,null);
		}
		for(Bonus b : data8){
			g.drawImage(b.getImage(), b.getXPos()+decX, b.getYPos()+decY,null);
		}
		for(Link l : data) {
			g.drawImage(l.getIAD().getImage(l), l.getXPos()+decX, l.getYPos()+decY,null);
			
			g.drawImage(imageLink,85,53,null);
			
			int centaineRubis=(l.getNumberCoin()-l.getNumberCoin()%100)/100;
			int dizaineRubis=((l.getNumberCoin()-centaineRubis*100)-(l.getNumberCoin()-centaineRubis*100)%10)/10;
			
			for(int i=0; i<l.getLifePoint();i++) {
				g.drawImage(heart,153+i*20,50,null);				
			}
			
			g.drawImage(charNumber[l.getNumberBomb()],502,62,null);			
			g.drawImage(charNumber[l.getRangeBomb()],412,62,null);
			
			if(centaineRubis!=0) {
				g.drawImage(charNumber[centaineRubis],590,62,null);
			}
			
			if(dizaineRubis!=0) {
				g.drawImage(charNumber[dizaineRubis],595,62,null);
			}
			g.drawImage(charNumber[l.getNumberCoin()-centaineRubis*100-dizaineRubis*10],600,62,null);
			//g.drawImage(charNumber[l.getNumberArrow()],312,620,null);
			
			if(l.getStaff()==0) {
			g.drawImage(fireStaff,650,53,null);
			}
			
			if(l.getStaff()==1) {
				g.drawImage(iceStaff,650,53,null);
				}
			
		}
		for(Arrow a : data2) {
			g.drawImage(a.getIAD().getImage(a), a.getXPos()+decX, a.getYPos()+decY,null);
		}	
		for(Monster m : data6) {
			g.drawImage(m.getIAD().getImage(m), m.getXPos()+decX, m.getYPos()+decY,null);
		}
		
		for(BombDeflagration d : data5) {
			for(int j = 0; j< d.getUp().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(2).get(1), d.getXPos()+decX, d.getUp().get(j)+decY,null);
				}
				else{
					g.drawImage(d.getIAD().getImage(2).get(0), d.getXPos()+decX, d.getUp().get(j)+decY,null);
				}
			}
			for(int j = 0; j< d.getDown().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(3).get(1), d.getXPos()+decX, d.getDown().get(j)+decY,null);
				}
				else{
					g.drawImage(d.getIAD().getImage(3).get(0), d.getXPos()+decX, d.getDown().get(j)+decY,null);
				}
			}
			for(int j = 0; j< d.getLeft().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(0).get(1), d.getLeft().get(j)+decX, d.getYPos()+decY,null);
				}
				else{
					g.drawImage(d.getIAD().getImage(0).get(0), d.getLeft().get(j)+decX, d.getYPos()+decY,null);
				}
			}
			for(int j = 0; j< d.getRight().size(); j++){
				if(j==d.getUp().size()-1){
					g.drawImage(d.getIAD().getImage(1).get(1), d.getRight().get(j)+decX, d.getYPos()+decY,null);
				}
				else{
					g.drawImage(d.getIAD().getImage(1).get(0), d.getRight().get(j)+decX, d.getYPos()+decY,null);
				}
			}
		}
		for(FireBall1 a : data7) {
			g.drawImage(kirby, a.getXPos()+decX, a.getYPos()+decY,null);
		}
		}
	}
