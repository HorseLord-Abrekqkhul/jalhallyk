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
	boolean tireFleche = false;
	
	
	Image linkRunRight = Toolkit.getDefaultToolkit().createImage("res/linkRunRight.png");
	Image linkRunLeft = Toolkit.getDefaultToolkit().createImage("res/linkRunleft.png");
	Image linkRunUp = Toolkit.getDefaultToolkit().createImage("res/linkRunUp.png");
	Image linkRunDown = Toolkit.getDefaultToolkit().createImage("res/linkRunDown.png");
	Image linkArrowRight = Toolkit.getDefaultToolkit().createImage("res/linkArrowRight.png");
	Image linkArrowLeft = Toolkit.getDefaultToolkit().createImage("res/linkArrowLeft.png");
	Image linkArrowUp = Toolkit.getDefaultToolkit().createImage("res/linkArrowUp.png");
	Image linkArrowDown = Toolkit.getDefaultToolkit().createImage("res/linkArrowDown.png");
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

		if(droiteEnfoncee){
			link.image = linkRunRight;
			i += 1;
	    	l.moveRight();
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
	    	l.moveLeft();
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
	    	l.moveDown();
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
	    	l.moveUp();
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
		if(tireFleche){
			i += 1;
			switch(l.getDirection()){
				case 1:
					link.image = linkArrowUp;
				case 2:
					link.image = linkArrowDown;
				case 3:
					link.image = linkArrowLeft;
				case 4:
					link.image = linkArrowRight;
					if(i == 1){
						link.z = -4;
					}
					else if(i == 3){
						link.z = 26;
					}
					else if(i == 5){
						link.z = 55;
					}
					else if(i == 7){
						link.z = 84;
					}
					else if(i == 9){
						link.z = 113;
					}
					else if(i == 10){
						link.z = 142;
					}
					else if(i == 12){
						link.z = 26;
					}
					else if(i == 14){
						link.z = -4;
						tireFleche = false;
						Arrow arrow = new Arrow(l.getXPos(),l.getYPos(),"res/arrow.png",1,l.getDirection());
					}
				
			}
			
		}
		repaint();
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
    	else if(keyCode == KeyEvent.VK_X){
    		tireFleche = true;
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
