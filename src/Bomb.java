import java.awt.Image;

public class Bomb extends Decor {
	
	private int time;
	private int damage;
	private int mytick;
	
	public Bomb(int xPos, int yPos, Image image, int damage)
	{
		super(xPos,yPos,image);	
		this.damage=damage;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void tick(){
		this.mytick++;
		if(this.mytick == 20) {
			this.time++;
			mytick = 1;
		}
	}
	
	public int getTime(){
		return time;
	}
	/*
	public BombDeflagration explosion (int xPos, int yPos, String name) {
		BombDeflagration bombDeflagration = new BombDeflagration(xPos, yPos, 2, name);
		return bombDeflagration;
	}
	*/

}
