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
	private long dephasage;
	private long time;
	private int i =0;
	private int j =0;
	private int k =0;
	private int h =0;
	
	boolean droiteEnfoncee = false;
	boolean gaucheEnfoncee = false;
	boolean basEnfoncee = false;
	boolean hautEnfoncee = false;
	
	
	Image linkRunRight = Toolkit.getDefaultToolkit().createImage("res/linkRunRight.png");
	Image linkRunLeft = Toolkit.getDefaultToolkit().createImage("res/linkRunleft.png");
	Image linkRunUp = Toolkit.getDefaultToolkit().createImage("res/linkRunUp.png");
	Image linkRunDown = Toolkit.getDefaultToolkit().createImage("res/linkRunDown.png");
	Image img5 = Toolkit.getDefaultToolkit().createImage("res/link5.png");
	Image img6 = Toolkit.getDefaultToolkit().createImage("res/link6.png");
	Image img7 = Toolkit.getDefaultToolkit().createImage("res/link7.png");
	Image img8 = Toolkit.getDefaultToolkit().createImage("res/link8.png");
	Image img9 = Toolkit.getDefaultToolkit().createImage("res/link9.png");

	
	public Fenetre() {
	    setVisible(true) ;
		setSize(1600, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		l = new Link(0,200,200,0,0,"res/linkRunRight.png",0,0,0,false,false);
		link = new Panel(l.getName(),l.getXPos(),l.getYPos(), "res/1.png",50,50);
		link.z = 170;
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
			link.image = linkRunRight;
			i += 1;
	    	l.setXPos(l.getXPos() + 1);
			link.x = l.getXPos();
			if(i == 3){
				link.z = 140;
			}
			else if(i == 6){
				link.z = 108;
			}
			else if(i == 9){
				link.z = 75;
			}
			else if(i == 12){
				link.z = 45;
			}
			else if(i == 15){
				link.z = 7;
			}
			else if(i > 15){
				i = 0;
			}
			
		}
		if(gaucheEnfoncee){
			link.image = linkRunLeft;
			i += 1;
	    	l.setXPos(l.getXPos() - 1);
			link.x = l.getXPos();
			if(i == 3){
				link.z = 30;
			}
			else if(i == 6){
				link.z = 62;
			}
			else if(i == 9){
				link.z = 95;
			}
			else if(i == 12){
				link.z = 125;
			}
			else if(i == 15){
				link.z = 163;
			}
			else if(i > 15){
				i = 0;
			}
		}
		
		if(basEnfoncee){
			link.image = linkRunDown;
			i += 1;
	    	l.setYPos(l.getYPos()+1);
			link.y = l.getYPos();
			if(i == 3){
				link.z = 30;
			}
			else if(i == 6){
				link.z = 62;
			}
			else if(i == 9){
				link.z = 95;
			}
			else if(i == 12){
				link.z = 125;
			}
			else if(i == 15){
				link.z = 163;
			}
			else if(i > 15){
				i = 0;
			}
		}
		if(hautEnfoncee){
			link.image = linkRunUp;
			i += 1;
	    	l.setYPos(l.getYPos()-1 );
			link.y = l.getYPos();
			if(i == 3){
				link.z = 30;
			}
			else if(i == 6){
				link.z = 62;
			}
			else if(i == 9){
				link.z = 95;
			}
			else if(i == 12){
				link.z = 125;
			}
			else if(i == 15){
				link.z = 163;
			}
			else if(i > 15){
				i = 0;
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
		i = 0;
	    int keyCode = e.getKeyCode();
	    if (keyCode == KeyEvent.VK_RIGHT){
	    	droiteEnfoncee = false;
	    	link.z = 174;
	    }
    	else if(keyCode == KeyEvent.VK_LEFT){
    		gaucheEnfoncee = false;
    		link.z = -4;
    	}
    	else if(keyCode == KeyEvent.VK_DOWN) {
    		basEnfoncee = false;
    		link.z = -4;
    	}
    	else if(keyCode == KeyEvent.VK_UP) {
    		hautEnfoncee = false;
    		link.z = -4;
    	}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("Code touche tapée : " + e.getKeyCode() + " - caractère touche tapée : " + e.getKeyChar());

	      
		// TODO Auto-generated method stub
		
	}
}
