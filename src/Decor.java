import java.awt.Image;
import java.util.ArrayList;

public class Decor {
	
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
	
	public ArrayList<int[]> getListAroundPixel() {
		ArrayList<int[]> listFrontalPixel = new ArrayList<int[]>();
		for (int i=0; i<40; i++) {
			int posPixel1[] ={xPos,yPos+i};
			int posPixel2[] ={xPos+40,yPos+i};
			int posPixel3[] ={xPos+i,yPos+40};
			int posPixel4[] ={xPos+i,yPos};
			listFrontalPixel.add(posPixel1);
			listFrontalPixel.add(posPixel2);
			listFrontalPixel.add(posPixel3);
			listFrontalPixel.add(posPixel4);
			}
		return listFrontalPixel;
	}
	

	
}
