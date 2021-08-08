import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;

public class Decor extends Object {
	
	protected int xPos;
	protected int yPos;
	protected Image image;
	

	public Decor(int xPos, int yPos, Image image) {
		this.xPos=xPos;
		this.yPos=yPos;
		this.image=image;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;		
	}
	
	public void setXPos(int xPos) {
		this.xPos=xPos;
	}
	
	public void setYPos(int yPos) {
		this.yPos=yPos;
	}
	
	public boolean isTouched(Character character) {
		return this.xPos==character.getXPos() && this.yPos==character.getYPos();	
	}
	
	public Image getImage()
	{
		return image;
	}

	public void setImage(Image image)
	{
		this.image = image;
	}
	
	public ArrayList<int[]> listAroundPixel() {
		ArrayList<int[]> listAroundPixel = new ArrayList<int[]>();
		for (int i=0; i<40; i++) {
			int posPixel1[] ={xPos,yPos+i};
			int posPixel2[] ={xPos+40,yPos+i};
			int posPixel3[] ={xPos+i,yPos+40};
			int posPixel4[] ={xPos+i,yPos};
			int posPixel11[] ={xPos+1,yPos+i};
			int posPixel21[] ={xPos+40-1,yPos+i};
			int posPixel31[] ={xPos+i,yPos+40-1};
			int posPixel41[] ={xPos+i,yPos+1};
			int posPixel12[] ={xPos+1+1,yPos+i};
			int posPixel22[] ={xPos+40-1-1,yPos+i};
			int posPixel32[] ={xPos+i,yPos+40-1-1};
			int posPixel42[] ={xPos+i,yPos+1+1};
			int posPixel13[] ={xPos+1+1+1,yPos+i};
			int posPixel23[] ={xPos+40-1-1-1,yPos+i};
			int posPixel33[] ={xPos+i,yPos+40-1-1-1};
			int posPixel43[] ={xPos+i,yPos+1+1+1};
			listAroundPixel.add(posPixel1);
			listAroundPixel.add(posPixel2);
			listAroundPixel.add(posPixel3);
			listAroundPixel.add(posPixel4);
			listAroundPixel.add(posPixel11);
			listAroundPixel.add(posPixel21);
			listAroundPixel.add(posPixel31);
			listAroundPixel.add(posPixel41);
			listAroundPixel.add(posPixel12);
			listAroundPixel.add(posPixel22);
			listAroundPixel.add(posPixel32);
			listAroundPixel.add(posPixel42);
			listAroundPixel.add(posPixel13);
			listAroundPixel.add(posPixel23);
			listAroundPixel.add(posPixel33);
			listAroundPixel.add(posPixel43);
			
			}
		return listAroundPixel;
	}
	
	public ArrayList<ArrayList<int[]>> listAllAroundPixel(List<Decor> list) {
		ArrayList<ArrayList<int[]>> listAllAroundPixel = new ArrayList<ArrayList<int[]>>();
		for(Decor decor : list) {
			listAllAroundPixel.add(decor.listAroundPixel());
		}
		return listAllAroundPixel;
			
	}

	
}
