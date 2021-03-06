import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Image;


public class Fenetre extends JFrame implements KeyListener {
	
	private Panel link;
	private int k =0;
	private Map map;
	
	private ArrayList<Link> liste;
	private ArrayList<Arrow> ar;
	private List<Bomb> b;
	private List<Decor> d;
	private List<Bonus> bonus;
	private List<BombDeflagration> bombDeflagration;
	private List<Monster> monster;
	private List<FireBall1> feu;
	
	boolean droiteEnfoncee = false;
	boolean gaucheEnfoncee = false;
	boolean basEnfoncee = false;
	boolean hautEnfoncee = false;
	boolean tireFleche = false;
	boolean setBomb = false;
	boolean useStaff=false;
	boolean treasureOpen = false;

	private ArrayList<ArrayList<int[]>> listHitBoxDecor;
	
	
	
	ImageAnimeDirection linkRun = new ImageAnimeDirection("res/LinkRun",6);
	ImageAnimeDirection linkArrow = new ImageAnimeDirection("res/LinkArrow",6);
	ImageAnimeDirection arrow = new ImageAnimeDirection("res/Arrow",3);
	ImageAnimeDirection deflagration = new ImageAnimeDirection("res/Deflagration",2);
	Image bomb = Toolkit.getDefaultToolkit().getImage("res/Bomb.png");
	Image littleTree = Toolkit.getDefaultToolkit().getImage("res/LittleTree.png");
	Image bigTree = Toolkit.getDefaultToolkit().getImage("res/BigTree.png");
	Image rock = Toolkit.getDefaultToolkit().getImage("res/Rock.png");
	Image rocks = Toolkit.getDefaultToolkit().getImage("res/Rocks.png");
	ImageAnimeDirection melee = new ImageAnimeDirection("res/MeleeRun",1);
	ImageAnimeDirection kirby = new ImageAnimeDirection("res/Deflagration.png",1);
	Image heart = Toolkit.getDefaultToolkit().getImage("res/Heart.png"); 
	Image rubis = Toolkit.getDefaultToolkit().getImage("res/Rubis.png"); 
	Image arrowPlus = Toolkit.getDefaultToolkit().getImage("res/ArrowPlus.png"); 
	Image iceStaff = Toolkit.getDefaultToolkit().getImage("res/IceStaff.png"); 
	Image key = Toolkit.getDefaultToolkit().getImage("res/Key.png"); 
	Image speed = Toolkit.getDefaultToolkit().getImage("res/SpeedBonus.png"); 
	Image gauntlet = Toolkit.getDefaultToolkit().getImage("res/Gauntlet2.png"); 
	Image fireStaff = Toolkit.getDefaultToolkit().getImage("res/FireStaff.png"); 
	Image bombRange = Toolkit.getDefaultToolkit().getImage("res/BombRange.png");	
	Image bombPlus = Toolkit.getDefaultToolkit().getImage("res/BombPlus.png"); 
	Image treasureChest1 = Toolkit.getDefaultToolkit().getImage("res/TreasureChest1.png");
	Image treasureChest2 = Toolkit.getDefaultToolkit().getImage("res/TreasureChest2.png");
	
	
	private Image bonusImage[]={heart,bombPlus,bombRange,arrowPlus,speed,gauntlet,key,fireStaff,iceStaff,rubis};
	
	
	public Fenetre(List<Decor> d,List<Monster> monster, Map map) {
		this.d = d;
		this.map = map;
		this.monster = monster;
	    setVisible(true) ;
		setSize(15*41+200, 15*42+8+120);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		liste = new ArrayList<Link>();
		ar = new ArrayList<Arrow>();
		b = new ArrayList<Bomb>();
		bonus = new ArrayList<Bonus>();
		//d = new ArrayList<Decor>();
		bombDeflagration = new ArrayList<BombDeflagration>();
		feu = new ArrayList<FireBall1>();
		//monster = new ArrayList<Monster>();
		rajouteLink(liste,200,200);
		d.add(new Treasure(9*40,2*40,treasureChest1,9));
		//rajouteLink(liste,200,250);
		//rajouteDecor(d,0,0, rock);
		rajouteDecor(d,40*10,40*10, rock);
		listHitBoxDecor=listAllAroundPixel(d);
		//rajouteDecor(d,40*7,40*2, bigTree);
		//rajouteDecor(d,40*9,40*9, rocks);
		//l = new ArrayList<Link>();
		//ImageAnimeDirection linkRun = new ImageAnimeDirection("res/LinkRun",6);
		//ImageAnimeDirection linkRun2 = new ImageAnimeDirection("res/LinkRun",6);
		//Link l1 = new Link(0,200,200,0,3,linkRun,0,0,0,false,false); //penser ?????? utiliser vitesse
		//Link l2 = new Link(0,250,210,0,3,linkRun2,0,0,0,false,false);
		
		
		
		link = new Panel(liste,ar,b,d,bombDeflagration,monster,feu,bonus);
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
	
	public ArrayList<ArrayList<int[]>> listAllAroundPixel(List<Decor> list) {
		ArrayList<ArrayList<int[]>> listAllAroundPixel = new ArrayList<ArrayList<int[]>>();
		for(Decor decor : list) {
			if (decor.getClass()== Floor.class){
				
			}
			else{
			listAllAroundPixel.add(decor.listAroundPixel());
		}
		}
		return listAllAroundPixel;
			
	}

	private List<Link> rajouteLink(List<Link> liste,int x,int y){
		
	  Link link = new Link(3,x,y,2,1,linkRun,5,3,0,true,true,0);
	  liste.add(link);
	  return liste;
	  
	}
	
	private List<Decor> rajouteDecor(List<Decor> liste,int x,int y, Image image){
		
		  liste.add(new Decor(x,y,image));
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
		//System.out.println(liste.get(0).touch2(liste.get(0).getXPos(), liste.get(0).getYPos(), 40, 40));
		
		
		
		if(liste.get(0).getInvincible() == 0){
			//System.out.println("hihihihi Link est invincible...");
			liste.get(0).tickInvicible();
		}
		if(monster.size() > 0){
			for(int i = 0; i < monster.size(); i++){
				if(monster.get(i).getInvincible() == 0){
					//System.out.println("Le monstre n??" + i + " est invincible...");
					monster.get(i).tickInvicible();
				}
				if(monster.get(i).getLifePoint() == 0){
					monster.remove(i);
					//System.out.println("Le monstre n??" + i +" est mort!");
				}
			}
		}
		
		liste.get(0).linkInteraction(d, monster, b,bonus,map);
		
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
				//System.out.println(ar.get(p).getXPos() + " " + ar.get(p).getYPos());
				int a = ar.get(p).projectileInteraction(liste, monster,d,b);
				if(a != 0){
					if(a == 2){
						ar.get(p).tick();
						ar.get(p).setActualFrame(1);
						if(ar.get(p).getTime() == 15){
							ar.remove(p);
						}
					}
					else{
						ar.remove(p);
					}
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
				b.get(p).bombInteraction(d,liste,monster,b);
				b.get(p).tick();
				if(b.get(p).getTime() == 15){ //changer dans deflagration si changement de temps
					Sound.playSound("bomb");
					bombDeflagration.add(new BombDeflagration(b.get(p).getXPos(),b.get(p).getYPos(),deflagration,2,2));
					//feu.add(new FireBall1(b.get(p).getXPos(),b.get(p).getYPos(),kirby,2,2,2,liste.get(0).getXPos(), liste.get(0).getYPos(), 15*40, 15*40));
					b.remove(p);
				}
			}
		}
		if(bombDeflagration.size()>0){
			for(int p = 0; p < bombDeflagration.size(); p++){
				bombDeflagration.get(p).tick();
				if(bombDeflagration.get(p).getPortee() < liste.get(0).getRangeBomb()*4+2){
					bombDeflagration.get(p).appear(liste.get(0).getRangeBomb(),d,bonus);
					bombDeflagration.get(p).defInteraction(liste, monster, b);
				}
				else{
					bombDeflagration.remove(p);
				}
			}
		}
		if(feu.size()>0){
			for(int p = 0; p < feu.size(); p++){
				feu.get(p).tick();
				feu.get(p).move();
				//System.out.println(feu.get(p).getXPos()+ " " + feu.get(p).getYPos());
					if(feu.get(p).getList().size() < feu.get(p).getPos()-1){
						feu.remove(p);
					}
			}
		}
		
		
		if(useStaff==true && liste.get(0).getStaff()!=-1) {
			if(liste.get(0).getStaff()==0) {
			for (Monster m : monster) {
				m.setLifePoint(m.getLifePoint()-1);
				System.out.println("monstre hihihi a"+" "+m.getLifePoint());				
			}
			useStaff=false; liste.get(0).setStaff(-1); System.out.println("firestaff off");
		}
			else if(liste.get(0).getStaff()==1) {
				for (Monster m : monster) {
					m.setFrozen();
					m.tickFrozen();	
					if(m.getFrozen()==1) {
						useStaff=false; liste.get(0).setStaff(-1); System.out.println("icestaff off");
					
				}
				
			}
		}
		}
		
		if(treasureOpen) {
			for(Decor decor : d) {
				if(decor.getClass() == Treasure.class && ((decor.getXPos()-liste.get(0).getXPos())<=20 && (decor.getXPos()-liste.get(0).getXPos())>=-20 && liste.get(0).getYPos() - decor.getYPos()<40) && decor.getImage() == treasureChest1) {
					 decor.setImage(treasureChest2);
					 bonus.add(new Bonus(decor.getXPos(),decor.getYPos(),bonusImage[((Treasure)decor).getBonusType()],((Treasure)decor).getBonusType()));		
					 treasureOpen=false; 
				}
				else if(decor.getClass() == Treasure.class && ((decor.getXPos()-liste.get(0).getXPos())<=20 && (decor.getXPos()-liste.get(0).getXPos())>=-20 && liste.get(0).getYPos() - decor.getYPos()<40) && decor.getImage() == treasureChest2) {
					for(int i = 0; i < bonus.size(); i++) {
						if (bonus.get(i).getXPos() == decor.getXPos() && bonus.get(i).getYPos() == decor.getYPos()) {
							bonus.get(i).activation(liste.get(0));
							bonus.remove(i);
							treasureOpen = false;
			
						}
					}
				}
				
				else { treasureOpen=false;}
				
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
    	else if(keyCode == KeyEvent.VK_C) {
    		useStaff = true;
    	}
    	else if(keyCode == KeyEvent.VK_ENTER) {
    		treasureOpen = true;
    	}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int i = 0;
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
		//System.out.println("Code touche tap????e : " + e.getKeyCode() + " - caract????re touche tap????e : " + e.getKeyChar());

	      
		// TODO Auto-generated method stub
		
	}
}
