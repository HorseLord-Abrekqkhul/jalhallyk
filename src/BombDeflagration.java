import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;



public class BombDeflagration extends Damage{
	public BombDeflagration(int xPos, int yPos,ImageAnimeDirection IAD,int c,int damage){
		super(xPos,yPos,IAD,c,damage);
		
	}
	
	Image brokenJar = Toolkit.getDefaultToolkit().getImage("res/ForestBrokenJar.png");
	
	private int U = 1; 
	private int D = 1;
	private int L = 1;
	private int R = 1;
	private ArrayList<Integer> up;
	private ArrayList<Integer> down;
	private ArrayList<Integer> left;
	private ArrayList<Integer> right;
	private int portee = 1;
	private int mytick = 1;
	
	public int[][] listeExplosion(int rangeBomb){ //x,y = milieu de la case
		int l[][] = new int[4][rangeBomb*4+2]; //avance par 10 pixels
		for(int j = 0; j < rangeBomb*4+2;j++){ // 0 GAUCHE, 1 DROITE, 2 HAUT, 3 BAS
			l[0][j] = getXPos() - j*10;
			l[1][j] = getXPos() + j*10;
			l[2][j] = getYPos() - j*10;
			l[3][j] = getYPos() + j*10;	
		}
		return l;
	}
	
	public void tick(){
		this.mytick++;
		if(this.mytick == getC()) {
			this.portee++;
			mytick = 1;
		}
	}
	
	public int getPortee(){
		return this.portee;
	}
	
	public void appear(int rangeBomb,List<Decor> d){
		int liste[][] = listeExplosion(rangeBomb);
		up = new ArrayList<Integer>();
		down = new ArrayList<Integer>();
		left = new ArrayList<Integer>();
		right = new ArrayList<Integer>();
		for(int j = 0; j < portee;j++){
			for(int i = 0; i < d.size(); i++){
				if(touch2(liste[0][j],getYPos(),d.get(i).getXPos(),d.get(i).getYPos()) != -1
						&& d.get(i).getClass() != Floor.class){
					if(d.get(i).getClass() == Jar.class && L == 1){
						left.add(liste[0][j]);
						left.add(liste[0][j+1]);
						left.add(liste[0][j+2]);
						d.remove(i);
						d.get(i-1).setImage(brokenJar);
					}
					L = 0;
				}
				if(touch2(liste[1][j],getYPos(),d.get(i).getXPos(),d.get(i).getYPos()) != -1
						&& d.get(i).getClass() != Floor.class){
					if(d.get(i).getClass() == Jar.class && R == 1){
						right.add(liste[1][j]);
						right.add(liste[1][j+1]);
						right.add(liste[1][j+2]);
						d.remove(i);
						d.get(i-1).setImage(brokenJar);
					}
					R = 0;
				}
				if(touch2(getXPos(),liste[2][j],d.get(i).getXPos(),d.get(i).getYPos()) != -1
						&& d.get(i).getClass() != Floor.class){
					if(d.get(i).getClass() == Jar.class && U == 1){
						down.add(liste[2][j]);
						down.add(liste[2][j+1]);
						down.add(liste[2][j+2]);
						d.remove(i);
						d.get(i-1).setImage(brokenJar);
					}
					U = 0;
				}
				if(touch2(getXPos(),liste[3][j],d.get(i).getXPos(),d.get(i).getYPos()) != -1
						&& d.get(i).getClass() != Floor.class){
					//System.out.println("obstacle " + D);
					//System.out.println("avant " +D + " " + portee);
					if(d.get(i).getClass() == Jar.class && D == 1){
						up.add(liste[3][j]);
						up.add(liste[3][j+1]);
						up.add(liste[3][j+2]);
						d.remove(i);
						d.get(i-1).setImage(brokenJar);
					}
					D = 0;
				}
			}
			if(L == 1){
				left.add(liste[0][j]);
			}
			if(R == 1){
				right.add(liste[1][j]);
			}
			if(U == 1){
				up.add(liste[2][j]);
			}
			if(D == 1){
				down.add(liste[3][j]);
			}
		}	
	}
	
	public ArrayList<Integer> getUp(){
		return this.up;
	}
	
	public ArrayList<Integer> getDown(){
		return this.down;
	}
	
	public ArrayList<Integer> getLeft(){
		return this.left;
	}
	
	public ArrayList<Integer> getRight(){
		return this.right;
	}
	
	public void bombInteraction(List<Link> l, List<Monster> monster, List<Bomb> bomb){
		for(int j = 0; j < up.size(); j++){
			for(int i = 0; i< l.size(); i++){
				if(touch2(getXPos(),up.get(j),l.get(i).getXPos(),l.get(i).getYPos()) != -1){
					l.get(i).setLifePoint(l.get(i).getLifePoint()-1*l.get(i).getInvincible());
					l.get(i).setInvicible();
					System.out.println("Link a perdu une vie, il lui reste "+ l.get(i).getLifePoint() + " vies.");
				}
			}
			for(int i = 0; i< monster.size(); i++){
				if(touch2(getXPos(),up.get(j),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
					monster.get(i).setLifePoint(monster.get(i).getLifePoint()-1*monster.get(i).getInvincible());
					monster.get(i).setInvicible();
					System.out.println("Monstre n°" + i + " a perdu une vie, il lui reste "+ monster.get(i).getLifePoint() + " vies.");
				}
			}
			for(int i = 0; i< bomb.size(); i++){
				if(touch2(getXPos(),up.get(j),bomb.get(i).getXPos(),bomb.get(i).getYPos()) != -1){
					bomb.get(i).setTime(15);
				}
			}
		}
		for(int j = 0; j < down.size(); j++){
			for(int i = 0; i< l.size(); i++){
				if(touch2(getXPos(),down.get(j),l.get(i).getXPos(),l.get(i).getYPos()) != -1){
					l.get(i).setLifePoint(l.get(i).getLifePoint()-1*l.get(i).getInvincible());
					l.get(i).setInvicible();
					System.out.println("Link a perdu une vie, il lui reste "+ l.get(i).getLifePoint() + " vies.");
				}
			}
			for(int i = 0; i< monster.size(); i++){
				if(touch2(getXPos(),down.get(j),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
					monster.get(i).setLifePoint(monster.get(i).getLifePoint()-1*monster.get(i).getInvincible());
					monster.get(i).setInvicible();
					System.out.println("Monstre n°" + i + " a perdu une vie, il lui reste "+ monster.get(i).getLifePoint() + " vies.");
				}
			}
			for(int i = 0; i< bomb.size(); i++){
				if(touch2(getXPos(),down.get(j),bomb.get(i).getXPos(),bomb.get(i).getYPos()) != -1){
					bomb.get(i).setTime(15);
				}
			}
		}
		for(int j = 0; j < left.size(); j++){
			for(int i = 0; i< l.size(); i++){
				if(touch2(left.get(j),getYPos(),l.get(i).getXPos(),l.get(i).getYPos()) != -1){
					l.get(i).setLifePoint(l.get(i).getLifePoint()-1*l.get(i).getInvincible());
					l.get(i).setInvicible();
					System.out.println("Link a perdu une vie, il lui reste "+ l.get(i).getLifePoint() + " vies.");
				}
			}
			for(int i = 0; i< monster.size(); i++){
				if(touch2(left.get(j),getYPos(),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
					monster.get(i).setLifePoint(monster.get(i).getLifePoint()-1*monster.get(i).getInvincible());
					monster.get(i).setInvicible();
					System.out.println("Monstre n°" + i + " a perdu une vie, il lui reste "+ monster.get(i).getLifePoint() + " vies.");
				}
			}
			for(int i = 0; i< bomb.size(); i++){
				if(touch2(left.get(j),getYPos(),bomb.get(i).getXPos(),bomb.get(i).getYPos()) != -1){
					bomb.get(i).setTime(15);
				}
			}
		}
		for(int j = 0; j < right.size(); j++){
			for(int i = 0; i< l.size(); i++){
				if(touch2(right.get(j),getYPos(),l.get(i).getXPos(),l.get(i).getYPos()) != -1){
					l.get(i).setLifePoint(l.get(i).getLifePoint()-1*l.get(i).getInvincible());
					l.get(i).setInvicible();
					System.out.println("Link a perdu une vie, il lui reste "+ l.get(i).getLifePoint() + " vies.");
				}
			}
			for(int i = 0; i< monster.size(); i++){
				if(touch2(right.get(j),getYPos(),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
					monster.get(i).setLifePoint(monster.get(i).getLifePoint()-1*monster.get(i).getInvincible());
					monster.get(i).setInvicible();
					System.out.println("Monstre n°" + i + " a perdu une vie, il lui reste "+ monster.get(i).getLifePoint() + " vies.");
				}
			}
			for(int i = 0; i< bomb.size(); i++){
				if(touch2(right.get(j),getYPos(),bomb.get(i).getXPos(),bomb.get(i).getYPos()) != -1){
					bomb.get(i).setTime(15);
				}
			}
		}
	}
}