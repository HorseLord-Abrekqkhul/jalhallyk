import java.util.ArrayList;



public class BombDeflagration extends Damage{
	public BombDeflagration(int xPos, int yPos,ImageAnimeDirection IAD,int c,int damage){
		super(xPos,yPos,IAD,c,damage);
		
	}
	
	private int direction;
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
	
	public void appear(int rangeBomb){
		int liste[][] = listeExplosion(rangeBomb);
		up = new ArrayList<Integer>();
		down = new ArrayList<Integer>();
		left = new ArrayList<Integer>();
		right = new ArrayList<Integer>();
		for(int j = 0; j < portee;j++){
			//tester la collision ici
			left.add(liste[0][j]);
			right.add(liste[1][j]);
			up.add(liste[2][j]);
			down.add(liste[3][j]);
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
	
	
}