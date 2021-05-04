
public class Decor {
	
	protected int xPos;
	protected int yPos;
	protected String name;
	

	public Decor(int xPos, int yPos, String name) {
		this.xPos=xPos;
		this.yPos=yPos;
		this.name=name;
	}
	
	
	//public boolean IsTouched() {}
	
	public int getXpos() {
		return xPos;
	}
	
	public int getYpos() {
		return yPos;		
	}
	
	public String getName() {
		return name;
	}
	
	public void setXpos(int xPos) {
		this.xPos=xPos;
	}
	
	public void setYpos(int yPos) {
		this.yPos=yPos;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	
}
