
public class Underground extends Monster{
	
	private String name;
	private boolean underGround;
	
	public Underground (int lifePoint, int xPos, int yPos, int speed,int direction,String name, boolean underGround)
	{
		super(lifePoint, xPos, yPos,speed, direction);
		this.name = name;
		this.underGround = underGround;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public boolean getUnderGround()
	{
		return underGround;
	}
	
	public void setUnderGround(boolean underGround)
	{
		this.underGround = underGround;
	}
	
	public void disappear(Link Link)
	{
		setUnderGround(true);
	}
	
	public void appear()
	{
		setUnderGround(false);
	}
	
	public void IA(Link Link)
	// jsais pas ou mettre la condition de appear
	{
		if( this.xPos < Link.getXPos())
		{
			moveRight();
		}
		
		else if (this.xPos > Link.getXPos())
		{
			moveLeft();
		}
		
		else if (this.yPos < Link.getYPos())
		{
			moveUp();
		}
		
		else if (this.yPos > Link.getYPos())
		{
			moveDown();
		}
	}

}
