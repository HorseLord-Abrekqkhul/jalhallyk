import java.awt.Image;


public class Door extends Decor{
	
	private boolean open;
	
	public Door(int xPos, int yPos, Image name, boolean open) {
		super(xPos,yPos,name);
		this.open=open;
	}
	
	public void setOpen(boolean open) {
		this.open=open;
	}
	
	public boolean getOpen() {
		return this.open;
	}

}
