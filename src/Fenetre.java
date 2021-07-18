import java.awt.Color;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.util.List;

import java.util.ArrayList;



import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.Timer;



import java.awt.Image;





public class Fenetre extends JFrame implements KeyListener {

	

	private Panel link;

	private long dephasage;

	private long time;

	private int i =0;

	private int j =0;

	private int k =0;

	private int h =0;

	

	private List<Link> l;

	private ArrayList<Link> liste;

	private ArrayList<Arrow> ar;

	private List<Bomb> b;

	private List<BombDeflagration> d;

	

	boolean droiteEnfoncee = false;

	boolean gaucheEnfoncee = false;

	boolean basEnfoncee = false;

	boolean hautEnfoncee = false;

	boolean tireFleche = false;

	boolean setBomb = false;

	

	

	

	ImageAnimeDirection linkRun = new ImageAnimeDirection("res/LinkRun",6);

	ImageAnimeDirection linkArrow = new ImageAnimeDirection("res/LinkArrow",6);

	ImageAnimeDirection arrow = new ImageAnimeDirection("res/Arrow",3);

	ImageAnimeDirection deflagration = new ImageAnimeDirection("res/Deflagration",3);

	Image bomb = Toolkit.getDefaultToolkit().getImage("res/2.png");

	

	public Fenetre() {

	    setVisible(true) ;

		setSize(1600, 400);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		liste = new ArrayList<Link>();

		ar = new ArrayList<Arrow>();

		b = new ArrayList<Bomb>();

		d = new ArrayList<BombDeflagration>();

		rajouteLink(liste,200,200);

		rajouteLink(liste,200,250);

		//l = new ArrayList<Link>();

		//ImageAnimeDirection linkRun = new ImageAnimeDirection("res/LinkRun",6);

		//ImageAnimeDirection linkRun2 = new ImageAnimeDirection("res/LinkRun",6);

		//Link l1 = new Link(0,200,200,0,3,linkRun,0,0,0,false,false); //penser  utiliser vitesse

		//Link l2 = new Link(0,250,210,0,3,linkRun2,0,0,0,false,false);

		

		

		

		link = new Panel(liste,ar,b);

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

	

	private List<Link> rajouteLink(List<Link> liste,int x,int y){

		

	  Link link = new Link(0,x,y,0,1,linkRun,5,0,0,false,false);

	  liste.add(link);

	  return liste;

	  

	}

	



	

	private void wololo() {

		/*

		if(liste.get(1).getXPos() < 1000){

			//System.out.println(link.data.get(1).getXPos()); 

			liste.get(0).setXPos(liste.get(0).getXPos()+2);

			liste.get(1).setXPos(liste.get(1).getXPos()+2);

			liste.get(0).tick();

			//System.out.println(liste.get(0).getIAD().getActualFrame()); 

			liste.get(1).tick();

			

			if(liste.get(1).getXPos() == 500){

				rajouteLink(liste,liste.get(0).getXPos(),liste.get(0).getYPos());

			}

			

			if(liste.get(1).getXPos() > 500){

				liste.get(2).setDirection(0);

				liste.get(2).tick();

				liste.get(2).setXPos(liste.get(2).getXPos()-2);

			}

			

		}

		*/

		if(droiteEnfoncee){

			liste.get(0).setIAD(linkRun);

	    	liste.get(0).moveRight();

			

		}

		if(gaucheEnfoncee){

			liste.get(0).setIAD(linkRun);

	    	liste.get(0).moveLeft();

		}

		

		if(basEnfoncee){

			liste.get(0).setIAD(linkRun);

	    	liste.get(0).moveDown();

		}

		if(hautEnfoncee){

			liste.get(0).setIAD(linkRun);

	    	liste.get(0).moveUp();

		}

		if(tireFleche){

			liste.get(0).setIAD(linkArrow);

			liste.get(0).fireArrow(ar,arrow);

			if(liste.get(0).getActualFrame() == 6){

				tireFleche = false;

				liste.get(0).setActualFrame(1);

			}

		}

		if(ar.size()>0){

			for(int p = 0; p < ar.size(); p++){

				ar.get(p).move();

				if(ar.get(p).getXPos() > 1600 || ar.get(p).getXPos() < 0 ||

						ar.get(p).getYPos() > 400 || ar.get(p).getYPos() < 0){

					ar.remove(p);

				}

			}

		}

		if(setBomb){

			if(b.size()< liste.get(0).getNumberBomb()){

				liste.get(0).setBomb(b, bomb);

				

			}

			setBomb = false;

		}

		if(b.size()>0){

			for(int p = 0; p < b.size(); p++){

				b.get(p).tick();

				if(b.get(p).getTime() == 10){

					d.add(new BombDeflagration(b.get(p).getXPos(),b.get(p).getYPos(),deflagration,3,2));

					b.remove(p);

				}

			}

		}

		if(d.size()>0){

			for(int p = 0; p < d.size(); p++){

				d.get(p).tick();

				if(d.get(p).getPortee() < l.get(0).getRangeBomb()*4+2){

					

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

    	else if(keyCode == KeyEvent.VK_SPACE){

    		setBomb = true;

    	}

	}



	@Override

	public void keyReleased(KeyEvent e) {

		// TODO Auto-generated method stub

		i = 0;

		liste.get(0).setActualFrame(1);

	    int keyCode = e.getKeyCode();

	    if (keyCode == KeyEvent.VK_RIGHT){

	    	droiteEnfoncee = false;

	    	//link.posZ.set(0, 174);

	    }

    	else if(keyCode == KeyEvent.VK_LEFT){

    		gaucheEnfoncee = false;

	    	//link.posZ.set(0, -4);

    	}

    	else if(keyCode == KeyEvent.VK_DOWN) {

    		basEnfoncee = false;

	    	//link.posZ.set(0, -4);

    	}

    	else if(keyCode == KeyEvent.VK_UP) {

    		hautEnfoncee = false;

	    	//link.posZ.set(0, -4);

    	}



	}



	@Override

	public void keyTyped(KeyEvent e) {

		//System.out.println("Code touche tapée : " + e.getKeyCode() + " - caractère touche tapée : " + e.getKeyChar());



	      

		// TODO Auto-generated method stub

		

	}

}