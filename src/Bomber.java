
public class Bomber extends Monster {
	
	
	public Bomber (int lifePoint, int xPos, int yPos, int speed,int direction,ImageAnimeDirection image)
	{
		super(lifePoint, xPos, yPos,speed, direction,image);
	}
	
	
	public Bomb throwBomb(int xPos, int yPos, String name, int damage, int direction) {
		
		Bomb bomb = new Bomb (xPos, yPos, name, damage);
		
		if (direction == 1) 	{
			bomb.setYPos(yPos + 3); // dunno si c est 3
			
		}
		else if (direction == 2) 	{
			bomb.setYPos(yPos - 3);		

		}
		else if (direction == 3) 	{
			bomb.setXPos(xPos + 3);		

		}
		else if (direction == 4) 	{
			bomb.setXPos(xPos - 3);		

		}
		
		return bomb;
	}
	// IA 
	

}
