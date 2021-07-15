
import java.util.Random;

public class Boss extends Monster{	
	
	private boolean rage;

	public Boss (int lifePoint, int xPos, int yPos, int speed,int direction,ImageAnimeDirection image, boolean rage)
	{
		super(lifePoint, xPos, yPos,speed, direction,image);
		this.rage = rage;
	}
	
	public boolean getRage()
	{
		return rage;
	}
	
	public void setRage(boolean rage)
	{
		this.rage = rage;
	}
	
	public void rage() // remplace le skinChange
	{
		setRage(true);
	}
	
	/*
	public FireBall1 fireBall1(Link Link) // pas sur
	{
		FireBall1 fireBall1 = new FireBall1(this.xPos, this.yPos, Link.getXPos(),Link.getYPos());
		return fireBall1;
	}
	
	public Fireball2 fireBall2()
	{
		FireBall2 fireBall2 = new FireBall2(this.xPos, this.yPos);
		return fireBall2;
	}
	
	public Thunder thunderBolt(Link Link)
	{
		 return Thunder thunder = new Thunder (Link.getXPos(), Link.getYPos());
	}
	
	public void teleportation(Map map) // dunno
	{
		Random r1 = new Random();
		Random r2 = new Random();
		this.xPos = r1.nextInt(map.getXLimit);
		this.yPos =r2.nextInt(map.getYlimit);
	}
	*/
	// IA
}


