
public class SpawnerFireBalls extends Decor {
	
	public SpawnerFireBalls(int xPos, int yPos, String name) {
		super(xPos,yPos,name);
	}
	
	public FireBall1 spawnFireBalls(int xPos, int yPos,String name, int damage, int direction) {
		FireBall1 fireBall = new FireBall1(xPos, yPos, name, damage, direction);
		return fireBall;
		
	}
	
}

