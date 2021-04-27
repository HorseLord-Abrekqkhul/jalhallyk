
public class Item {
	private int xPos;
	private int yPos;
	private String name;
	
	public Item(int xPos,int yPos,String name){
		this.xPos = xPos;
		this.yPos = yPos;
		this.name = name;
		//yolo
	}
	
	public int getXPos()
	{ 
		return xPos;
	}
	
	public void setXPos(int xPos)
	{
		this.xPos = xPos;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public void setYPos(int yPos)
	{ 
		this.yPos = yPos;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
