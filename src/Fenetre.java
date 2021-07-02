import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;


public class Fenetre extends JFrame implements KeyListener {
	
	private Panel link;
	private Link l;
	private int i =0;
	private int j =0;
	private int k =0;
	private int h =0;
	
	boolean droiteEnfoncee = false;
	boolean gaucheEnfoncee = false;
	boolean basEnfoncee = false;
	boolean hautEnfoncee = false;
	
	Image img1 = Toolkit.getDefaultToolkit().createImage("res/link1.png");
	Image img2 = Toolkit.getDefaultToolkit().createImage("res/link2.png");
	Image img3 = Toolkit.getDefaultToolkit().createImage("res/link3.png");
	Image img4 = Toolkit.getDefaultToolkit().createImage("res/link4.png");
	Image img5 = Toolkit.getDefaultToolkit().createImage("res/link5.png");
	Image img6 = Toolkit.getDefaultToolkit().createImage("res/link6.png");
	Image img7 = Toolkit.getDefaultToolkit().createImage("res/link7.png");
	Image img8 = Toolkit.getDefaultToolkit().createImage("res/link8.png");
	Image img9 = Toolkit.getDefaultToolkit().createImage("res/link9.png");

	
	public Fenetre() {
	    setVisible(true) ;
		setSize(1600, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		l = new Link(0,200,200,0,0,"res/link2.png",0,0,0,false,false);
		link = new Panel(l.getName(),l.getXPos(),l.getYPos());
		getContentPane().add(link);
		addKeyListener(this);
		
		Timer timer = new Timer(30, new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				wololo();
				
			}
		});
		timer.start();
	}
	
	private void wololo() {
		repaint();
		if(droiteEnfoncee){
	    	l.setXPos(l.getXPos() + 1);
			link.x = l.getXPos();
			if (link.x%10 == 0){
				i += 1;
				if(i%2 == 0){
					l.setName("res/link2.png");
					link.image = img2;
				}
				else{
					l.setName("res/link3.png");
					link.image = img3;				}
			}
		}
		if(gaucheEnfoncee){
	    	l.setXPos(l.getXPos()-1);
			link.x = l.getXPos();
			if (link.x%10 == 0){
				j += 1;
				if(j%2 == 0){
					l.setName("res/link4.png");
					link.image = img4;
				}
				else{
					l.setName("res/link5.png");
					link.image = img5;
				}
			}
		}
		if(basEnfoncee){
	    	l.setYPos(l.getYPos()+1);
			link.y = l.getYPos();
			if (link.y%10 == 0){
				k += 1;
				if(k%2 == 0){
					l.setName("res/link8.png");
					link.image = img8;
				}
				else{
					l.setName("res/link9.png");
					link.image = img9;
				}
			}
		}
		if(hautEnfoncee){
	    	l.setYPos(l.getYPos()-1 );
			link.y = l.getYPos();
			if (link.y%10 == 0){
				h += 1;
				if(h%2 == 0){
					l.setName("res/link6.png");
					link.image = img6;
				}
				else{
					l.setName("res/link7.png");
					link.image = img7;
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    if (keyCode == KeyEvent.VK_RIGHT)
	    	droiteEnfoncee = true;
    	else if(keyCode == KeyEvent.VK_LEFT) {
    		gaucheEnfoncee = true;
    	}
    	else if(keyCode == KeyEvent.VK_DOWN) {
    		basEnfoncee = true;
    	}
    	else if(keyCode == KeyEvent.VK_UP) {
    		hautEnfoncee = true;
    	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	    int keyCode = e.getKeyCode();
	    if (keyCode == KeyEvent.VK_RIGHT){
	    	droiteEnfoncee = false;
	    }
    	else if(keyCode == KeyEvent.VK_LEFT){
    		gaucheEnfoncee = false;
    	}
    	else if(keyCode == KeyEvent.VK_DOWN) {
    		basEnfoncee = false;
    	}
    	else if(keyCode == KeyEvent.VK_UP) {
    		hautEnfoncee = false;
    	}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("Code touche tapée : " + e.getKeyCode() + " - caractère touche tapée : " + e.getKeyChar());

	      
		// TODO Auto-generated method stub
		
	}
}
