
public class SpawnerFireBalls extends Decor {
	
	public SpawnerFireBalls(int xPos, int yPos, String name) {
		super(xPos,yPos,name);
	}
	
	public FireBall1 spawnFireBalls(int xPos, int yPos,ImageAnimeDirection image, int damage, int c,int direction) {
		FireBall1 fireBall = new FireBall1(xPos, yPos, image, damage,c, direction);
		return fireBall;
		
	}
	
}

