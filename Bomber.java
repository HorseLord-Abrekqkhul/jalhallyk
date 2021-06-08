
public class Bomber extends Monster {
	
	private String name;
	
	public Bomber (int lifePoint, int xPos, int yPos, int speed,int direction,String name)
	{
		super(lifePoint, xPos, yPos,speed, direction);
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Bomb throwBomb()
	{
		if (direction == 1)
		{
			return Bomb bomb = new bomb (xPos, yPos + 3); // dunno si c est 3
		}
		else if (direction == 2)
		{
			return Bomb bomb = new bomb (xPos, yPos - 3);

		}
		else if (direction == 3)
		{
			return Bomb bomb = new bomb (xPos + 3, yPos);

		}
		else if (direction == 4)
		{
			return Bomb bomb = new bomb (xPos - 3, yPos);

		}
	}
	// IA 
	

}
