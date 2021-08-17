import java.util.ArrayList;
import java.util.List;


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
	
	public ArrayList<int[]> touchList(List<Decor> d){ //changer bomb par link pour mode versus
		ArrayList<int[]> listeDecor = new ArrayList<int[]>();
		for(int i = 0; i< d.size(); i++){
			//System.out.println(this.xPos + " " + this.yPos + " " + d.get(i).getXPos() + " " +d.get(i).getYPos());
			//System.out.println(touch2(this.xPos,this.yPos,d.get(i).getXPos(),d.get(i).getYPos()));
			if(touch2(this.xPos,this.yPos,d.get(i).getXPos(),d.get(i).getYPos()) != -1
					&& d.get(i).getClass() != Floor.class){
				int pos[] = {i,touch2(this.xPos,this.yPos,d.get(i).getXPos(),d.get(i).getYPos())};
				listeDecor.add(pos);
			}
		}
		return listeDecor;
	}
	
	public int touch2(int x1, int y1, int x2, int y2){ //coin supérieur gauche
		if(Math.abs(x1-x2)<30 && Math.abs(y1-y2)<20){
			if(x1-x2 < 0){
				//System.out.println("pd");
				return 0; //GAUCHE
			}
			else{
				//System.out.println("pd");
				return 1; //DROITE
			}
		}
		else if(Math.abs(x1-x2)<20 && 30>Math.abs(y1-y2)){
			if(y1-y2 < 0){
				//System.out.println("pd");
				return 2; //HAUT
			}
			else{
				//System.out.println("pd");
				return 3; //BAS
			}
		}
		else{
			//System.out.println("hihihihi");
			return -1;
		}
	}
}
