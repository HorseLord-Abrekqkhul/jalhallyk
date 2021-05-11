
public class Trapped extends Monster {
	

	private String name;
	private boolean hidden; //j ai rajoute ca( a voir si c est juste)
	
	public Trapped (int lifePoint, int xPos, int yPos, int speed,int direction,String name, boolean hidden)
	{
		super(lifePoint, xPos, yPos,speed, direction);
		this.name = name;
		this.hidden = hidden;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public boolean getHidden()
	{
		return hidden;
	}
	
	public void setHidden(boolean hidden)
	{
		this.hidden = hidden;
	}
	
	public void appear()
	{
		this.hidden = false;
	}

}
