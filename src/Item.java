
public class Item {
	private int xPos;
	private int yPos;
	private ImageAnimeDirection IAD;
	private int actualFrame = 1;
	private int mytick = 0;
	private int c;
	
	public Item(int xPos,int yPos,ImageAnimeDirection IAD,int c){
		this.xPos = xPos;
		this.yPos = yPos;
		this.IAD = IAD;
		this.c = c;
		//yolo
	}
	
	public void tick(ImageAnimeDirection image, int c) {
		this.mytick++;
		if(this.mytick == c) {
			this.actualFrame++;
			this.mytick = 0;
			if(this.actualFrame == IAD.getFrames()+1)
				this.actualFrame = 1;
		}
	}
	
	public int getActualFrame(){
		return this.actualFrame;
	}

	public void setActualFrame(int a)
	{
		this.actualFrame=a;
	}
	
	public int getC()
	{ 
		return c;
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
	
	public ImageAnimeDirection getIAD()
	{
		return IAD;
	}

	public void setIAD(ImageAnimeDirection IAD)
	{
		this.IAD = IAD;
	}
}
