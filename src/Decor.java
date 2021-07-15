import java.awt.Image;

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
	

	
}
