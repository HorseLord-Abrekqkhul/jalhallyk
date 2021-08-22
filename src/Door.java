import java.awt.Image;


public class Door extends Decor{
	
	private boolean open;
	private int line;
	private int column;
	
	public Door(int xPos, int yPos, Image name, boolean open,int line,int column) {
		super(xPos,yPos,name);
		this.open =open;
		this.line = line;
		this.column = column;
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public boolean getOpen() {
		return this.open;
	}
	public void setLine(int line) {
		this.line = line;
	}
	
	public int getLine() {
		return this.line;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	public int getColumn() {
		return this.column;
	}

}
