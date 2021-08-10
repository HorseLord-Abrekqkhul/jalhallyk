
public class Arrow extends Projectile{
	public Arrow(int xPos, int yPos,ImageAnimeDirection IAD,int c, int damage, int direction){
		super(xPos,yPos,IAD,c,damage,direction);
	}
	
	private int t = 0;
	private int mytick;
	
	public void tick(){
		this.mytick++;
		if(this.mytick == 5) {
			this.t++;
			this.mytick = 0;
		}
	}
	
	public int getTime(){
		return this.t;
	}
	
}
