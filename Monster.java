public class Monster extends Character {

	public Monster (int lifePoint, int xPos, int yPos, int speed,int direction)
	{
		super (lifePoint, xPos, yPos, speed, direction);
	}
	
	public void moveUp ()
	{
		setYpos(yPos + 1);
	}

	public void moveDown ()
	{
		setYpos(yPos - 1);
	}

	public void moveRight ()
	{
		setXpos(xPos + 1);
	}

	public void moveLeft ()
	{
		setXpos(xPos - 1);
	}
	
	public void dealDamage(Link Link)
	{
		Link.setLifePoint(Link.getLifePoint() - 1);
	}
	
	//IA
}
