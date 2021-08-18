import java.awt.Image;
import java.util.List;

public class Bomb extends Decor {
	
	private int time;
	private int damage;
	private int mytick;
	private int direction = -1;
	
	public Bomb(int xPos, int yPos, Image image, int damage)
	{
		super(xPos,yPos,image);	
		this.damage=damage;
	}
	
	public int getDirection(){
		return this.direction;
	}
	
	public void setDirection(int d){
		this.direction = d;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void tick(){
		this.mytick++;
		if(this.mytick == 10) {
			this.time++;
			mytick = 1;
		}
	}
	
	public int getTime(){
		return time;
	}
	
	public void setTime(int time){
		this.time = time;
		this.mytick = 1;
	}
	
	public void move(){
		if(direction == 0){
			setXPos(getXPos() - 5);
		}
		if(direction == 1){
			setXPos(getXPos() + 5);
		}
		if(direction == 2){
			setYPos(getYPos() - 5); //panel 
		}
		if(direction == 3){
			setYPos(getYPos() + 5); //panel
		}
	}
	
	public void bombInteraction(List<Decor> decor, List<Link> link, List<Monster> monster, List<Bomb> bomb){
		for(int i = 0; i < decor.size(); i++){
			if(touch2(getXPos(),getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
					&& decor.get(i).getClass() != Floor.class){
				System.out.println("je me suis planté dans un décor hihi");
				direction = -1;
			}
		}
		move();
	}
	
	public int touch2(int x1, int y1, int x2, int y2){ //coin supÃ©rieur gauche
		if(Math.abs(x1-x2)<35 && Math.abs(y1-y2)<20){
			if(x1-x2 < 0){
				//System.out.println("pd");
				return 0; //GAUCHE
			}
			else{
				//System.out.println("pd");
				return 1; //DROITE
			}
		}
		else if(Math.abs(x1-x2)<20 && 35>Math.abs(y1-y2)){
			if(y1-y2 < 0){
				//System.out.println("pd");
				return 2; //HAUT
			}
			else{
				//System.out.println("pd");
				return 3; //BAS
			}
		}
		else{
			//System.out.println("hihihihi");
			return -1;
		}
	}
	
	public int touchMonster(int x1, int y1, int x2, int y2){ //coin supÃ©rieur gauche
		if(Math.abs(x1-x2)<30 && Math.abs(y1-y2)<25){
			if(x1-x2 < 0){
				//System.out.println("pd");
				return 0; //GAUCHE
			}
			else{
				//System.out.println("pd");
				return 1; //DROITE
			}
		}
		else if(Math.abs(x1-x2)<25 && 30>Math.abs(y1-y2)){
			if(y1-y2 < 0){
				//System.out.println("pd");
				return 2; //HAUT
			}
			else{
				//System.out.println("pd");
				return 3; //BAS
			}
		}
		else{
			//System.out.println("hihihihi");
			return -1;
		}
	}
	
	public int touchBomb(int x1, int y1, int x2, int y2){ //coin supÃ©rieur gauche
		if(Math.abs(x1-x2)<40 && Math.abs(x1-x2)>30 && Math.abs(y1-y2)<25){
			if(x1-x2 < 0){
				//System.out.println("pd");
				return 0; //GAUCHE
			}
			else{
				//System.out.println("pd");
				return 1; //DROITE
			}
		}
		else if(Math.abs(x1-x2)<30 && 40>Math.abs(y1-y2) && Math.abs(y1-y2)>25){
			if(y1-y2 < 0){
				//System.out.println("pd");
				return 2; //HAUT
			}
			else{
				//System.out.println("pd");
				return 3; //BAS
			}
		}
		else{
			//System.out.println("hihihihi");
			return -1;
		}
	}
	
	
	/*
	public BombDeflagration explosion (int xPos, int yPos, String name) {
		BombDeflagration bombDeflagration = new BombDeflagration(xPos, yPos, 2, name);
		return bombDeflagration;
	}
	*/

}
