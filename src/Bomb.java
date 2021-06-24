
public class Bomb extends Decor {
	
	private int damage;
	
	public Bomb(int xPos, int yPos, String name, int damage)
	{
		super(xPos,yPos,name);	
		this.damage=damage;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public BombDeflagration explosion (int xPos, int yPos, String name) {
		BombDeflagration bombDeflagration = new BombDeflagration(xPos, yPos, 2, name);
		return bombDeflagration;
	}

}
