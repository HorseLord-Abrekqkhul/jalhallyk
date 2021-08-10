import java.util.List;


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
	
	public int move(List<Decor> d,List<Bomb> b, List<Monster> monster){
		int k = 1;
		for(int j = 0; j < touchList(d,b,monster).get(0).size(); j++){
			if(touchList(d,b,monster).get(0).get(j)[1] != -1){
				//System.out.println(touchList(d,b,monster).get(0).get(j)[1]);
				k = 0;
				//d.remove(touchList(d,b,monster).get(0).get(j)[0]);
			}
		}
		if(direction == 0){
			setXPos(getXPos() - 10*k);
			tick(getIAD(),getC());
		}
		if(direction == 1){
			setXPos(getXPos() + 10*k);
			tick(getIAD(),getC());
		}
		if(direction == 2){
			setYPos(getYPos() - 10*k); //panel 
			tick(getIAD(),getC());
		}
		if(direction == 3){
			setYPos(getYPos() + 10*k); //panel
			tick(getIAD(),getC());
		}
		return k;
	}
	
}
	