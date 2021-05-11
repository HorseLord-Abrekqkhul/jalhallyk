
public class Ranged extends Monster {
	
	private String name;
	
	public Ranged (int lifePoint, int xPos, int yPos, int speed,int direction,String name)
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
	
	public void fireArrow() // interface?
	{
		arrow arrow = new arrow(xPos, yPos,direction);
	}
	
	public void IARanged(Link Link)
	{
		while (this.xPos != Link.getXPos() || this.yPos != Link.getYPos() )
		{
			if (this.xPos < Link.getXPos() )
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

}
