
public class Projectile extends Damage {
	private int direction;
	public Projectile(int xPos, int yPos,String name, int damage, int direction){
		super(xPos,yPos,name,damage);
		this.direction = direction;
	}
	
	public int getDirection()
	{ 
		return direction;
	}
	
	public void setDirection (int direction)
	{
		this.direction = direction;
	}
	
	public void moveUp ()
	{
		setYPos(getYPos() - 1);
		this.direction = 1;
	}

	public void moveDown ()
	{
		setYPos(getYPos() + 1);
		this.direction = 2;
	}

	public void moveRight ()
	{
		setXPos(getXPos() + 1);
		this.direction = 3;
	}

	public void moveLeft ()
	{
		setXPos(getXPos() - 1);
		this.direction = 4;
	}
}
