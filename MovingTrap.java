
public class MovingTrap extends Trap {
	
	public MovingTrap(int xPos, int yPos, String name, int damage) {
		super(xPos,yPos,name,damage);
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
		setxpos(xPos + 1);
	}

	public void moveLeft ()
	{
		setXpos(xPos - 1);
	}


}
