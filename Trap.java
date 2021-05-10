
public class Trap extends Decor {
	
	protected int damage;
	
	public Trap(int xPos, int yPos, String name, int damage) {
		super(xPos,yPos,name);
		this.damage=damage;
	}
	
	public int getDamage() {
		return this.damage;		
		
	}
	
	public void setDamage(int damage) {
		this.damage=damage;
	}
	

}
