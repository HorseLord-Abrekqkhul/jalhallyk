public class Decor {
	
	protected int xPos;
	protected int yPos;
	protected String name;
	

	public Decor(int xPos, int yPos, String name) {
		this.xPos=xPos;
		this.yPos=yPos;
		this.name=name;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;		
	}
	
	public String getName() {
		return name;
	}
	
	public void setXPos(int xPos) {
		this.xPos=xPos;
	}
	
	public void setYPos(int yPos) {
		this.yPos=yPos;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public boolean isTouched(int xPos,int yPos) {
		return this.xPos==xPos && this.yPos==yPos;	
	}
	
	
}
