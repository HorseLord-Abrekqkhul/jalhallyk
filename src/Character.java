import java.util.ArrayList;


public class Character {

	protected int lifePoint;
	protected int xPos;
	protected int yPos;
	protected int speed;
	protected int direction; //1 = haut, 2 = bas, 3 =droite, 4 = gauche
	private int actualFrame = 1;
	private int mytick = 0;
	private ImageAnimeDirection image;
	
	
	public Character(int lifePoint, int xPos, int yPos, int speed, int direction, ImageAnimeDirection image){
		this.lifePoint =  lifePoint;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		this.direction = direction;
		this.image = image;
	}
	
	public void tick(ImageAnimeDirection image, int c) {
		this.mytick++;
		if(this.mytick == c) {
			this.actualFrame++;
			this.mytick = 0;
			if(this.actualFrame == image.getFrames()+1)
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

	public ImageAnimeDirection getIAD()
	{
		return image;
	}

	public void setIAD(ImageAnimeDirection image)
	{
		this.image=image;
	}
	
	public int getLifePoint()
	{
		return lifePoint;	
	}
	
	public void setLifePoint(int lifePoint)
	{
		this.lifePoint = lifePoint;
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
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public int getDirection()
	{ 
		return direction;
	}
	
	public void setDirection (int direction)
	{
		this.direction = direction;
	}
	
	public ArrayList<int[]> getListFrontalPixel() {
		ArrayList<int[]> listFrontalPixel = new ArrayList<int[]>();
		if(direction==2) {
			for(int i=0;i<40;i++) {
				int posPixel[] ={xPos,yPos+i};
				listFrontalPixel.add(posPixel);
			}
		}
		else if(direction==3) {
			for(int i=0;i<40;i++) {
				int posPixel[] ={xPos+40,yPos+i};
				listFrontalPixel.add(posPixel);
			}			
		}
		else if(direction==1) {
			for(int i=0;i<40;i++) {
				int posPixel[] ={xPos+i,yPos+40};
				listFrontalPixel.add(posPixel);
			}			
		}
		else {
			for(int i=0;i<40;i++) {
				int posPixel[] ={xPos+i,yPos};
				listFrontalPixel.add(posPixel);
			}			
		}
		
		return listFrontalPixel;			
	}
	
	public int touch(Decor decor) {
		ArrayList<int[]> listFrontalPixel = this.getListFrontalPixel();
		ArrayList<int[]> listAroundPixel = decor.getListAroundPixel();
		for (int[] a : listFrontalPixel) {
			for(int[] b : listAroundPixel) {
				if(a[0]==b[0] && a[1]==b[1]) { return 0;	}
		}
		}
		return 1;
		
		
	}
	//public void touch(character character, item item) 
}
