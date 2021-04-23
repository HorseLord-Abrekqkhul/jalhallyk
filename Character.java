
public class Character {

	protected int lifePoint;
	protected int xPos;
	protected int yPos;
	protected int speed;
	protected int direction; //1 = haut, 2 = bas, 3 =droite, 4 = gauche
	
	public Character(int lifePoint, int xPos, int yPos, int speed, int direction){
		this.lifePoint =  lifePoint;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		this.direction = direction;
	}
	
	public int getLifePoint()
	{
		return lifePoint;	
	}
	
	public void setLifePoint(int lifePoint)
	{
		this.lifePoint = lifePoint;
	}
	
	public int getXPos()
	{ 
		return xPos;
	}
	
	public void setXPos(int xPos)
	{
		this.xPos = xPos;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public void setYPos(int yPos)
	{ 
		this.yPos = yPos;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public int getDirection()
	{ 
		return direction;
	}
	
	public void setDirection (int direction)
	{
		this.direction = direction;
	}
	//public void touch(character character, item item) 
}
