
public class Monster extends Character {

	public Monster (int lifePoint, int xPos, int yPos, int speed,int direction)
	{
		super (lifePoint, xPos, yPos, speed, direction);
	}
	
	public void moveUp ()
	{
		setYPos(yPos + 1);
	}

	public void moveDown ()
	{
		setYPos(yPos - 1);
	}

	public void moveRight ()
	{
		setYPos(xPos + 1);
	}

	public void moveLeft ()
	{
		setYPos(xPos - 1);
	}
	
	public void dealDamage(Link Link)
	{
		Link.setLifePoint(Link.getLifePoint() - 1);
	}
	
	//IA
}
