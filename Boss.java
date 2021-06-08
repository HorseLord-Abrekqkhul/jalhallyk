
import java.util.Random;

public class Boss extends Monster{	
	
	private String name;
	private boolean rage;

	public Boss (int lifePoint, int xPos, int yPos, int speed,int direction,String name, boolean rage)
	{
		super(lifePoint, xPos, yPos,speed, direction);
		this.name = name;
		this.rage = rage;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
	
	public FireBall1 fireBall1(Link Link) // pas sur
	{
		return FireBall1 fireBall1 = new fireBall1(this.xPos, this.yPos, Link.getXPos(),Link.getYPos());
	}
	
	public Fireball2 fireBall2()
	{
		return FireBall2 fireBall2 = new fireBall2(this.xPos, this.yPos);
	}
	
	public Thunder thunderBolt(Link Link)
	{
		 return Thunder thunder = new thunder (Link.getXPos(), Link.getYPos());
	}
	
	public void teleportation(Map map) // dunno
	{
		Random r1 = new Random();
		Random r2 = new Random();
		this.xPos = r1.nextInt(map.getXLimit);
		this.yPos =r2.nextInt(map.getYlimit);
	}
	// IA
}


