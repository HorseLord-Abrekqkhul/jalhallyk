/**
 * 
 */

/**
 * @author Neocross
 *
 */
public class Damage extends Item{
	private int damage;
	public Damage(int xPos, int yPos,ImageAnimeDirection IAD,int c,int damage){
		super(xPos,yPos,IAD,c);
		this.damage = damage;
	}
	
	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	
	public void doDamage(Link link){
		link.setLifePoint(link.getLifePoint()-this.damage);
	}
}
