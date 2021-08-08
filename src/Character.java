import java.util.ArrayList;


public class Character {

	protected int lifePoint;
	protected int xPos;
	protected int yPos;
	protected int speed;
	protected int direction; // 0 GAUCHE, 1 DROITE, 2 HAUT, 3 BAS
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
	
	public ArrayList<int[]> virtualMovement() {
		ArrayList<int[]> virtualMovement = new ArrayList<int[]>() ; // 0 GAUCHE, 1 DROITE, 2 HAUT, 3 BAS
		if(direction==0) {
			for(int i=10;i<30;i++) {
				int posPixel[] ={xPos-1,yPos+i};
				int posPixel2[]={xPos-2,yPos+i};
				virtualMovement.add(posPixel);
				virtualMovement.add(posPixel2);
			}
		}
		if(direction==1) {
			for(int i=10;i<30;i++) {
				int posPixel[] ={xPos+41,yPos+i};
				int posPixel2[]={xPos+42,yPos+i};
				virtualMovement.add(posPixel);
				virtualMovement.add(posPixel2);
			}
		}
		if(direction==02) {
			for(int i=10;i<30;i++){
				int posPixel[] ={xPos+i,yPos-1};
				int posPixel2[]={xPos+i,yPos-2};
				virtualMovement.add(posPixel);
				virtualMovement.add(posPixel2);
			}
		}
		if(direction==3) {
			for(int i=10;i<30;i++) {
				int posPixel[] ={xPos+i,yPos+41};
				int posPixel2[]={xPos+i,yPos+42};
				virtualMovement.add(posPixel);
				virtualMovement.add(posPixel2);
			}
		}
		return virtualMovement;
		
	}
	
	public int touch(ArrayList<ArrayList<int[]>> list) {
		ArrayList<int[]> virtualMovement = this.virtualMovement();
		for(int[] posLink : virtualMovement) {
			for (ArrayList<int[]> liste : list) {
				for(int[] posDecor : liste) {
					if(posLink[0]==posDecor[0] && posLink[1]==posDecor[1]) {
						System.out.println("Ca touche");
						System.out.println(posDecor[0] + " " + posDecor[1]);
						return 0;
					}
				}
			}			
		}
		System.out.println("Ca touche pas hihihi");
		return 1;
	}
	
	/* public ArrayList<int[]> getListFrontalPixel() {
		ArrayList<int[]> listFrontalPixel = new ArrayList<int[]>();
		if(direction==2) {
			for(int i=0;i<40;i++) {
				int posPixel[] ={xPos,yPos+i};
				int posPixel2[]={xPos-1,yPos+i};
				listFrontalPixel.add(posPixel);
				listFrontalPixel.add(posPixel2);
			}
		}
		else if(direction==3) {
			for(int i=0;i<40;i++) {
				int posPixel[] ={xPos+40,yPos+i};
				int posPixel2[] ={xPos+40-1,yPos+i};
				listFrontalPixel.add(posPixel);
				listFrontalPixel.add(posPixel2);
			}			
		}
		else if(direction==1) {
			for(int i=0;i<40;i++) {
				int posPixel[] ={xPos+i,yPos+40};
				int posPixel2[] ={xPos+i,yPos+40-1};
				listFrontalPixel.add(posPixel);
				listFrontalPixel.add(posPixel2);
			}			
		}
		else {
			for(int i=0;i<40;i++) {
				int posPixel[] ={xPos+i,yPos};
				int posPixel2[] ={xPos+i,yPos-1};
				
				listFrontalPixel.add(posPixel);
				listFrontalPixel.add(posPixel2);
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
	//public void touch(character character, item item) */
	
	
}
