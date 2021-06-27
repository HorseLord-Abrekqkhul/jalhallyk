
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
	
	public Arrow fireArrow(int xPos, int yPos, String name, int damage, int direction) // interface?
	{
		Arrow arrow = new Arrow(xPos, yPos, name, damage, direction);
		return arrow;
	}
	
	public void IARanged(Link Link)
	{
		while (this.xPos != Link.getXPos() || this.yPos != Link.getYPos() )
		{
			if (this.xPos < Link.getXPos() )
			{
				moveRight();
				direction = 3;
			}
			
			else if (this.xPos > Link.getXPos())
			{
				moveLeft();
				direction =4;
			}
			
			else if (this.yPos < Link.getYPos())
			{
				moveUp();
				direction = 1;
			}
			
			else if (this.yPos > Link.getYPos())
			{
				moveDown();
				direction = 2;
			}
			else if (this.xPos == Link.getXPos() && this.yPos < Link.getYPos())  // attention aux decors
			{
				//fireArrow(1);
			}
			else if (this.xPos == Link.getXPos() && this.yPos > Link.getYPos())
			{
				//fireArrow(2);
			}
			else if (this.yPos == Link.getYPos() && this.xPos < Link.getXPos())
			{
				//fireArrow(3);
			}
			else if (this.yPos == Link.getYPos() && this.xPos < Link.getXPos())
			{
				//fireArrow(4);
			}
		}
		
	}

}
