
public class Projectile extends Damage {
	private int direction;
	public Projectile(int xPos, int yPos,ImageAnimeDirection IAD,int c, int damage, int direction){
		super(xPos,yPos,IAD,c,damage);
		this.direction = direction;
	}
	
	
	public int getDirection()
	{ 
		return direction;
	}
	
	public void setDirection (int direction)
	{
		this.direction = direction;
	}
	
	public void move(){
		if(direction == 0){
			setXPos(getXPos() - 10);
			tick(getIAD(),getC());
		}
		if(direction == 1){
			setXPos(getXPos() + 10);
			tick(getIAD(),getC());
		}
		if(direction == 2){
			setYPos(getYPos() - 10); //panel 
			tick(getIAD(),getC());
		}
		if(direction == 3){
			setYPos(getYPos() + 10); //panel
			tick(getIAD(),getC());
		}
	}
}
	