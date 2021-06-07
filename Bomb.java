
public class Bomb extends Decor {
	
	public Bomb(int xPos, int yPos, String name)
	{
		super(xPos,yPos,name);		
	}
	
	public void explosion ()
	{
		BombDeflagration bombDeflagration = new bombDeflagration(xPos, yPos, 2, name);
	}

}
