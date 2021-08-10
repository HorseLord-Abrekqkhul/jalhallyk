import java.util.ArrayList;
import java.util.List;



public class BombDeflagration extends Damage{
	public BombDeflagration(int xPos, int yPos,ImageAnimeDirection IAD,int c,int damage){
		super(xPos,yPos,IAD,c,damage);
		
	}
	
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
		int U = 1; 
		int D = 1;
		int L = 1;
		int R = 1;
		for(int j = 0; j < portee;j++){
			for(int i = 0; i < d.size(); i++){
				if(touch2(liste[0][j],getYPos(),d.get(i).getXPos(),d.get(i).getYPos()) != -1
						&& d.get(i).getClass() != Floor.class){
					if(d.get(i).getClass() == Jar.class && L == 1){
						left.add(liste[0][j]);
						d.remove(i);
					}
					L = 0;
				}
				if(touch2(liste[1][j],getYPos(),d.get(i).getXPos(),d.get(i).getYPos()) != -1
						&& d.get(i).getClass() != Floor.class){
					if(d.get(i).getClass() == Jar.class && R == 1){
						right.add(liste[0][j]);
						d.remove(i);
					}
					R = 0;
				}
				if(touch2(getXPos(),liste[2][j],d.get(i).getXPos(),d.get(i).getYPos()) != -1
						&& d.get(i).getClass() != Floor.class){
					if(d.get(i).getClass() == Jar.class && U == 1){
						down.add(liste[0][j]);
						d.remove(i);
					}
					U = 0;
				}
				if(touch2(getXPos(),liste[3][j],d.get(i).getXPos(),d.get(i).getYPos()) != -1
						&& d.get(i).getClass() != Floor.class){
					if(d.get(i).getClass() == Jar.class && D == 1){
						up.add(liste[0][j]);
						d.remove(i);
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
	
	/*
	public ArrayList<ArrayList<int[]>> touchList(List<Link> l, List<Monster> monster){
		ArrayList<int[]> listeDecor = new ArrayList<int[]>();
		ArrayList<int[]> listeItem = new ArrayList<int[]>();
		ArrayList<int[]> listeChar = new ArrayList<int[]>();
		ArrayList<ArrayList<int[]>> listeAll = new ArrayList<ArrayList<int[]>>();
		for(int i = 0; i< d.size(); i++){
			if(touch2(x,y,d.get(i).getXPos(),d.get(i).getYPos()) != -1
					&& d.get(i).getClass() != Floor.class){
				int pos[] = {i,touch2(this.xPos,this.yPos,d.get(i).getXPos(),d.get(i).getYPos())};
				listeDecor.add(pos);
			}
		}
		for(int i = 0; i< b.size(); i++){
			if(touch2(x,y,b.get(i).getXPos(),b.get(i).getYPos()) != -1){
				int pos[] = {i,touch2(this.xPos,this.yPos,b.get(i).getXPos(),b.get(i).getYPos())};
				listeItem.add(pos);
			}
		}
		for(int i = 0; i< monster.size(); i++){
			if(touch2(x,y,monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
				int pos[] = {i,touch2(this.xPos,this.yPos,monster.get(i).getXPos(),monster.get(i).getYPos())};
				listeChar.add(pos);
			}
		}
		listeAll.add(listeDecor);
		listeAll.add(listeItem);
		listeAll.add(listeChar);
		return listeAll;
	}
	*/
}